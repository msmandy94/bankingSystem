package com.example.bankingSystem.controllers;

/**
 * Created by mandeep.singh on 1:30 AM 23/03/21 Tuesday
 */

import com.example.bankingSystem.entities.DAOUser;
import com.example.bankingSystem.model.*;
import com.example.bankingSystem.service.AccountService;
import com.example.bankingSystem.service.CustomerManagementService;
import com.example.bankingSystem.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankingSystem.service.JwtUserDetailsService;


import com.example.bankingSystem.config.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CustomerManagementService customerManagementService;

    @Autowired
    private AccountService accountService;
    // for users (admin and employee)
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.ADMIN.name())) {
            return ResponseEntity.ok(userManagementService.addEmployee(employeeDTO));
        }
        return new ResponseEntity<>("user is not admin", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.ADMIN.name())) {
            int rowsAffected = userManagementService.deleteEmployee(employeeDTO);
            if (rowsAffected == 0) {
                return ResponseEntity.ok("employee doesn't exists");
            }
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not admin", null, HttpStatus.UNAUTHORIZED);
    }

    // EMPLOYEE
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            customerManagementService.addCustomer(customerDTO);
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            customerManagementService.deleteCustomer(customerDTO);
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/updateKYCCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> updateKYCCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            customerManagementService.updateKYC(customerDTO);
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }


    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public ResponseEntity<?> addAccount(@RequestBody AccountDTO accountDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            accountService.addAccount(accountDTO);
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/linkAccountWithCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> linkAccountWithCustomer(@RequestBody AccountDTO accountDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            accountService.linkAccount(accountDTO.getId(), accountDTO.getCustomerId());
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/getAccount", method = RequestMethod.POST)
    public ResponseEntity<?> getAccount(@RequestBody AccountDTO accountDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            accountService.getAccountDetails(accountDTO.getId());
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
    public ResponseEntity<?> transferMoney(@RequestBody TransferMoneyDTO transferMoneyDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.EMPLOYEE.name())) {
            accountService.transferMoney(transferMoneyDTO.getSrcAccount(), transferMoneyDTO.getDestAccount(), transferMoneyDTO.getAmount());
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not EMPLOYEE", null, HttpStatus.UNAUTHORIZED);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

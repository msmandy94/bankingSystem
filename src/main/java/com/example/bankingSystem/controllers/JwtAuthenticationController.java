package com.example.bankingSystem.controllers;

/**
 * Created by mandeep.singh on 1:30 AM 23/03/21 Tuesday
 */

import com.example.bankingSystem.model.*;
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
public class JwtAuthenticationController {

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
        if (user.getType().equals(UserType.ADMIN.name())){
            return ResponseEntity.ok(userManagementService.addEmployee(employeeDTO));
        }
        return new ResponseEntity<>("user is not admin", null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        String userName = jwtTokenUtil.getUserNameFromRequest(request);
        DAOUser user = userManagementService.getUserByUserName(userName);
        if (user.getType().equals(UserType.ADMIN.name())){
            userManagementService.deleteEmployee(employeeDTO);
            return ResponseEntity.ok("ok");
        }
        return new ResponseEntity<>("user is not admin", null, HttpStatus.UNAUTHORIZED);
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

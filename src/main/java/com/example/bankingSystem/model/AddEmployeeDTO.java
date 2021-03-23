package com.example.bankingSystem.model;

/**
 * Created by mandeep.singh on 8:59 AM 23/03/21 Tuesday
 */
public class AddEmployeeDTO {
    String employeeUserName;
    String employeePassword;

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}

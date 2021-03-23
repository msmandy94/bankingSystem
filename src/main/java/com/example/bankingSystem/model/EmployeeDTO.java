package com.example.bankingSystem.model;

/**
 * Created by mandeep.singh on 8:59 AM 23/03/21 Tuesday
 */
public class EmployeeDTO {
    int id;
    String employeeUserName;
    String employeePassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

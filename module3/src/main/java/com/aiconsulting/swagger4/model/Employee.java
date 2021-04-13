package com.aiconsulting.swagger4.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name="employee")
public class Employee {

    private Long employeeId;
    private String firstname;
    @NotNull
    @ApiModelProperty(value="this is the family name", required = true)
    private String lastname;
    @ApiModelProperty(value="employee's lunar age")
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

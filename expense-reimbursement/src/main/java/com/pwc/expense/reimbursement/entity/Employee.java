package com.pwc.expense.reimbursement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long employeeId;
    private String name;
    private String email;
    private String password;
    private String location;
    private Long number;
    private String team;
//    @OneToMany(
//            mappedBy = "employee",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<Expense> expenses = new HashSet<>();


    public Employee(){

    }

    public Employee(Long employeeId, String name, String email, String password, String location, Long number, String team) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
        this.number = number;
        this.team = team;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", number=" + number +
                ", team='" + team + '\'' +

                '}';
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

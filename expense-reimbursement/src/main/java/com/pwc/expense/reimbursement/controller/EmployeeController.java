package com.pwc.expense.reimbursement.controller;


import com.pwc.expense.reimbursement.entity.Employee;
import com.pwc.expense.reimbursement.entity.Expense;
import com.pwc.expense.reimbursement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employee/")
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {


    String pending = "pending";
    String approved= "approved";
    String denied = "denied";
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("{id}/information")
    public ResponseEntity<Employee> viewInformation(@PathVariable("id") Long employeeId){
        Employee data = employeeService.viewInformation(employeeId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Long> authenticateUser(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.authenticateUser(employee.getEmail(), employee.getPassword()),HttpStatus.OK);
    }


    @PutMapping("{id}/update")
    public ResponseEntity<Employee> updateInformation(@PathVariable("id") Long Id,
                                           @RequestBody Employee employee){
        Employee data = employeeService.updateInformation(Id, employee);
        return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}/pending")
    public ResponseEntity<List<Expense>> viewPendingExpenses(@PathVariable("id") Long id){
        List<Expense> data = employeeService.viewPendingExpense(id,pending);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("{id}/approved")
    public ResponseEntity<List<Expense>> viewApprovedExpenses(@PathVariable("id") Long id){
        List<Expense> data = employeeService.viewPendingExpense(id,approved);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("{id}/denied")
    public ResponseEntity<List<Expense>> viewDeniedExpenses(@PathVariable("id") Long id){
        List<Expense> data = employeeService.viewPendingExpense(id,denied);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PostMapping("{id}/add")
    public ResponseEntity<Expense> addExpense(@PathVariable("id") Long id, @RequestBody Expense expense){
        Expense data = employeeService.addExpense(id,expense);
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }
}

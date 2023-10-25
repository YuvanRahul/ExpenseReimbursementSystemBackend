package com.pwc.expense.reimbursement.controller;

import com.pwc.expense.reimbursement.entity.Employee;
import com.pwc.expense.reimbursement.entity.Expense;
import com.pwc.expense.reimbursement.entity.Manager;
import com.pwc.expense.reimbursement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/manager/")
@RestController
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    String pending = "pending";
    String approved= "approved";
    String denied = "denied";

    @GetMapping("/pending")
    public ResponseEntity<List<Expense>> getPendingExpenses(){
        List<Expense> data = managerService.getPendingExpenses(pending);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Expense>> getApprovedExpenses(){
        List<Expense> data = managerService.getPendingExpenses(approved);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/denied")
    public ResponseEntity<List<Expense>> getDeniedExpenses(){
        List<Expense> data = managerService.getPendingExpenses(denied);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/pending/{empid}")
    public  ResponseEntity<List<Expense>> getPendingById( @PathVariable("empid") Long empid){
        List<Expense> data = managerService.getPendingById(empid,pending);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticateUser(@RequestBody Manager manager){
        return new ResponseEntity<>(managerService.authenticateUser(manager.getEmail(), manager.getPassword()),HttpStatus.OK);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> data = managerService.getAllEmployees();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/manage/{expenseId}/{status}")
    public ResponseEntity<Expense> manageExpense(@PathVariable("status") String status,
    @PathVariable("expenseId") Long expenseid ){
        Expense data = managerService.manageExpense(expenseid,status);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

}

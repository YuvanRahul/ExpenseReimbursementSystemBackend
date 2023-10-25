package com.pwc.expense.reimbursement.service.impl;

import com.pwc.expense.reimbursement.entity.Employee;
import com.pwc.expense.reimbursement.entity.Expense;
import com.pwc.expense.reimbursement.repository.EmployeeRepository;
import com.pwc.expense.reimbursement.repository.ExpenseRepository;
import com.pwc.expense.reimbursement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Long id, Expense expense) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        expense.setEmployeeId(id);
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> viewPendingExpense(Long id,String status) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Wrong Id Entered"));

        return expenseRepository.findByEmployeeIdAndStatus(id, status);
    }

    @Override
    public List<Expense> viewDeniedExpense(Long employeeId,String status) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Wrong Id Entered"));
        return expenseRepository.findByEmployeeIdAndStatus(employeeId,status);
    }

    @Override
    public List<Expense> viewApprovedExpense(Long employeeId,String status) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Wrong Id Entered"));
        return expenseRepository.findByEmployeeIdAndStatus(employeeId,status);
    }

    @Override
    public Employee viewInformation(Long id) {
        //display the necessary fields only
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Wrong Id Entered"));
    }


    @Override
    public Employee updateInformation(Long id,Employee employee) {
        Employee employee1 = employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("resource not found"));
        // get updated data
        employee1.setNumber(employee.getNumber());
        employee1.setPassword(employee.getPassword());
        employee1.setLocation(employee.getLocation());
        employee1.setTeam(employee.getTeam());
        // save the changes
        return employeeRepository.save(employee1);

    }

    @Override
    public Long authenticateUser(String email, String password) {


         if(employeeRepository.existsByEmailAndPassword(email,password)){
             Employee employee = employeeRepository.findByEmail(email);
             return employee.getEmployeeId();
         }else return null;
    }
}

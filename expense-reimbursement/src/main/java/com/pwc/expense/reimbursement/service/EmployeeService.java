package com.pwc.expense.reimbursement.service;

import com.pwc.expense.reimbursement.entity.Employee;
import com.pwc.expense.reimbursement.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Expense addExpense(Long id,Expense expense);
    List<Expense> viewPendingExpense(Long id,String status);
    List<Expense> viewDeniedExpense(Long id,String status);
    List<Expense> viewApprovedExpense(Long id,String status);
    Employee viewInformation(Long id);
    Employee updateInformation(Long id, Employee employee);

    Long authenticateUser(String email,String password);
}

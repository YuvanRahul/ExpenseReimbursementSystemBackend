package com.pwc.expense.reimbursement.service;

import com.pwc.expense.reimbursement.entity.Employee;
import com.pwc.expense.reimbursement.entity.Expense;

import java.util.List;

public interface ManagerService {
    List<Expense> getPendingExpenses(String status);
    List<Expense> getApprovedExpenses(String status);
    List<Expense> getDeniedExpenses(String status);
    List<Expense> getPendingById(Long Id,String status);
    List<Employee> getAllEmployees();
    Expense manageExpense(Long id, String status);
    Boolean authenticateUser(String email,String password);
}

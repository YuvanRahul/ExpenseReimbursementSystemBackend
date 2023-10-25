package com.pwc.expense.reimbursement.service.impl;

import com.pwc.expense.reimbursement.entity.Employee;
import com.pwc.expense.reimbursement.entity.Expense;
import com.pwc.expense.reimbursement.repository.EmployeeRepository;
import com.pwc.expense.reimbursement.repository.ExpenseRepository;
import com.pwc.expense.reimbursement.repository.ManagerRepository;
import com.pwc.expense.reimbursement.service.EmployeeService;
import com.pwc.expense.reimbursement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getPendingExpenses(String status) {

        return expenseRepository.findByStatus(status);
    }


    @Override
    public Boolean authenticateUser(String email, String password) {
        return managerRepository.existsByEmailAndPassword(email,password);
    }
    @Override
    public List<Expense> getApprovedExpenses(String status) {
        return expenseRepository.findByStatus(status);
    }

    @Override
    public List<Expense> getDeniedExpenses(String status) {
        return expenseRepository.findByStatus(status);
    }


    @Override
    public List<Expense> getPendingById(Long Id, String status) {
        Employee employee = employeeRepository
                .findById(Id)
                .orElseThrow(() -> new RuntimeException("Wrong Id Entered"));
        return expenseRepository.findByEmployeeIdAndStatus(Id,status);
    }

    @Override
    public List<Employee> getAllEmployees() {
        //in react display only those fields needed. like employee.name. see book example
        return employeeRepository.findAll();
    }

    @Override
    public Expense manageExpense(Long id, String status) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wrong Id Entered"));
        expense.setStatus(status);
        return expenseRepository.save(expense);
    }
}

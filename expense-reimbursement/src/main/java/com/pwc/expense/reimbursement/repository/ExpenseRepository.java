package com.pwc.expense.reimbursement.repository;

import com.pwc.expense.reimbursement.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByStatus(String status);
    List<Expense> findByEmployeeId(Long employeeId);
    List<Expense> findByEmployeeIdAndStatus(Long employeeId, String status);
}

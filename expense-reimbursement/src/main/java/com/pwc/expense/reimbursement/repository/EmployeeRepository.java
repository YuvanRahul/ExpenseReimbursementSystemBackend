package com.pwc.expense.reimbursement.repository;

import com.pwc.expense.reimbursement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);
}

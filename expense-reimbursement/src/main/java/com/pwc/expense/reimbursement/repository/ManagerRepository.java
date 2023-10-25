package com.pwc.expense.reimbursement.repository;

import com.pwc.expense.reimbursement.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {

    Boolean existsByEmailAndPassword(String email, String password);
}

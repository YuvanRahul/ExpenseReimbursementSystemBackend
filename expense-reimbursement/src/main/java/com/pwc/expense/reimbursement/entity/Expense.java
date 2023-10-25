package com.pwc.expense.reimbursement.entity;

import javax.persistence.*;

@Entity
public class Expense {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long expenseId;
    private String name;
    private String description;
    private Long amount;

    private String status;

//    @ManyToOne(
//            fetch = FetchType.LAZY
//    )
//
//    @JoinColumn(
//            name = "employee_id",
//            nullable = false
//    )
    private Long employeeId;



    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    public Expense(){

    }
    public Expense(Long expenseId, String name, String description, Long amount, String status, Long employeeId) {
        this.expenseId = expenseId;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.employeeId = employeeId;
    }
}

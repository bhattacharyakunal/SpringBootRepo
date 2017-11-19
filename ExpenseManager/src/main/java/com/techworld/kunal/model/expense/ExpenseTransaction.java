package com.techworld.kunal.model.expense;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EXPENSE_TRANSACTION")
public class ExpenseTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long transactionId;
	private Long expenseCategoryId;
	private Long expenseCategoryTypeId;
	private double amount;
	private Date expenseDate;
	private String remarks;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getExpenseCategoryId() {
		return expenseCategoryId;
	}
	public void setExpenseCategoryId(Long expenseCategoryId) {
		this.expenseCategoryId = expenseCategoryId;
	}
	public Long getExpenseCategoryTypeId() {
		return expenseCategoryTypeId;
	}
	public void setExpenseCategoryTypeId(Long expenseCategoryTypeId) {
		this.expenseCategoryTypeId = expenseCategoryTypeId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

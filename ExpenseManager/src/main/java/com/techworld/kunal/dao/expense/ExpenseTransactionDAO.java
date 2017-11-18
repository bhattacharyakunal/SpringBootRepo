package com.techworld.kunal.dao.expense;

import org.springframework.data.repository.CrudRepository;

import com.techworld.kunal.model.expense.ExpenseTransaction;

public interface ExpenseTransactionDAO extends CrudRepository<ExpenseTransaction, Long> {

}

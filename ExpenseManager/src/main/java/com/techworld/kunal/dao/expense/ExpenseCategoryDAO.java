package com.techworld.kunal.dao.expense;

import org.springframework.data.repository.CrudRepository;

import com.techworld.kunal.model.expense.ExpenseCategory;

public interface ExpenseCategoryDAO extends CrudRepository<ExpenseCategory, Long> {

}

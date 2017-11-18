package com.techworld.kunal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techworld.kunal.dao.expense.ExpenseCategoryDAO;
import com.techworld.kunal.dao.expense.ExpenseCategoryTypeDAO;
import com.techworld.kunal.dao.expense.ExpenseTransactionDAO;
import com.techworld.kunal.model.expense.ExpenseCategory;
import com.techworld.kunal.model.expense.ExpenseCategoryType;
import com.techworld.kunal.model.expense.ExpenseTransaction;
import com.techworld.kunal.util.Constants;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseCategoryDAO expenseCategoryDAO;
	@Autowired
	ExpenseCategoryTypeDAO expenseCategoryTypeDAO;
	@Autowired
	ExpenseTransactionDAO expenseTransactionDAO;
	
	public String addExpenseCategory(ExpenseCategory expenseCategory) {
		expenseCategoryDAO.save(expenseCategory);
		return Constants.EXPENSE_CATEGORY_ADDED_SUCCESSFULLY;
	}
	
	public String addExpenseCategoryType(ExpenseCategoryType expenseCategoryType) {
		expenseCategoryTypeDAO.save(expenseCategoryType);
		return Constants.EXPENSE_CATEGORY_TYPE_ADDED_SUCCESSFULLY;
	}
	
	public String addExpenseTransaction(ExpenseTransaction expenseTransaction) {
		expenseTransactionDAO.save(expenseTransaction);
		return Constants.EXPENSE_ADDED_SUCCESSFULLY;
	}
}

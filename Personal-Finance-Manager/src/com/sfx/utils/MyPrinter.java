package com.sfx.utils;

import com.sfx.pojo.Budget;
import com.sfx.pojo.User;
import com.sfx.transaction.ExpenseTransaction;
import com.sfx.transaction.Transaction;

public class MyPrinter {

	private static MyPrinter printer;

	private MyPrinter() {

	}

	public void printTransaction(Transaction transaction) {
		System.out.println("Category - " + transaction.getTrasactionCategory() + ", Amount - "
				+ transaction.getTransactionAmount());
	}

	public void budgetExceededReminder(Budget budget, ExpenseTransaction expenseTransaction) {
		System.out.println();
		System.out.println("You are out of budget !");
		System.out.println();
		System.out.println("Budget details :");
		this.budgetPrinter(budget);
		System.out.println();
		System.out.println("Last transaction details : ");
		this.printTransaction(expenseTransaction);
		System.out.println();
	}

	public void budgetPrinter(Budget budget) {
		System.out.println("Amount - " + budget.getBudget() + ", Budget Category - " + budget.getBudgetCategory());
	}
	
	public void expenseTransactionLog() {
		System.out.println("Choose expense type :");
		System.out.println("1.) Grocery");
		System.out.println("2.) Entertainment");
	}
	
	public void budgetCategoryLog() {
		System.out.println("Choose budget for :");
		System.out.println("1.) Grocery");
		System.out.println("2.) Entertainment");
	}
	
	public void incomeTransactionLog() {
		System.out.println("Choose income type :");
		System.out.println("1.) Salary");
		System.out.println("2.) Business");
	}
	
	public void financialReportLog() {
		System.out.println("Choose an option :");
		System.out.println("1.) Financial report for Grocery expense");
		System.out.println("2.) Financial report for Entertainment expense");
		System.out.println("3.) Financial report for Salary income");
		System.out.println("4.) Financial report for Business income");
	}
	
	public void success() {
		System.out.println("Success !");
	}

	public static MyPrinter getInstance() {
		if (printer == null) {
			printer = new MyPrinter();
		}
		return printer;
	}

	public void goalTrackingLong(User user) {
		System.out.println("Below are the goal tracking details : ");
		System.out.println("Your goals : " + user.getGoal());
		System.out.println("Your progress : "+ user.getIncome());
	}

}

package com.sfx.factory;

import com.sfx.budget.observers.BudgetObservable;
import com.sfx.budget.observers.EntertainmentBudgetObservable;
import com.sfx.budget.observers.GroceryBudgetObservable;
import com.sfx.enums.ExpenseCategoryEnum;
import com.sfx.exception.CustomException;

public class BudgetObservableFactory {

	public static BudgetObservable findBudgetObservable(ExpenseCategoryEnum category) {

		BudgetObservable budgetObservable;

		switch (category) {
		case GROCERY:
			budgetObservable = new GroceryBudgetObservable();
			break;
		case ENTERTAINMENT:
			budgetObservable = new EntertainmentBudgetObservable();
			break;
		default:
			throw new CustomException("Budget observable not found !");
		}

		return budgetObservable;
	}

}

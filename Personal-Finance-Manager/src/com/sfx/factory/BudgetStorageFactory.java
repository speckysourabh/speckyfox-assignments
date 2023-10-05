package com.sfx.factory;

import com.sfx.db.BudgetStorage;
import com.sfx.db.EntertainmentBudgetStorage;
import com.sfx.db.GroceryBudgetStorage;
import com.sfx.enums.ExpenseCategoryEnum;
import com.sfx.exception.CustomException;

public class BudgetStorageFactory {

	public static BudgetStorage findBudgetStorage(ExpenseCategoryEnum category) {

		BudgetStorage budgetStorage;

		switch (category) {
		case GROCERY:
			budgetStorage = new GroceryBudgetStorage();
			break;
		case ENTERTAINMENT:
			budgetStorage = new EntertainmentBudgetStorage();
			break;
		default:
			throw new CustomException("Budget storage not found !");
		}

		return budgetStorage;
	}

}

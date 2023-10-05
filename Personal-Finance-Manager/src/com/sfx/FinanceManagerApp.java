package com.sfx;

import java.util.List;
import java.util.Scanner;

import com.sfx.db.ExpenseTransactionStorage;
import com.sfx.db.IncomeTransactionStorage;
import com.sfx.db.TransactionStorage;
import com.sfx.db.UserStorage;
import com.sfx.enums.ExpenseCategoryEnum;
import com.sfx.enums.GoalEnum;
import com.sfx.enums.IncomeCategoryEnum;
import com.sfx.exception.CustomException;
import com.sfx.pojo.Budget;
import com.sfx.pojo.Goal;
import com.sfx.pojo.User;
import com.sfx.transaction.BusinessTransaction;
import com.sfx.transaction.EntertainmentTransaction;
import com.sfx.transaction.ExpenseTransaction;
import com.sfx.transaction.GroceryTransaction;
import com.sfx.transaction.IncomeTransaction;
import com.sfx.transaction.SalaryTransaction;
import com.sfx.transaction.Transaction;
import com.sfx.utils.MyPrinter;

public class FinanceManagerApp {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		FinanceManagerApp app = new FinanceManagerApp();

		while (true) {

			try {

				System.out.println("Welcome to 'Personal finance Manager' app");
				System.out.println("Choose an option :");
				System.out.println("1.) Register");
				System.out.println("2.) Login");
				System.out.println("3.) Exit");

				UserStorage userStorage = new UserStorage();
				int choice = scanner.nextInt();
				User user = null;

				switch (choice) {
				case 1: {
					System.out.println("Enter your name :");
					scanner.nextLine();
					String name = scanner.nextLine();
					System.out.println("Enter your password :");
					String password = scanner.next();
					user = new User(name, password);
					userStorage.saveUser(user);
					continue;
				}
				case 2: {
					System.out.println("Enter your name :");
					scanner.nextLine();
					String name = scanner.nextLine();
					System.out.println("Enter your password :");
					String password = scanner.next();
					user = new User(name, password);
					if (!userStorage.isUserExist(user)) {
						throw new CustomException("User not exist !");
					}
					break;
				}
				case 3: {
					System.exit(0);
				}
				default: {
				}
				}

				while (true) {

					System.out.println("Choose an option: ");
					System.out.println("1.) Save income transaction");
					System.out.println("2.) Save expense transaction");
					System.out.println("3.) Set budget");
					System.out.println("4.) Print financial report");
					System.out.println("5.) Set saving goal");
					System.out.println("6.) Track saving goal");
					System.out.println("0.) Logout");

					choice = scanner.nextInt();
					boolean flag = false;

					switch (choice) {
					case 0: {
						flag = true;
						break;
					}
					case 1: {
						app.saveIncomeTransaction(user);
						break;
					}
					case 2: {
						app.saveExpenseTransaction(user);
						break;
					}
					case 3: {
						app.setBudget(user);
						break;
					}
					case 4: {
						app.printFinancialReport(user);
						break;
					}
					case 5: {
						app.setSavingGoal(user);
						break;
					}
					case 6: {
						app.trackSavingGoal(user);
						break;
					}
					default: {
						throw new CustomException("Wrong choice");
					}
					}
					if (flag) {
						break;
					}
				}

			} catch (Exception ex) {

				System.out.println(ex.getLocalizedMessage());

			}

		}

	}

	private void trackSavingGoal(User user) {
		MyPrinter.getInstance().goalTrackingLong(user);
	}

	private void setSavingGoal(User user) {
		System.out.println("Enter goal amount : ");
		long amount = scanner.nextLong();
		Goal goal = new Goal(GoalEnum.SAVING, amount);
		user.setGoal(goal);
		MyPrinter.getInstance().success();
	}

	public void printFinancialReport(User user) {
		MyPrinter.getInstance().financialReportLog();
		TransactionStorage expenseTransactionStorage = ExpenseTransactionStorage.getInstance();
		TransactionStorage incomeTransactionStorage = IncomeTransactionStorage.getInstance();
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			List<Transaction> items = expenseTransactionStorage.getItems();
			items.stream().filter(e -> e.getTrasactionCategory().equals(ExpenseCategoryEnum.GROCERY.name()))
					.forEach(e -> MyPrinter.getInstance().printTransaction(e));
			MyPrinter.getInstance().success();
			break;
		}
		case 2: {
			expenseTransactionStorage.getItems().stream()
					.filter(e -> e.getTrasactionCategory().equals(ExpenseCategoryEnum.ENTERTAINMENT.name()))
					.forEach(e -> MyPrinter.getInstance().printTransaction(e));
			MyPrinter.getInstance().success();
			break;
		}
		case 3: {
			incomeTransactionStorage.getItems().stream()
					.filter(e -> e.getTrasactionCategory().equals(IncomeCategoryEnum.SALARY.name()))
					.forEach(e -> MyPrinter.getInstance().printTransaction(e));
			MyPrinter.getInstance().success();
			break;
		}
		case 4: {
			incomeTransactionStorage.getItems().stream()
					.filter(e -> e.getTrasactionCategory().equals(IncomeCategoryEnum.BUSINESS.name()))
					.forEach(e -> MyPrinter.getInstance().printTransaction(e));
			MyPrinter.getInstance().success();
			break;
		}
		default: {
			throw new CustomException("Wrong choice");
		}
		}
	}

	public void setBudget(User user) {
		MyPrinter.getInstance().budgetCategoryLog();
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter budget amount :");
			Budget budget = new Budget(scanner.nextInt(), ExpenseCategoryEnum.GROCERY);
			user.setBudget(budget);
			MyPrinter.getInstance().budgetPrinter(budget);
			MyPrinter.getInstance().success();
			break;
		}
		case 2: {
			System.out.println("Enter budget amount :");
			Budget budget = new Budget(scanner.nextInt(), ExpenseCategoryEnum.ENTERTAINMENT);
			user.setBudget(budget);
			MyPrinter.getInstance().success();
			break;
		}
		default: {
			throw new CustomException("Wrong choice");
		}
		}
	}

	public void saveExpenseTransaction(User user) {
		MyPrinter.getInstance().expenseTransactionLog();
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter transaction amount :");
			ExpenseTransaction transaction = new GroceryTransaction(scanner.nextLong());
			user.setExpenseTransaction(transaction);
			MyPrinter.getInstance().success();
			break;
		}
		case 2: {
			System.out.println("Enter transaction amount :");
			ExpenseTransaction transaction = new EntertainmentTransaction(scanner.nextLong());
			user.setExpenseTransaction(transaction);
			MyPrinter.getInstance().success();
			break;
		}
		default: {
			throw new CustomException("Wrong choice");
		}
		}
	}

	public void saveIncomeTransaction(User user) {
		MyPrinter.getInstance().incomeTransactionLog();
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter transaction amount :");
			IncomeTransaction transaction = new SalaryTransaction(scanner.nextLong());
			user.setIncomeTransaction(transaction);
			MyPrinter.getInstance().success();
			break;
		}
		case 2: {
			System.out.println("Enter transaction amount :");
			IncomeTransaction transaction = new BusinessTransaction(scanner.nextLong());
			user.setIncomeTransaction(transaction);
			MyPrinter.getInstance().success();
			break;
		}
		default: {
			throw new CustomException("Wrong choice");
		}
		}

	}

}

package com.cg.bms.presentation;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bms.exceptions.BMSException;
import com.cg.bms.model.Account;
import com.cg.bms.service.AccountServiceImpl;
import com.cg.bms.service.IAccountService;

public class BMSMain {

	static Logger logger = Logger.getLogger(BMSMain.class);
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		IAccountService service = new AccountServiceImpl();

		PropertyConfigurator.configure("resources/log4j.properties");
		logger.info("log4j conffigred..");

		System.out.println("___________________________________________");
		System.out.println("---- welcome to Bangalore Bank ---- ");
		System.out.println("___________________________________________");

		System.out.println("1.create Account");
		System.out.println("2.get Account Info");
		System.out.println("3.display All Accounts");
		System.out.println("4.exit");

		System.out.println("select ur choice:");
		int option = 0;

		try {
			option = scanner.nextInt();
			logger.info("selected option is: " + option);
		} catch (InputMismatchException e) {
			System.err.println("Enter digits only(1-4)");
			logger.error("User entered invalid option ");
			System.exit(0);
		}

		switch (option) {

		case 1:

			Account account = openAccount();
			logger.debug("data in the accocunt class is: " + account);

			try {
				boolean result = service.validateAccount(account);
				logger.debug("validation of account is:" + result);

				if (result) {
					boolean resultFlag = service.createAccount(account);
					if (resultFlag) {
						int id = service.getMaxId();
						System.out.println("Account created with id:" + id);
					} else {
						System.out.println("Account not created..");
					}
				}

			} catch (BMSException e) {
				System.err.println(e.getMessage());
			}
			break;

		case 2:

			break;

		case 3:

			break;

		case 4:

			break;

		default:
			System.out.println("invalid input");
			logger.info("invalid option  selected..");
			break;
		}

	}

	public static Account openAccount() {

		scanner.nextLine();
		System.out.println("Enter Account Type to create:");
		String accountType = scanner.nextLine();
		System.out.println("Enter Customer Name:");
		String customerName = scanner.nextLine();
		System.out.println("Enter Min deposit Amount:");
		double amount = 0;

		try {
			amount = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("given input is not correct, try Again");
			logger.error("entered amount is not correct..");
			System.exit(0);
		}

		Date date = new Date();

		Account account = new Account(accountType, customerName, amount, date);
		logger.info("account object created.." + account);
		return account;
	}
}

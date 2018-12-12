package com.cg.bms.service;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import com.cg.bms.dao.AccountDAoImpl;
import com.cg.bms.dao.IAccountDAO;
import com.cg.bms.exceptions.BMSException;
import com.cg.bms.model.Account;

public class AccountServiceImpl implements IAccountService {

	static Logger logger = Logger.getLogger(AccountServiceImpl.class);
	IAccountDAO accountDao = new AccountDAoImpl();

	/*
	 * methodName   - createAccount
	 * arguments    - Account object
	 * return type  - boolean
	 * Author	    - capgemini
	 * creationDate - 12/10/2018
	 * this method is user to insert the account data into database
	 */
	
	@Override
	public boolean createAccount(Account account) throws BMSException {
		logger.info("in account service class.");
		return accountDao.createAccount(account);
	}

	@Override
	public boolean validateAccount(Account account) throws BMSException {

		boolean flag = false;

		logger.info("in validation account method.");
		List<String> list = new ArrayList<>();

		if (!isNameValid(account.getCustomerName())) {
			list.add("\n customer name should contain min 5 chars and max 20 chars");
		}

		if (!isBalanceValid(account.getBalance())) {
			list.add("\n account balance should be greater than or equal 10000");
		}

		if (!isDateValid(account.getDate())) {
			list.add("\n date should be in yyyy-MM-dd format. \n");
		}

		if (!list.isEmpty()) {
			logger.debug("list is not empty");
			throw new BMSException(list + "");
		} else {
			logger.debug("list is empty");
			flag = true;
		}
		logger.debug("result from account validation method is: " + flag);
		return flag;
	}

	public boolean isNameValid(String name) {
		logger.info("in name validation method");
		String nameRegEx = "[A-Za-z]{5,20}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		logger.debug("name validation:" + matcher.matches());
		return matcher.matches();
	}

	public boolean isBalanceValid(double balance) {
		logger.info("in balance validation method");
		boolean balanceflag = false;
		if (balance >= 10000) {
			balanceflag = true;
		}
		logger.debug("balance validation :" + balanceflag);
		return balanceflag;
	}

	public boolean isDateValid(Date date) {
		logger.info("in date validation method..");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = format.format(date);
				
		String dateRegEx = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		Pattern pattern = Pattern.compile(dateRegEx);
		Matcher matcher = pattern.matcher(newDate);
		logger.debug("date validation: " + matcher.matches());
		return matcher.matches();
	}
	
	@Override
	public int getMaxId() throws BMSException {
		return accountDao.getMaxId();
	}

}

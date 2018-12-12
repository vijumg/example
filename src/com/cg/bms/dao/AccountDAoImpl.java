package com.cg.bms.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.cg.bms.exceptions.BMSException;
import com.cg.bms.model.Account;
import com.cg.bms.utility.JdbcUtility;

public class AccountDAoImpl implements IAccountDAO {

	static Logger logger = Logger.getLogger(AccountDAoImpl.class);

	Connection connection = null;
	PreparedStatement statement = null;

	/*
	 * methodName - createAccount arguments - Account object return type - boolean
	 * Author - capgemini creationDate - 12/10/2018 this method is user to insert
	 * the account data into database
	 */

	@Override
	public boolean createAccount(Account account) throws BMSException {

		connection = JdbcUtility.getConnection();
		logger.info("connection established..");
		boolean flag = false;

		try {
			statement = connection.prepareStatement(QueryConstants.insertAccount);
			logger.debug("statement created..");
			statement.setString(1, account.getType());
			statement.setString(2, account.getCustomerName());
			statement.setDouble(3, account.getBalance());

			Date date = account.getDate();
			long ms = date.getTime();

			java.sql.Date date2 = new java.sql.Date(ms);

			statement.setDate(4, date2);

			int result = statement.executeUpdate();

			if (result > 0) {
				logger.debug("account created..");
				flag = true;
			}
		} catch (SQLException e) {
			logger.error("statement object not created ");
			throw new BMSException("statement not created with som problem");
		} finally {
			JdbcUtility.closeConnection();
		}
		return flag;
	}

	@Override
	public int getMaxId() throws BMSException {

		int id = 0;

		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryConstants.selectMaxId);
			resultSet = statement.executeQuery();

			resultSet.next();
			id = resultSet.getInt(1);

		} catch (SQLException e) {
			throw new BMSException("unable to create the statement");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new BMSException("problem while closing resultset");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new BMSException("problem while closing statement");
			}

			JdbcUtility.closeConnection();
		}

		return id;
	}

}

package com.cg.bms.dao.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.bms.dao.AccountDAoImpl;
import com.cg.bms.exceptions.BMSException;
import com.cg.bms.model.Account;

public class AccountDAoImplTest {

	AccountDAoImpl accountDao = null;

	@Before
	public void setUp() throws Exception {
		accountDao = new AccountDAoImpl();
	}

	@After
	public void tearDown() throws Exception {
		accountDao = null;
	}

	@Test
	public void testCreateAccount() {

		Account account = new Account("salaried", "shanthi", 23000, new Date(2018, 10, 13));

		try {
			boolean result = accountDao.createAccount(account);
			assertEquals(true, result);
		} catch (BMSException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCreateAccountNull() {

		Account account = new Account("salaried", "shanthi", 23000, new Date(2018, 10, 13));

		try {
			boolean result = accountDao.createAccount(account);
			assertFalse(result);
		} catch (BMSException e) {
			e.printStackTrace();
		}

	}
}

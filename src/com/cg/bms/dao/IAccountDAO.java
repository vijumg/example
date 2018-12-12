package com.cg.bms.dao;

import com.cg.bms.exceptions.BMSException;
import com.cg.bms.model.Account;

public interface IAccountDAO {

	boolean createAccount(Account account) throws BMSException;

	public int getMaxId() throws BMSException;

}

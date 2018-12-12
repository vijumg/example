package com.cg.bms.dao;

public interface QueryConstants {

	public static final String insertAccount = "insert into account_master values(account_sequence.nextval,?,?,?,?)";

	public static final String selectMaxId = "SELECT MAX(ACCOUNT_NO) FROM ACCOUNT_MASTER";
}

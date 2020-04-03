package com.pbank.models;

public class Accounts {
	private String account_name;
	private double account_balance;
	
	public Accounts(String account_name, double account_balance) {
		this.account_name = account_name;
		this.account_balance = account_balance;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

}

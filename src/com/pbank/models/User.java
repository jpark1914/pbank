package com.pbank.models;

public class User {
	private int id;
	private String name;
	private int account_type;
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.account_type = 0;
	}
	
	public User() {
		this.id = 0;
		this.name = null; 
		this.account_type = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}


	
	
}

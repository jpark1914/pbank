package com.pbank.models;

public class User {
	private int id;
	private String first_name;
	private String last_name;
	private String user_name;
	private int account_type;
	
	public User(int id, String first_name, String last_name, String user_name, int account_type) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.account_type = 0;
	}
	
	public User() {
		this.id = 0;
		this.setFirst_name(null);
		this.setLast_name(null);
		this.setUser_name(null);
		this.account_type = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	
	
}

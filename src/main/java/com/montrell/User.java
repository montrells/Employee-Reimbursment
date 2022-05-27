package com.montrell;

import java.sql.Connection;

public class User {

	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String email;
	private int user_roll_id = 1;

	public User() {
	}

	public User(int id, String first_name, String last_name, String username, String password, String email, int user_roll_id) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_roll_id = user_roll_id;
	}

	public User(String first_name, String last_name, String username, String password, String email, int user_roll_id) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_roll_id = user_roll_id;
	}

	public User(String first_name, String last_name, String username, String password, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public User(int id, String first_name, String last_name, String email) {
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;
	}

	public User(int id, String first_name, String last_name, String username, String password, String email) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_roll_id() {
		return user_roll_id;
	}

	public void setUser_roll_id(int user_roll_id) {
		this.user_roll_id = user_roll_id;
	}

	@Override
	public String toString() {
		return "UserModel{" +
				"id=" + id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", user_roll_id=" + user_roll_id +
				'}';
	}
/**
 * Testing
 * */
	public int getId() {
		return id;
	}
private Connection connection;

	public User(Connection connection){
		this.connection = connection;
	}

}


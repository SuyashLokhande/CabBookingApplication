package com.example.cab;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String username;
	private int age;
	private char gender;
	
	public User() {
		super();
	}
	
	User(String username, int age, char gender) {
		super();
		this.username = username;
		this.age = age;
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}

package com.example.cab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {
	
	private String id;
	private int age;
	private char gender;
	@Autowired
	private CarDetails carDetails;
	@Autowired
	private Location location;
	
	public Driver() {
		super();
	}

	Driver(String id, int age, char gender, CarDetails carDetails, Location location) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.carDetails = carDetails;
		this.location = location;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public CarDetails getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}

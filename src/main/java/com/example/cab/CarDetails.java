package com.example.cab;

import org.springframework.stereotype.Component;

@Component
public class CarDetails {
	private String carName;
	private String carNumber;
	
	
	
	public CarDetails() {
		super();
	}
	
	CarDetails(String carName, String carNumber) {
		super();
		this.carName = carName;
		this.carNumber = carNumber;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
}

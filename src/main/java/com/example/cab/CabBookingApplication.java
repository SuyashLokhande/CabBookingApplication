package com.example.cab;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static HashMap<String, User> users = new HashMap<>();
	private static HashMap<String, Driver> drivers = new HashMap<>();
	private static HashMap<String, Boolean> driver_aval = new HashMap<>();
	
	public static void add_user(String username, int age, char gender) {
		
		if(!users.containsKey(username)) { //check if username already used.
			User user = new User(username, age, gender);
			users.put(username, user);
			System.out.println(username + " added successfully..!");
		}
		else {
			System.out.println("Username is already taken..!");
		}
	}
	
	public static void add_driver(String id, int age, char gender, String carName, String carNumber, int latitude, int longitude) {
			Location location = new Location(latitude, longitude);
			CarDetails carDetails = new CarDetails(carName, carNumber);
			Driver driver = new Driver(id, age, gender, carDetails, location);
			drivers.put(id, driver);
			driver_aval.put(id, false); // adding availability of ride.
			System.out.println(id + " onboarded successfully..!");
	}
	
	public static void find_ride(String username, int sx1, int sy1, int dx1, int dx2) {
		List<String> drives = new ArrayList<>();
		
		if(users.containsKey(username)) {
			Iterator<Map.Entry<String, Driver>> itr = drivers.entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry<String, Driver> entry = itr.next();
				int x = entry.getValue().getLocation().getLatitude();
				int y = entry.getValue().getLocation().getLongitude();
				double distance = Math.sqrt((y-sy1)*(y-sy1) + (x-sx1)*(x-sx1));
				if(!driver_aval.get(entry.getKey()) && distance <= 5) { // if driver is available and distance if car from user is not more than 5 units.
					drives.add(entry.getKey());
				}	
			}
			if(drives.size() > 0) { 
				System.out.println("Please Choose ride..!");
				for(String ride:drives) {
					System.out.println(ride);
				}
				String ride_choosen = scanner.nextLine();
				if(driver_aval.containsKey(ride_choosen)) {
					driver_aval.put(ride_choosen, true); // Marking driver unavailable as this ride already taken.
					System.out.println("Ride has been assined to you..!");
				}
				else {
					System.out.println("Wrong input..!");
				}
			}
			else {
				System.out.println("Sorry.. No rides available..!");
			}
		}
		else {
			System.out.println("Please Register First..!");
		}
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
		
		add_user("Suyash", 23, 'M');
		add_user("Rohit", 24, 'M');
		add_user("Vaibhav", 25, 'M');
		
		add_driver("Driver1", 22, 'M', "Swift", "KA-01-12345", 10, 1);
		add_driver("Driver2", 40, 'M', "Swift", "KA-01-12346", 11, 10);
		add_driver("Driver3", 32, 'M', "Swift", "KA-01-12347", 5, 3);
		
		find_ride("Suyash", 0, 0, 20, 1);
		find_ride("Rohit", 10, 0, 15, 3);
		find_ride("Vaibhav", 15, 6, 20, 4);
		
	}

}

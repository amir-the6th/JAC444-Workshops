/**********************************************
Workshop #4
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-17
**********************************************/
package ca.senecacollege.concrete;

import ca.senecacollege.abstracts.Employee;

/**
 * Class: HourlyEmployee
 * Extends Employee abstract class
 * @author Amir
 *
 */
public class HourlyEmployee extends Employee {
	double wage, hours;

	/**
	 * Five-arg constructor
	 * calls superclass constructor first.
	 * then initializes instance variables.
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param wage
	 * @param hours
	 * @throws Exception 
	 */
	public HourlyEmployee(String fName, 
			String lName, 
			String ssn, 
			double wage, 
			double hours) throws Exception {
		super(fName,lName,ssn);
		setWage(wage);
		setHours(hours);
	}
	
	/**
	 * Getters
	 * @return wage, hours
	 */
	public double getWage() {
		return this.wage;
	}
	public double getHours() {
		return this.hours;
	}
	
	/**
	 * Setters
	 * Sets wage, hours
	 */
	public void setWage(double w) throws Exception {
		if (w <= 0.0) {
			throw new Exception("Wage should not be less than 0.0!");
		} else {
			this.wage = w;
		}
	}
	public void setHours(double h) throws Exception {
		if ((h <= 0.0) || (h >= 168.0)) {
			throw new Exception("Hours should not be between 0.0 and 168.0!");
		} else {
			this.hours = h;
		}
	}
	
	/**
	 * Calculate the hourly based salary.
	 * @return salary
	 */
	@Override
	public double getPaymentAmount() {
		double salary = 0.0;
		// Logic: calculate 40 hours with normal wage. add overtime
		//        pay for all hours worked in excess of 40 hours.
		salary = (40 * getWage()) + ((getHours() - 40) * (getWage() * 1.5));		
		return salary;
	}
	
	/**
	 * @return String representation of HourlyEmployee Object
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Hourly Employee [Wage: $" + getWage() + 
				                "/ Hours: " + getHours() + "]";
	}

}

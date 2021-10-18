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
 * Class: SalariedEmployee
 * Extends Employee abstract class
 * @author Amir
 *
 */
public class SalariedEmployee extends Employee {
	double weeklySalary;

	/**
	 * Four-arg constructor
	 * calls superclass constructor first.
	 * then initializes instance variables.
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param weeklySalary
	 * @throws Exception 
	 */
	public SalariedEmployee(String fName, 
			String lName, 
			String ssn, 
			double ws) throws Exception {
		super(fName,lName,ssn);
		setWeeklySalary(ws);
	}
	
	/**
	 * Getter
	 * @return weeklySalary
	 */
	public double getWeeklySalary() {
		return this.weeklySalary;
	}
	
	/**
	 * Setter
	 * Sets weeklySalary
	 */
	public void setWeeklySalary(double ws) throws Exception {
		if (ws <= 0.0) {
			throw new Exception("Weekly Salary should not be less than 0.0!");
		} else {
			this.weeklySalary = ws;
		}
	}
	
	/**
	 * @return weeklySalary
	 */
	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
	/**
	 * @return String representation of SalariedEmployee Object
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Salaried Employee [Weekly Salary: $" + getWeeklySalary() + "]";
	}

}

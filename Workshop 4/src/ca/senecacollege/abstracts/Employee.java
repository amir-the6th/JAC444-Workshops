/**********************************************
Workshop #4
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-17
**********************************************/
package ca.senecacollege.abstracts;

import ca.senecacollege.interfaces.Payable;

/**
 * Class: Employee
 * Implement Payable interface
 * @author Amir
 *
 */
public abstract class Employee implements Payable {
	private String firstName, lastName, socialSecurityNumber;
	
	/**
	 * Three-arg constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 */
	public Employee(String fName, String lName, String ssn) {
		this.firstName = fName;
		this.lastName = lName;
		this.socialSecurityNumber = ssn;
	}

	/**
	 * Getters
	 * @return firstName, lastName, socialSecurityNumber
	 */
	public String getFName() {
		return this.firstName;
	}
	public String getLName() {
		return this.lastName;
	}
	public String getSSN() {
		return this.socialSecurityNumber;
	}
	
	/**
	 * Setters
	 * Sets firstName, lastName, socialSecurityNumber
	 */
	public void setFName(String str) {
		this.firstName = str;
	}
	public void setLName(String str) {
		this.lastName = str;
	}
	public void setSSN(String str) {
		this.socialSecurityNumber = str;
	}
	
	/**
	 * @return String representation of Employee Object
	 */
	public String toString() {
		return "First Name: " + firstName + 
				"\nLast Name: " + lastName + 
				"\nSocial Security Number: " + socialSecurityNumber;
	}
	
}

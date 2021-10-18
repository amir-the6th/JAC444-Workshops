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
 * Class: ComissionEmployee
 * Extends Employee abstract class
 * @author Amir
 *
 */
public class CommissionEmployee extends Employee {
	private double grossSales, commissionRate;
	
	/**
	 * Five-arg constructor
	 * calls superclass constructor first.
	 * then initializes instance variables.
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param grossSales
	 * @param commissionRate
	 * @throws Exception 
	 */
	public CommissionEmployee(String fName, 
			String lName, 
			String ssn, 
			double gSales, 
			double cRate) throws Exception {
		super(fName,lName,ssn);
		setGrossSales(gSales);
		setCommissionRate(cRate);
	}
	
	/**
	 * Getters
	 * @return grossSales, commissionRate
	 */
	public double getGrossSales() {
		return this.grossSales;
	}
	public double getCommissionRate() {
		return this.commissionRate;
	}
	
	/**
	 * Setters
	 * Sets grossSales, commissionRate
	 */
	public void setGrossSales(double gs) throws Exception {
		if (gs <= 0.0) {
			throw new Exception("Gross sales should not be less than 0.0.");
		} else {
			this.grossSales = gs;
		}
	}
	public void setCommissionRate(double cr) throws Exception   {
		if((cr <= 0.0) || (cr >= 1.0)) {
			throw new Exception("Comission rate should be between 0.0 to 1.0.");
		} else {
			this.commissionRate = cr;
		}
	}
	
	/**
	 * Calculate the commission based salary.
	 */
	@Override
	public double getPaymentAmount() {
		return getGrossSales() * getCommissionRate();
	}
	
	/**
	 * @return String representation of CommissionEmployee Object
	 */
	@Override
	public String toString() {
		return super.toString() + "\nGross Sales: $" + getGrossSales() + "\nComission Rate: " + getCommissionRate();
	}

}

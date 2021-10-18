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

/**
 * Class: HourlyEmployee
 * Extends CommissionEmployee class
 * @author Amir
 *
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
	double baseSalary;

	/**
	 * Six-arg constructor
	 * calls superclass constructor first.
	 * then initializes instance variables.
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param grossSales
	 * @param commissionRate
	 * @param baseSalary
	 * @throws Exception 
	 */
	public BasePlusCommissionEmployee(String fName, 
			String lName, 
			String ssn, 
			double gSales, 
			double cRate,
			double bs) throws Exception {
		super(fName,lName,ssn,gSales,cRate);
		setBaseSalary(bs);
	}
	
	/**
	 * Getter
	 * @return baseSalary
	 */
	public double getBaseSalary() {
		return this.baseSalary;
	}

	/**
	 * Setters
	 * Sets baseSalary
	 */
	public void setBaseSalary(double bs) throws Exception {
		if (bs <= 0.0) {
			throw new Exception("Gross sales should not be less than 0.0.");
		} else {
			this.baseSalary = bs;
		}
	}
	
	/**
	 * Calculate the base plus commission salary.
	 */
	@Override
	public double getPaymentAmount() {
		// Logic: base salary + commission based salary
		return getBaseSalary() + super.getPaymentAmount();
	}
	
	/**
	 * @return String representation of BasePlusCommissionEmployee Object
	 */
	@Override
	public String toString() {
		return super.toString() + "\nBase Salary: $" + getBaseSalary();
	}
}

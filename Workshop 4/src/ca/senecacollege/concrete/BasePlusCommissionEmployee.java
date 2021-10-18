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
		/* Logic: commission based salary + base salary
		 * 
		 * Note:  For the current pay period, the company 
		 * has decided to reward salaried-commission employees 
		 * by adding 10% to their base salaries.
		 */
		return (getBaseSalary() * 1.1) + super.getPaymentAmount();
	}
	
	/**
	 * @return String representation of CommissionEmployee Object
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Comission [Gross Sales: $" + getGrossSales() + 
				                "/ Comission Rate: " + getCommissionRate() + "]";
	}
}

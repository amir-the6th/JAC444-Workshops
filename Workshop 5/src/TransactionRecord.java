/**********************************************
Workshop #5
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-11-01
**********************************************/

/**
 * @author Amir
 *
 */
public class TransactionRecord {
	
	private int accountNumber;
	private double amount;

	/**
	 * no-arg constructor
	 * sets the instance variables to a safe state
	 */
	public TransactionRecord() {
		this(0,0.0);
	}
	
	/**
	 * 2-arg constructor
	 * @param accNum, amt
	 */
	public TransactionRecord(int accNum, double amt) {
		accountNumber = accNum;
		amount = amt;
	}
	
	public int getAccNum() {
		return accountNumber;
	}
	public void setAccNum(int num) {
		accountNumber = num;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double num) {
		amount = num;
	}

}

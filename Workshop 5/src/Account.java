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
public class Account {

	private int accNum;
	private String fName;
	private String lName;
	private double balance;
	
	public Account() {
		this(0,"","",0.0);
	}
	
	public Account(int accNum, String fName, String lName, double balance) {
		this.accNum = accNum;
		this.fName = fName;
		this.lName = lName;
		this.balance = balance;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * Combines the balance of the Account object and the 
	 * amount value of the TransactionRecord object.
	 * 
	 * @param tr -> an object of TransactionRecord class
	 */
	public double combine(TransactionRecord tr) {
		return this.balance += tr.getAmount();
	}
}

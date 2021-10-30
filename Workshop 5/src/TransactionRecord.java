/**
 * 
 */

/**
 * @author amirs
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

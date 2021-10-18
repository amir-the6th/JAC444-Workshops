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

import ca.senecacollege.interfaces.Payable;

/**
 * Class: Invoice
 * Implement Payable interface
 * @author Amir
 *
 */
public class Invoice implements Payable {
	private String partNumber, partDescription;
	private int quantity;
	private double pricePerItem;
	private static int invoiceNo;
	
	/**
	 * Four-arg constructor
	 * @param partNumber
	 * @param partDescription
	 * @param quantity
	 * @param pricePerItem
	 */
	public Invoice(String partNum, String partDesc, int q, double pricePI) {
		this.partNumber = partNum;
		this.partDescription = partDesc;
		this.quantity = q;
		this.pricePerItem = pricePI;
		invoiceNo++;
	}
	
	/**
	 * Getters
	 * @return partNumber, partDescription, quantity, pricePerItem, invoiceNo
	 */
	public String getPartNumber() {
		return partNumber;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public int getInvoiceNo() {
		return invoiceNo;
	}
	
	/**
	 * Setters
	 * Sets partNumber, partDescription, quantity, pricePerItem
	 */
	public void setPartNumber(String str) {
		this.partNumber = str;
	}
	public void setPartDescription(String str) {
		this.partDescription = str;
	}
	public void setQuantity(int num) {
		this.quantity = num;
	}
	public void setPricePerItem(double num) {
		this.pricePerItem = num;
	}
	
	/**
	 * @return the cost of the invoice
	 */
	@Override
	public double getPaymentAmount() {
		return quantity * pricePerItem;
	}

	/**
	 * @return String representation of Invoice Object
	 */
	public String toString() {
		return "Part Number:        " + partNumber +
			   "\n| Part Description:   " + partDescription +
			   "\n| Quantity:           " + quantity +
			   "\n| Price Per Item:     " + pricePerItem;
	}
	
}

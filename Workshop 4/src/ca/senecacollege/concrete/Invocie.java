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
 * @author amirs
 *
 */
public class Invocie implements Payable {
	private String partNumber, partDescription;
	private int quantity;
	private double pricePerItem;
	
	public void Invoice {
		
	}
	public String getPartNumber() {
		return partNumber;
	}
	public String getPartDecription() {
		return partDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
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

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

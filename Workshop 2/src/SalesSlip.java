/**********************************************
Workshop #2
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-05
**********************************************/
import java.security.SecureRandom;

public class SalesSlip {
	//double value;
	int sales[][];
	//int salesPerson, product;
	//int slipsPerDay, prodNum;
    int totalSold, totalBySP, totalByP;
	static final int NUM_OF_SALES_P = 4;
	static final int NUM_OF_PRODS = 5;
	
	/**
	 * SalesSlip no-arg constructor.
	 * Calls the populateSlip method to fill
	 * the sales array with random numbers 
	 */
	public SalesSlip() {
		this.sales = new int[NUM_OF_PRODS][NUM_OF_SALES_P];
		populateSlips();
	}
	/**
	 * Populates the sales two-dimensional 
	 * array with random numbers.
	 * @param num
	 */
	public void populateSlips() {
		SecureRandom random = new SecureRandom();
		// populate the array with random generated numbers  between 100 - 2600
		for (int row = 0; row < sales.length; row++) {
			for (int column = 0; column < sales[row].length; column++) {
				sales[row][column] = (int)(100 + (2.5 * random.nextInt(1000)));
			}
		}
	}
	/**
	 * Display the header, calculate and display the table.
	 */
	public void display() {
		displayDivider();
		System.out.println();
		displayTableHeader();
		displayDivider();
		System.out.println();
		displayDivider();
		calcTotalByProduct();
		displayDivider();
		System.out.printf("%n%9s \t|", "Total");
		calcTotalBySP();
		System.out.printf(" %,2d|", totalSold);		
	}
	/**
	 * Display table header.
	 */
	public void displayTableHeader() {
		System.out.print("    Row/Col     |");
		for (int counter = 1; counter <= sales[0].length; counter++) {
			System.out.printf("%8s #%d  |","Person", counter);
		}
		System.out.print(" Total |\n");
	}
	/**
	 * Display the divider.
	 */
	public void displayDivider() {
		for (int i = 0; i<= 80; i++)
			System.out.print("-");
	}
	/**
	 * Calculate total sales by product
	 */
	public void calcTotalByProduct() {
		for (int row = 0; row <= 4; row++) {
			for (int column = 0; column <= 4; column++) {
				if (column == 0)
					System.out.printf("%n  Product #%d    ", row + 1);
				else {
					System.out.printf("|%,9d    ", sales[row][column - 1]);
					totalBySP += sales[row][column - 1];
				}
			}
			System.out.printf("| %,2d |", totalBySP);
			System.out.println();
			totalBySP = 0;
		}
	}
	/**
	 * Calculate total sales by sales person
	 */
	public void calcTotalBySP() {
		for (int column = 0; column <= sales[0].length - 1; column++) {
			for (int row = 0; row <= sales.length - 1; row++) {
				totalByP += sales[row][column];
			}
			totalSold += totalByP;
			System.out.printf("%,9d    |", totalByP);
			totalByP = 0;
		}
	}
	/*
	public int[][] getSales() {
		return sales;
	}
	public void setSales(int[][] sales) {
		this.sales = sales;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(int salesPerson) {
		this.salesPerson = salesPerson;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	*/
}

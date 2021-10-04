
public class SalesSlip {
	private double value, sales[][];
	private int salesPerson, product;
	private double slips[];
	static final int NUM_OF_SALES_P = 4;
	static final int NUM_OF_PRODS = 5;
	static final int NUM_OF_SLIPS = 100;
	
	public SalesSlip() {
		this.sales = new double[NUM_OF_PRODS+1][NUM_OF_SALES_P+1];
		populateSlips(NUM_OF_SLIPS);
		for (int row = 0; row < sales.length ; row++) {
			for (int column = 0; column < sales[row].length; column++) {
				sales[row][column] = slips[(int)(Math.random() * 100)];
			}
		}
	}
	public void populateSlips(int num) {
		// populate the array with random generated numbers
		slips = new double[num];
		for (int i = 0; i < slips.length; i++) {
			slips[i] = (int)(Math.random() * 1000);
		}
	}
	public double[][] getSales() {
		return sales;
	}
	public void setSales(double[][] sales) {
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
	public void setSlip(int sp, int prod, double val) {
		//this.sales[]
	}
}

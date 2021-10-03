
public class SalesSlip {
	double value, sales[][];
	int salesPerson, product;
	static final int NUM_OF_SALES_P = 5;
	static final int NUM_OF_PRODS = 4;
	
	public SalesSlip() {
		this.sales = new double[NUM_OF_PRODS][NUM_OF_SALES_P];
	}
	public double[][] getSales() {
		return sales;
	}
	public int getProduct() {
		return product;
	}
	public int getSalesPerson() {
		return salesPerson;
	}
	public double getValue() {
		return value;
	}
}

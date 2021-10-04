
public class TotalSales {
	public static void main(String[] args) {
		SalesSlip ss = new SalesSlip();
		// generate a number between 0 - 3 to set the sales person
		// remember sales person #1 possess index 0 in the array
		ss.setSalesPerson((int)(Math.random() * 4));
		// generate a number between 0 - 4 to set the product
		ss.setProduct((int)(Math.random() * 5));
		// generate a number between 0 - 5000 to set the dollar value
		ss.setValue((int)((Math.random() * 5000) +1));
		ss.setSlip(ss.getSalesPerson(), ss.getProduct(), ss.getValue());
		
		
	}
}

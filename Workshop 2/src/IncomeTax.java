
public class IncomeTax {
	static final int SINGLE_FILER = 0;
	static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 0;
	static final int MARRIED_SEPARATELY = 0;
	static final int HEAD_OF_HOUSEHOLD = 0;
	private int filingStatus, intervals[][];
	private double rates[], taxableIncome;
	
	public IncomeTax() {}
	public int getFilingStatus() {
		return filingStatus;
	}
	public void setFilingStatus(int fs) {
		this.filingStatus = fs;
	}
	public double[][] getIntervals() {
		return intervals;
	}
	public void setIntervals(double[][] intervals) {
		this.intervals = intervals;
	}
	public double[] getRates() {
		return rates;
	}
	public void setRates(double[] rates) {
		this.rates = rates;
	}
	public double taxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double ti) {
		this.taxableIncome = ti;
	}
}

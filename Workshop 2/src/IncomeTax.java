/**********************************************
Workshop #2
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-05
**********************************************/
public class IncomeTax {
	static final int SINGLE_FILER = 0;
	static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	static final int MARRIED_SEPARATELY = 2;
	static final int HEAD_OF_HOUSEHOLD = 3;
	private int filingStatus = -1, intervals[][];
	private double rates[], taxableIncome;
	
	public IncomeTax() {
		double[] defaultRates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
		setRates(defaultRates);
		
		int[][] defaultIntervals = {
				{8350, 33950, 82250, 171550, 372950},  // Single filer
				{16700, 67900, 137050, 20885, 372950}, // Married filing jointly or qualifying widow(er)
				{8350, 33950, 68525, 104425, 186475},  // Married filing separately
				{11950, 45500, 117450, 190200, 372950} // Head of household
		};
		setIntervals(defaultIntervals);
	}
	public IncomeTax(int[][] intervals, double[] rates) {
		//setFilingStatus(filingStatus);
		setIntervals(intervals);
		setRates(rates);
		//setTaxableIncome(ti);
	}
	public int getFilingStatus() {
		return filingStatus;
	}
	public void setFilingStatus(int fs) {
		this.filingStatus = fs;
	}
	public int[][] getIntervals() {
		return intervals;
	}
	public void setIntervals(int[][] intervals) {
		this.intervals = intervals;
	}
	public double[] getRates() {
		return rates;
	}
	public void setRates(double[] rates) {
		this.rates = rates;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double ti) {
		this.taxableIncome = ti;
	}
	public double getIncomeTax() {
		double inc = taxableIncome, tax = 0, taxedIncome;
		tax += intervals[filingStatus][0] * rates[0];
		for (int i = rates.length - 2; i >= 0; i--) {
			if (inc > intervals[filingStatus][i]) {
				taxedIncome = inc - intervals[filingStatus][i];
				tax += taxedIncome * rates[i + 1];
				inc -= taxedIncome;
			}
		}
		return tax;
		/*
		if(taxableIncome <= intervals[filingStatus][0]) {
			tax = taxableIncome * rates[0];
		}
		else {
			tax = intervals[filingStatus][0] * rates[0];
	        for (int i = 1; i < intervals[filingStatus].length; i++) {
	        	if (taxableIncome > intervals[filingStatus][i]) {
	                //tax += (intervals[filingStatus][i] - intervals[filingStatus][i - 1]) * rates[i];
	        		tax += (taxedIncome = taxableIncome - intervals[filingStatus][i]) * rates[i + 1];
	        		taxableIncome -= taxedIncome;
	        	}
	        	else {
	        		tax += (taxableIncome - intervals[filingStatus][i - 1]) * rates[i];
	        	}
	        }
		}
		tax += (taxableIncome - intervals[filingStatus][4]) * rates[5];
		return tax;
		*/
	}
}

import java.util.Scanner;

public class TaxProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("0 - single filer");
		System.out.println("1 - married jointly or qualifying widow(er)");
		System.out.println("2 - married separately");
		System.out.println("3 - head of household)");
		
		IncomeTax it = new IncomeTax();
		while (!(it.getFilingStatus() >= 0 && it.getFilingStatus() <= 3)) {
			System.out.print("Please enter your filing status: ");
			try {
				it.setFilingStatus(scan.nextInt());
			} catch (Exception e) {
				System.out.println("****** WRONG! Input must be a number between 1 - 4 ******\n");
				scan.nextLine();
				continue;
			}
		}
		while(it.getTaxableIncome() == 0) {
			System.out.print("Please enter your taxable income: ");
			try {
				it.setTaxableIncome(scan.nextDouble());
			} catch (Exception e) {
				System.out.println("****** WRONG! Input must be a number between 1 - 4 ******\n");
				scan.nextLine();
				continue;
			}
		}
		scan.close();
		System.out.println("Your tax is: " + it.getIncomeTax());
	}
}

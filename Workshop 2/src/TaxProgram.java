/**********************************************
Workshop #2
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-05
**********************************************/
import java.util.Scanner;

public class TaxProgram {
	/**
	 * main method: Advanced Tax Calculation Program
	 * @param args
	 */
	public static void main(String[] args) {
		boolean exit = false;
		Scanner mainScan = new Scanner(System.in);
		
		welcomeHeader();
		while(!exit) {
			mainMenu();
			int ch = mainScan.nextInt();
			switch(ch) {
			case 1:
				calcPersonalTax();
				mainScan.reset();
				if(!runAgain()) {
					exit = true;
				}
				break;
			case 2:
				printTaxTables();
				mainScan.reset();
				if(!runAgain()) {
					exit = true;
				}
				break;
			case 3:
				exit = true;
				System.out.println("Thank you for using our program. Goodbye!");
				break;
			default:
				System.out.println("WRONG CHOICE! only 1, 2, or 3 are valid.");
				break;
			}
		}
		mainScan.nextLine();
	}
	/**
	 * Prints a welcome header when the user runs the program
	 */
	public static void welcomeHeader() {
		System.out.println("Welcome to the most advanced tax calculation program!");
		System.out.print("-----------------------------------------------------");
	}
	/**
	 * Prints the menu options and asks for selection
	 */
	public static void mainMenu() {
		System.out.println("\n1. Calculate Your Personal Income Taxes");
		System.out.println("2. Print Tax Tables For Taxable Income");
		System.out.println("3. Exit");
		System.out.print("Enter your selection: ");
	}
	/**
	 * Prints various filing status and asks for selection.
	 * Calculates the tax a user has to pay based on the
	 * filing status and taxable income of the user.
	 */
	public static void calcPersonalTax() {
		Scanner calScan = new Scanner(System.in);

		System.out.println("\n0 - single filer");
		System.out.println("1 - married jointly or qualifying widow(er)");
		System.out.println("2 - married separately");
		System.out.println("3 - head of household)");
		
		IncomeTax it = new IncomeTax();
		while (!(it.getFilingStatus() >= 0 && it.getFilingStatus() <= 3)) {
			System.out.print("Please enter your filing status: ");
			try {
				it.setFilingStatus(calScan.nextInt());
			} catch (Exception e) {
				System.out.println("****** WRONG! Input must be a number between 1 - 4 ******\n");
				calScan.nextLine();
				continue;
			}
		}
		while(it.getTaxableIncome() == 0) {
			System.out.print("Please enter your taxable income: ");
			try {
				it.setTaxableIncome(calScan.nextDouble());
			} catch (Exception e) {
				System.out.println("****** WRONG! Input must be a number between 1 - 4 ******\n");
				calScan.nextLine();
				continue;
			}
		}
		calScan.nextLine();
		System.out.println("Your tax is: " + it.getIncomeTax());
	}
	/**
	 * Prints the 2001 and 2009 tax table for an amount
	 * range that was prompted by the user.
	 */
	public static void printTaxTables() {
		Scanner prTaxScan = new Scanner(System.in);
		double amtFrom, amtTo;
		double[] rates2001 = { 0.15, 0.275, 0.305, 0.355, 0.391 };
		int[][] intervals2001 = {
				{ 27050, 65550, 136750, 297350 },   // Single filer
				{ 45200, 109250, 166500, 297350 },  // Married filing jointly or qualifying widow(er)
				{ 22600, 54625, 83250, 148675 },    // Married filing separately
				{ 36250, 93650, 151650, 297350 }    // Head of household
		};
		IncomeTax it2001 = new IncomeTax(intervals2001, rates2001);
		IncomeTax it2009 = new IncomeTax();
		
		System.out.print("Enter the amount From: $");
		amtFrom = prTaxScan.nextDouble();
		System.out.print("Enter the amount To: $");
		amtTo = prTaxScan.nextDouble();
		prTaxScan.nextLine();
		
		System.out.println("2001 tax tables for taxable income from " + amtFrom + " to " + amtTo);
		System.out.println("------------------------------------------------------------------");

		displayTaxTable(it2001, amtFrom, amtTo);
		System.out.println("\n");

		System.out.println("2009 tax tables for taxable income from " + amtFrom + " to " + amtTo);
		System.out.println("------------------------------------------------------------------");
		displayTaxTable(it2009, amtFrom, amtTo);
	}
	/**
	 * Prints the details of the tables.
	 */
	public static void displayTaxTable(IncomeTax tax, double from, double to) {
		System.out.println("Income\t\t" + "Single\t\t" + "Married Joint\t" + "Married\t\t" + "Head of");
		System.out.println("      \t\t" + "      \t\t" + "or Widow(er)\t" + "Separated\t" + "a House");
		for (double i = from; i <= to; i += 1000) {
			System.out.println();

			tax.setTaxableIncome(i);
			System.out.print(tax.getTaxableIncome());

			tax.setFilingStatus(tax.SINGLE_FILER);
			System.out.print("\t\t" + tax.getIncomeTax() + "\t\t");

			tax.setFilingStatus(tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW);
			System.out.print(tax.getIncomeTax() + "\t\t");

			tax.setFilingStatus(tax.MARRIED_SEPARATELY);
			System.out.print(tax.getIncomeTax() + "\t\t");

			tax.setFilingStatus(tax.HEAD_OF_HOUSEHOLD);
			System.out.print(tax.getIncomeTax());
		}
		System.out.println();
	}
	/**
	 * This method prompts the user if they want to run the program again
	 * @return again -> returns a boolean value that determines
	 * whether the user wants to run again or wants to leave.
	 */
	public static boolean runAgain() {
		boolean again;
		Scanner scan = new Scanner(System.in);
		System.out.print("\nDo you want to try our program another time?\n1. Yes\n2. No\nSelection: ");
		byte input = scan.nextByte();
		scan.nextLine();
		while (input != 1 && input != 2) {
			System.out.println("\n*** INCORRECT SELECTION! ***\n");
			System.out.print("Selection: ");
			input = scan.nextByte();
		}
		if(input == 1) {
			again = true;
		}
		else {
			System.out.println("Thank you for using our program. Goodbye!");
			again = false;
		}
		
		return again;
	}		
}

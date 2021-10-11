/**********************************************
Workshop #3
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-10
**********************************************/
import java.util.Calendar;
import java.util.Scanner;

public class DateUtilities {
	/**
	 * prompts the user to input a valid integer.
	 * throws an exception if not.
	 * @return result - valid integer
	 */
	public int promptInteger() {
		int result = 0;
		Scanner scan = new Scanner(System.in);
		try {
			result = scan.nextInt();
		}
		catch(Exception e) {
			System.out.println("\nYou have prompted an invalid input.\n*** Error details: "
					+ e + " ***\nPlease run the program again!");
			System.exit(0);
		}
		scan.nextLine();
		return result;
	}
	/**
	 * prompts the user to input a valid String.
	 * throws an exception if not.
	 * @return result - valid String
	 */
	public String promptString() {
		String result = null;
		Scanner scan = new Scanner(System.in);
		try {
			result = scan.next();
			Integer.parseInt(result); // the following statement will run only if the input is an integer.
			System.out.println("\nYou have not prompted a valid input (String)."
					+ "\nPlease run the program again!");
			System.exit(0);
		}
		catch(Exception e) {
			//if the value is not an integer, the string will successfully pass the validation.
		}
		scan.nextLine();
		return result;
	}
	/**
	 * validates the parameter to be a valid year number
	 * @return result - valid year number
	 */
	public int validateYear(int y) {
		while(y < 1000 || y > 2500) {
			System.out.print("\nWrong Year Number!\nPlease enter a number between 1000 to 2500: ");
			y = promptInteger();
		}
		return y;
	}
	/**
	 * validates the parameter to be a valid month number
	 * @return result - valid month number
	 */
	public int validateMonth(int m) {
		while(m < 1 || m > 12) {
			System.out.print("\nWrong Month Number!\nPlease enter a number between 1 to 12: ");
			m = promptInteger();
		}
		return m;
	}
	/**
	 * validates the parameter to be a valid day number
	 * @return result - valid day number
	 */
	public int validateDay(int d, int m, int y) {
		/*
		 * VALIDATION GUIDE:
		 * January – 31 days
		 * February – 28 days in a common year and 29 days in leap years
		 * March – 31 days
		 * April – 30 days
		 * May – 31 days
		 * June – 30 days
		 * July – 31 days
		 * August – 31 days
		 * September – 30 days
		 * October – 31 days
		 * November – 30 days
		 * December – 31 days
		 */
		if(isLeapYear(y)) { //if month = February and year is a leap year, day between 1 - 29
			if(m == 2) {
				while(d < 1 || d > 29) {
					System.out.print("\nWrong Day Number For February!\nPlease enter a number between 1 to 29: ");
					d = promptInteger();
				}
			}
		} else { // //if month = February and year is not a leap year, day between 1 - 28
			if(m == 2) {
				while(d < 1 || d > 28) {
					System.out.print("\nWrong Day Number For February!\nPlease enter a number between 1 to 28: ");
					d = promptInteger();
				}
			}
		}
		if(m == 4 || m == 6 || m == 9 || m == 11) { //if month = months that have 30 days, day between 1 - 30
			while(d < 1 || d > 30) {
				System.out.print("\nWrong Day Number!\nPlease enter a number between 1 to 30: ");
				d = promptInteger();
			}
		} else { // for the rest of the months, day between 1 - 31
			while(d < 1 || d > 31) {
				System.out.print("\nWrong Day Number!\nPlease enter a number between 1 to 31: ");
				d = promptInteger();
			}
		}
		return d;
	}
	/**
	 * validates the parameter to be a valid month name
	 * @return result - valid month name
	 */
	public String validateMonthName(String mn) {
		mn = mn.toLowerCase();
		while(!(mn.equals("january")   || mn.equals("jan") ||
				mn.equals("february")  || mn.equals("feb") ||
				mn.equals("march")     || mn.equals("mar") ||
				mn.equals("april")     || mn.equals("apr") ||
				mn.equals("may")       || mn.equals("may") ||
				mn.equals("june")      || mn.equals("jun") ||
				mn.equals("july")      || mn.equals("jul") ||
				mn.equals("august")    || mn.equals("aug") ||
				mn.equals("september") || mn.equals("sep") ||
				mn.equals("october" )  || mn.equals("oct") ||
				mn.equals("november")  || mn.equals("nov") ||
				mn.equals("december")  || mn.equals("dec"))) 
		{
			System.out.print("\nWrong Month Name!\n");
			System.out.print("Guide:"
					+ "\n - January   (Jan)"
					+ "\n - February  (Feb)"
					+ "\n - March     (Mar)"
					+ "\n - April     (Apr)"
					+ "\n - May       (May)"
					+ "\n - June      (Jun)"
					+ "\n - July      (Jul)"
					+ "\n - August    (Aug)"
					+ "\n - September (Sep)"
					+ "\n - October   (Oct)"
					+ "\n - November  (Nov)"
					+ "\n - December  (Dec)");
			System.out.print("\nPlease enter a valid month name: ");
			mn = promptString();
		}
		switch(mn) {
		case "jan":
			mn = "January";
			break;
		case "feb":
			mn = "February";
			break;
		case "mar":
			mn = "March";
			break;
		case "apr":
			mn = "April";
			break;
		case "may":
			mn = "May";
			break;
		case "jun":
			mn = "June";
			break;
		case "jul":
			mn = "July";
			break;
		case "aug":
			mn = "August";
			break;
		case "sep":
			mn = "September";
			break;
		case "oct":
			mn = "October";
			break;
		case "nov":
			mn = "November";
			break;
		case "dec":
			mn = "December";
			break;
		default:
			System.out.println("Wrong month name!");
		}
		return mn;
	}
	/**
	 * validates the parameter to be a valid day of year number
	 * @return result - valid day of year number
	 */
	public int validateDayOfYear(int d) {
		while(d < 1 || d > 365) {
			System.out.print("\nWrong Day Number!\nPlease enter a number between 1 to 365: ");
			d = promptInteger();
		}
		return d;
	}
	/**
	 * returns true if the given year number is/was a leap year
	 * @return
	 */
	public boolean isLeapYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}
}

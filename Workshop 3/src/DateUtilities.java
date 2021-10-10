import java.util.Calendar;
import java.util.Scanner;

public class DateUtilities {
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
	public int validateYear(int y) {
		while(y < 0 || y > 2500) {
			System.out.print("\nWrong Year Number!\nPlease enter a number between 0 to 2500: ");
			y = promptInteger();
		}
		return y;
	}
	public int validateMonth(int m) {
		while(m < 1 || m > 12) {
			System.out.print("\nWrong Month Number!\nPlease enter a number between 1 to 12: ");
			m = promptInteger();
		}
		return m;
	}
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
	public String validateMonthName(String mn) {
		return mn;
	}
	public boolean isLeapYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}
}

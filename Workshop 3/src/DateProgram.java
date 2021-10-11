/**********************************************
Workshop #3
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-10
**********************************************/
import java.util.Scanner;

public class DateProgram {
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		boolean exit = false;
		welcomeHeader();
		while(!exit) {
			mainMenu();
			runMenu();
			if(!runAgain()) {
				exit = true;
			}
		}
	}
	/**
	 * evaluates the menu options and
	 * calls the appropriate methods
	 */
	public static void runMenu() {
		int dd, mm, yyyy, dOfYear, ch = 0;
		String mName;
		DateUtilities du = new DateUtilities();
		ch = du.promptInteger();
		switch(ch) {
		case 1:
			System.out.print("Enter Year: ");
			yyyy = du.promptInteger();
			yyyy = du.validateYear(yyyy);
			
			System.out.print("Enter Month(1-12): ");
			mm = du.promptInteger();
			mm = du.validateMonth(mm);
			
			System.out.print("Enter Day of Month: ");
			dd = du.promptInteger();
			dd = du.validateDay(dd, mm, yyyy);
			
			Date date1 = new Date(dd,mm,yyyy);
			displayDates(date1);
			break;
		case 2:
			System.out.print("Enter Year: ");
			yyyy = du.promptInteger();
			yyyy = du.validateYear(yyyy);
			
			System.out.print("Enter Month(January - December): ");
			mName = du.promptString();
			mName = du.validateMonthName(mName);
			
			System.out.print("Enter Day of Month: ");
			dd = du.promptInteger();
			dd = du.validateDay(dd, 1, yyyy);
			
			Date date2 = new Date(mName,dd,yyyy);
			displayDates(date2);
			break;
		case 3:
			System.out.print("Enter Year: ");
			yyyy = du.promptInteger();
			yyyy = du.validateYear(yyyy);
			
			System.out.print("Enter Day of Year: ");
			dOfYear = du.promptInteger();
			dOfYear = du.validateDayOfYear(dOfYear);
			
			Date date3 = new Date(dOfYear,yyyy);
			displayDates(date3);
			break;
		case 4:
			System.out.println("Thank you for using our program. Goodbye!");
			System.exit(0);
			break;
		case 0:
			break;
		default:
			System.out.println("WRONG CHOICE! only 1, 2, 3, or 4 are valid.\n");
			mainMenu();
			runMenu();
			break;
		}
	}
	/**
	 * prints a welcome header when the user runs the program
	 */
	public static void welcomeHeader() {
		System.out.println("Welcome to Amir's date conversion program!");
		System.out.print("------------------------------------------");
	}
	/**
	 * prints menu options
	 */
	public static void mainMenu() {
		System.out.println("\nEnter 1 for format: MM/DD/YYYY");
		System.out.println("Enter 2 for format: Month DD, YYYY");
		System.out.println("Enter 3 for format: DDD YYYY");
		System.out.println("Enter 4 for exit");
		System.out.print("Selection: ");
	}
	/**
	 * display the various date formats based on the given date object
	 * @param d - Date object
	 */
	public static void displayDates(Date d) {
		System.out.println("MM/DD/YYYY:      " + d.getMonth() + "/" + d.getDay() + "/" + d.getYear());
		System.out.println("Month DD, YYYY:  " + d.getMonthName() + " " + d.getDay() + ", " + d.getYear());
		System.out.println("DDD YYYY:        " + d.getDayOfYear() + " " + d.getYear());
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
		scan.nextLine();
		return again;
	}		
}

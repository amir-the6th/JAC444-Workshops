import java.util.Scanner;

public class DateProgram {
	public static void main(String[] args) {
		welcomeHeader();
		mainMenu();
		runMenu();
	}
	public static void runMenu() {
		int dd, mm, yyyy, dOfYear, ch = 0;
		String mName;
		Scanner scan = new Scanner(System.in);
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
			System.out.print("Enter Month(January - December): ");
			mName = du.promptString();
			System.out.print("Enter Day of Month: ");
			dd = scan.nextInt();
			System.out.print("Enter Year: ");
			yyyy = scan.nextInt();
			Date date2 = new Date(mName,dd,yyyy);
			scan.nextLine();
			displayDates(date2);
			break;
		case 3:
			System.out.print("Enter Day of Year: ");
			dOfYear = scan.nextInt();
			System.out.print("Enter Year: ");
			yyyy = scan.nextInt();
			Date date3 = new Date(dOfYear,yyyy);
			scan.nextLine();
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
		
		scan.close();
	}
	/**
	 * Prints a welcome header when the user runs the program
	 */
	public static void welcomeHeader() {
		System.out.println("Welcome to Amir's date conversion program!");
		System.out.println("------------------------------------------");
	}
	public static void mainMenu() {
		System.out.println("Enter 1 for format: MM/DD/YYYY");
		System.out.println("Enter 2 for format: Month DD, YYYY");
		System.out.println("Enter 3 for format: DDD YYYY");
		System.out.println("Enter 4 for exit");
		System.out.print("Selection: ");
	}
	public static void displayDates(Date d) {
		System.out.println("MM/DD/YYYY:      " + d.getMonth() + "/" + d.getDay() + "/" + d.getYear());
		System.out.println("Month DD, YYYY:  " + d.getMonthName() + " " + d.getDay() + ", " + d.getYear());
		System.out.println("DDD YYYY:        " + d.getDayOfYear() + " " + d.getYear());
	}
}

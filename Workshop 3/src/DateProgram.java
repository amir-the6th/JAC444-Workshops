import java.util.Scanner;

public class DateProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		mainMenu();
		int ch = scan.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter Month(1-12): ");
			int mm = scan.nextInt();
			System.out.println("Enter Day of Month: ");
			int dd = scan.nextInt();
			System.out.println("Enter Year: ");
			int yyyy = scan.nextInt();
			Date date = new Date(dd,mm,yyyy);
			displayDates(date);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			System.out.println("Thank you for using our program. Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("WRONG CHOICE! only 1, 2, 3, or 4 are valid.");
			break;
		}
		
		scan.close();
	}
	/**
	 * Prints a welcome header when the user runs the program
	 */
	public static void welcomeHeader() {
		System.out.println("Welcome to Amir's date conversion program!");
		System.out.print("--------------------------------------------");
	}
	public static void mainMenu() {
		System.out.println("Enter 1 for format: MM/DD/YYYY");
		System.out.println("Enter 2 for format: Month DD, YYYY");
		System.out.println("Enter 3 for format: DDD YYYY");
		System.out.println("Enter 4 for exit");
		System.out.print("Selection: ");
	}
	public static void displayDates(Date date) {
		System.out.println("MM/DD/YYYY:      ");
		System.out.println("Month DD, YYYY:  ");
		System.out.println("DDD YYYY:        ");
	}
}

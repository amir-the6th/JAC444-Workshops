import java.util.Scanner;

public class Craps {
	static int die1, die2, round;
	
	public static int roll() {
		int rolledNum = (int)((Math.random() * 6) + 1);
		 //die1 = (int)((Math.random() * 6) + 1);
		 //die2 = (int)((Math.random() * 6) + 1);
		return rolledNum;
	}
	
	public void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
	}
	
	public static void main(String[] args) {
		int sum, sum2;
		Craps c = new Craps();
		System.out.println("****** Welcome to craps! ******\n\nShall we roll?");
		c.promptEnterKey();
		System.out.println("Round #" + ++round);
		die1 = roll();
		System.out.println("Die #1 ----> " + die1);
		die2 = roll();
		System.out.println("Die #2 ----> " + die2);
		sum = die1 + die2;
		if (sum == 7 || sum == 11) {
			System.out.println("Sum: " + sum);
			System.out.println("Congratulations You Won!");
		} 
		else if (sum == 2 || sum == 3 || sum == 12) {
			System.out.println("Sum: " + sum);
		    System.out.println("Craps, Better Luck Next Time, You Lost!");
	    }
		else {
			System.out.println("Point is (established) set to " + sum );
			c.promptEnterKey();
		}
		do {
		die1 = roll();
		die2 = roll();
		System.out.println("Round #" + ++round + "\nDie #1 ----> " + die1 + "\nDie #2 ----> " + die2);
		sum2 = die1 + die2;
		if(sum2 == sum) {
			System.out.println("Sum: " + sum2);
			System.out.println("Congratulations, You Won!");
			break;
		}
		else if(sum2 == 7) {
			System.out.println("Craps, Better Luck Next Time, You Lost!");
			break;
		}
		c.promptEnterKey();
		} while(true); //while(sum2 != sum || sum2 != 7);
	}
}

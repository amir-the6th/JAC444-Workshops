/**********************************************
Workshop #1
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-09-26
**********************************************/

import java.util.Scanner;

public class AdvancedCraps {
	static int die1, die2, round;
	static double bankBalance = 1000.00;
	
	/**
	 * This method rolls the dice (generates a random number between 1 - 6)
	 * @return rolledNum -> returns the randomly generated number
	 */
	public static int roll() {
		int rolledNum = (int)((Math.random() * 6) + 1);
		 //die1 = (int)((Math.random() * 6) + 1);
		 //die2 = (int)((Math.random() * 6) + 1);
		return rolledNum;
	}
	
	/**
	 * This method prompts the user to continue the program by pressing the Enter key
	 */
	public void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
	}
	
	/**
	 * main method: Advanced Craps Game
	 * @param args
	 */
	public static void main(String[] args) {
		int sum, sum2;
		Craps c = new Craps();
		//System.out.println("****** Welcome to craps! ******\n\nShall we roll?");
		System.out.println("****** Welcome to craps! ******\n\n");
		Scanner scan = new Scanner(System.in);
		while(bankBalance > 0) {
			System.out.print("Enter a wager: ");
			double wager = scan.nextDouble();
			if(wager > bankBalance) {
				System.out.println("Sorry, you do not have enough money to afford the wager.");
			}
			else {
				if(wager == bankBalance) {
					System.out.println("Ohhh nice! You've got courage to go all in.");
				}
				System.out.println("Shall we roll?");
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
					bankBalance += wager;
					System.out.println("Your current balance is: " + bankBalance);
					//////////////////////
					System.out.print("Do you want to play again?\n1. Yes\n2. No\nSelection: ");
					byte input = scan.nextByte();
					while (input != 1 && input != 2) {
						System.out.println("\n*** INCORRECT SELECTION! ***\n");
						System.out.print("Selection: ");
						input = scan.nextByte();
					}
					if(input == 1) {
						System.out.println("\nYay! Let's get rich ^-^");
						round = 0;
						continue;
					}
					else {
						System.out.println("\nYucks! Farewell is always hard :')\nPay us a visit again later!");
						break;
					}
				} 
				else if (sum == 2 || sum == 3 || sum == 12) {
					System.out.println("Sum: " + sum);
				    System.out.println("Craps, Better Luck Next Time, You Lost!");
				    bankBalance -= wager;
					System.out.println("Your current balance is: " + bankBalance);
					if(bankBalance <= 0) {
						System.out.println("Sorry, You Got Busted!\nCome back later with more cash.");
						return;
					}
					//////////////////////
					System.out.print("Do you want to play again?\n1. Yes\n2. No\nSelection: ");
					byte input = scan.nextByte();
					while (input != 1 && input != 2) {
						System.out.println("\n*** INCORRECT SELECTION! ***\n");
						System.out.print("Selection: ");
						input = scan.nextByte();
					}
					if(input == 1) {
						System.out.println("\nYay! Let's get rich ^-^");
						round = 0;
						continue;
					}
					else {
						System.out.println("\nYucks! Farewell is always hard :')\nPay us a visit again later!");
						break;
					}
			    }
				else {
					System.out.println("Point is (established) set to " + sum );
					c.promptEnterKey();
					do {
						die1 = roll();
						die2 = roll();
						System.out.println("Round #" + ++round + "\nDie #1 ----> " + die1 + "\nDie #2 ----> " + die2);
						sum2 = die1 + die2;
						if(sum2 == sum) {
							System.out.println("Sum: " + sum2);
							System.out.println("Congratulations, You Won!");
							bankBalance += wager;
							System.out.println("Your current balance is: " + bankBalance);
							break;
						}
						else if(sum2 == 7) {
							System.out.println("Craps, Better Luck Next Time, You Lost!");
							bankBalance -= wager;
							System.out.println("Your current balance is: " + bankBalance);
							if(bankBalance <= 0) {
								System.out.println("Sorry You Got Busted!\nCome back later with more cash.");
								return;
							}
							break;
						}
						c.promptEnterKey();
					} while(true); //while(sum2 != sum || sum2 != 7);
					
					//////////////////////
					System.out.print("Do you want to play again?\n1. Yes\n2. No\nSelection: ");
					byte input = scan.nextByte();
					while (input != 1 && input != 2) {
						System.out.println("\n*** INCORRECT SELECTION! ***\n");
						System.out.print("Selection: ");
						input = scan.nextByte();
					}
					if(input == 1) {
						System.out.println("\nYay! Let's get rich ^-^");
						round = 0;
						continue;
					}
					else {
						System.out.println("\nYucks! Farewell is always hard :')\nPay us a visit again later!");
						break;
					}
				}
			}
		}	
	}
}

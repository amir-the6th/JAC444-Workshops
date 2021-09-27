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

public class SecureData {
	
	/*
	int code;
	SecureData(int num){
		code = num;
	}
	*/
	
	/**
	 * This method replaces each digit with the result of adding 7 to the digit and getting the remainder 
	 * after dividing the new value by 10. It then swaps the first digit with the third and swaps the second digit with the fourth.
	 * @param data -> the raw number that is passed by the user
	 * @return result -> returns the encrypted integer
	 */
	public int encrypt(int data) {

		int dig1 = data / 1000;
		int dig2 = (data % 1000) / 100;
		int dig3 = (data % 100) / 10;
		int dig4 =  data % 10;
		
		dig1 = (dig1 + 7) % 10;
		dig2 = (dig2 + 7) % 10;
		dig3 = (dig3 + 7) % 10;
		dig4 = (dig4 + 7) % 10;

		int result = (dig3*1000) + (dig4*100) + (dig1*10) + dig2;
		return result;
	}
	
	/**
	 * This method inputs an encrypted four-digit integer and decrypts it
	 * (by reversing the encryption scheme) to form the original number.
	 * @param data -> the encrypted number that is passed by the user
	 * @return result -> returns the decrypted number
	 */
	public int decrypt(int data) {
		
		int dig1 = data / 1000;
		int dig2 = (data % 1000) / 100;
		int dig3 = (data % 100) / 10;
		int dig4 =  data % 10;
		
		// decryption formula: ((digit + 10 - 7) % 10)
		dig1 = (dig1 + 3) % 10;
		dig2 = (dig2 + 3) % 10;
		dig3 = (dig3 + 3) % 10;
		dig4 = (dig4 + 3) % 10;

		int result = (dig3*1000) + (dig4*100) + (dig1*10) + dig2;
		return result;
	}
	
	/**
	 * the main method 
	 * @param args
	 */
	public static void main(String[] args) {
		SecureData sc = new SecureData();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the most secure data protection application!");
		System.out.println("\nHow can we assist you today?");
		System.out.println("1. Encrypt my data");
		System.out.println("2. Decrypt my data");
		System.out.print("Selection: ");
		byte input = scan.nextByte();
		while (input != 1 && input != 2) {
			System.out.println("\n*** INCORRECT SELECTION! ***\nTo encrypt your data, enter 1, and to decrypt it, enter 2.");
			System.out.print("Selection: ");
			input = scan.nextByte();
		}
		
		if(input == 1) {
			System.out.println("******* Encryption Porgram *******");
			System.out.print("Please enter a four digit number: ");
			int data = scan.nextInt();
			System.out.println("Your encrypted number is: " + sc.encrypt(data) + ". Please keep it somewhere safe!");
		}
		else {
			System.out.println("******* Decryption Porgram *******");
			System.out.print("Please enter a four digit number: ");
			int data = scan.nextInt();
			System.out.println("Your encrypted number is: " + sc.decrypt(data));
		}
	}
	// To do: create a mainMenu method and ask the user if they want to enc/dec another num.
}

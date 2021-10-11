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

public class MyInteger {
	private int value;
	/**
     * main method
     * @param args
     */
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String checkMark = "\u2611";
		String xMark = "\u274E";
		
    	System.out.println("Welcome to Amir's date conversion program!");
		System.out.println("------------------------------------------");
		System.out.print("Enter an integer: ");
		int num = scan.nextInt();
		MyInteger intUser = new MyInteger(num);
		
		System.out.printf("%nIs %d prime? %s%n", intUser.getValue(), intUser.isPrime() ? checkMark : xMark);
		System.out.printf("Is %d odd?   %s%n", intUser.getValue(), intUser.isOdd() ? checkMark : xMark);
		System.out.printf("Is %d even?  %s%n%n", intUser.getValue(), intUser.isEven() ? checkMark : xMark);
		MyInteger.printDivider();

		System.out.println("\nTesting your number with a bunch of randomly generated numbers...");
		
		int rand1 = (int)((Math.random() * 100));
		int rand2 = (int)((Math.random() * 100));
		int rand3 = (int)((Math.random() * 100));
		MyInteger int1 = new MyInteger(rand1);
		MyInteger int2 = new MyInteger(rand2);
		MyInteger int3 = new MyInteger(rand3);
		
		System.out.println("First random number:  " + rand1);
		System.out.println("Second random number: " + rand2);
		System.out.println("Third random number:  " + rand3);
		System.out.println();
		
		System.out.printf("Is %d prime? %s%n", int1.getValue(), int1.isPrime() ? checkMark : xMark);
		System.out.printf("Is %d odd?   %s%n", int1.getValue(), int1.isOdd() ? checkMark : xMark);
		System.out.printf("Is %d even?  %s%n%n", int1.getValue(), int1.isEven() ? checkMark : xMark);
		
		System.out.printf("Is %d prime? %s%n", int2.getValue(), MyInteger.isPrime(int2.getValue()) ? checkMark : xMark);
		System.out.printf("Is %d odd?   %s%n", int2.getValue(), MyInteger.isOdd(int2.getValue()) ? checkMark : xMark);
		System.out.printf("Is %d even?  %s%n%n", int2.getValue(), MyInteger.isEven(int2.getValue()) ? checkMark : xMark);
		
		System.out.printf("Is %d prime? %s%n", int3.getValue(), MyInteger.isPrime(int3) ? checkMark : xMark);
		System.out.printf("Is %d odd?   %s%n", int3.getValue(), MyInteger.isOdd(int3) ? checkMark : xMark);
		System.out.printf("Is %d even?  %s%n%n", int3.getValue(), MyInteger.isEven(int3) ? checkMark : xMark);
		MyInteger.printDivider();
		
		System.out.printf("%nAre %d and %d equal?   %s%n%n", intUser.getValue(), int1.getValue(), intUser.equals(int1.getValue()) ? checkMark : xMark);
		System.out.printf("Are %d and %d equal?   %s%n%n", int2.getValue(), int3.getValue(), int2.equals(int3) ? checkMark : xMark);
		MyInteger.printDivider();
		
		System.out.println("\nNow, it's time to convert an array of numeric characters to an int value");
		System.out.println("the character array is {'3', '9', '6'}");
		System.out.printf("Result: %d%n%n", MyInteger.parseInt(new char[] {'3', '9', '6'}));
		MyInteger.printDivider();

		System.out.println("\nNow, Let's convert a string to an int value");
		System.out.println("the string is \"666\"");
        System.out.printf("Result: %d%n", MyInteger.parseInt("666"));
    }
	/**
	 * 1-arg constructor
	 * @param val -> specified value that is passed to the object
	 */
	public MyInteger(int val) {
		this.value = val;
	}
	/**
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * checks if the value is even
	 * @return
	 */
	public boolean isEven() {
		return value % 2 == 0;
	}
	/**
	 * checks if the value is odd
	 * @return
	 */
	public boolean isOdd() {
		return value % 2 == 1;
	}
	/**
	 * checks if the value is prime
	 * @return
	 */
	public boolean isPrime() {
		boolean prime = true;

		if (value <= 1)
			prime = false;
  
        // Check from 2 to n-1
        for (int i = 2; i < value; i++)
            if (value % i == 0)
            	prime = false;
  
        return prime;
	}
	/**
	 * checks if the value of the parameter is even
	 * @return
	 */
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
	/**
	 * checks if the value of the parameter is odd
	 * @return
	 */
	public static boolean isOdd(int num) {
		return num % 2 == 1;
	}
	/**
	 * checks if the value of the parameter is prime
	 * @return
	 */
	public static boolean isPrime(int num) {
		boolean prime = true;
		
		if (num <= 1)
			prime = false;
		
		// Check from 2 to n-1
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				prime = false;
		
		return prime;
	}
	/**
	 * checks if the value of the object is even
	 * @return
	 */
	public static boolean isEven(MyInteger mi) {
		return mi.value % 2 == 0;
	}
	/**
	 * checks if the value of the parameter is odd
	 * @return
	 */
	public static boolean isOdd(MyInteger mi) {
		return mi.value % 2 == 1;
	}
	/**
	 * checks if the value of the parameter is prime
	 * @return
	 */
	public static boolean isPrime(MyInteger mi) {
		boolean prime = true;
		
		if (mi.value <= 1)
			prime = false;
		
		// Check from 2 to n-1
		for (int i = 2; i < mi.value; i++)
			if (mi.value % i == 0)
				prime = false;
		
		return prime;
	}
	/**
	 * checks if the value of the parameter and
	 * the value of this object are equal
	 * @return
	 */
	public boolean equals(int num) {
		return num == this.value;
	}
	/**
	 * checks if the value of an object and
	 * the value of this object are equal
	 * @return
	 */
	public boolean equals(MyInteger mi) {
		return mi.value == this.value;
	}
	/**
	 * converts an array of numeric characters to an int value
	 * @param chars
	 * @return sum
	 */
    public static int parseInt(char[] chars) {
    	int sum = 0;
    	for(char ch : chars) {
    		sum += ch - '0'; // Logic 1: this logic uses TypeCasting to get the ASCII value of the given character.
    		//sum += Integer.parseInt(String.valueOf(ch)); // Logic 2: using String.valueOf() and Integer.parseInt() method
    		//sum += Character.getNumericValue(ch); // using Character.getNumericValue() method
    	}
    	return sum;
    }
    /**
     * converts a string to an int value
     * @param str
     * @return 
     */
    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
    /**
     * prints a divider
     */
    public static void printDivider() {
    	for(int i = 0; i < 65; i++) {
    		System.out.print('*');
    	}
    	System.out.println();
    }
}

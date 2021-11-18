package ca.senecacollege.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestArrayProcessor {

	/**
	 * returns the maximum value of an array
	 */
	public static final ArrayProcessor max = arr -> {
		double max = 0.0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i];
		}
		return max;
	};

	/**
	 * returns the minimum value of an array
	 */
	public static final ArrayProcessor min = arr -> {
		double min = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min) min = arr[i];
		}
		return min;
	};
	
	/**
	 * returns the sum of the values in an array
	 */
	public static final ArrayProcessor sum = arr -> {
		double sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	};
	
	/**
	 * returns the average of the values in the array
	 */
	public static final ArrayProcessor avg = arr -> 
		sum.operations(arr) / arr.length;
	
	/**
	 * returns the number of times a value occurs in an array
	 * @param value
	 */
	public static ArrayProcessor counter(double value) {
		return arr -> {
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == value) cnt++;
			}
			return cnt;
		};
	};
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many elements you want to enter? ");
		int num = scan.nextInt();
		double[] userArray = fillArray(num);
		System.out.println("====================");
		for(int i = 0; i < userArray.length; i++) {
			System.out.println(userArray[i]);
		}
		System.out.println("====================");
		
		System.out.println("Sum of the elements of the user list... " + sum.operations(userArray));
		System.out.println("Average of the elements of the user list... " + avg.operations(userArray));
		System.out.println("Maximum of the user list... " + max.operations(userArray));
		System.out.println("Minimum of the user list... " + min.operations(userArray));
		System.out.println("Count of 3.0 in the user list... " + counter(3.0).operations(userArray));
		System.out.println("Count of 26.0 in the user list... " + counter(26.0).operations(userArray));
		System.out.println();
		
		scan.close();
	}
	
	public static double[] fillArray(int num) {
		Scanner input = new Scanner(System.in);
		double[] arr = null, arr2 = null;
		try {
			arr = new double[num];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = input.nextDouble();
			}
			System.out.print("Add more? (y/n) ");
            if (input.next().startsWith("y")) {
            	System.out.print("How many more numbers? ");
            	int num2 = num + input.nextInt();
            	arr2 = new double[num2];
            	for(int i = 0; i < arr.length; i++) arr2[i] = arr[i];
            	for(int i = num; i < arr2.length; i++) arr2[i] = input.nextDouble();
            }
		} catch (InputMismatchException e) {
			System.out.print("Wrong input, re-enter: ");
			input.next();
		}
		input.close();
		return arr2 != null ? arr2 : arr;
	}

}

/**********************************************
Workshop #9
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-12-01
**********************************************/
package task1;

public class TestMultiplication {
	final static int SIZE = 2000;
	static long beginTime = System.currentTimeMillis(), stopTime;
	static double[][] a = new double[SIZE][SIZE];
	static double[][] b = new double[SIZE][SIZE];
	static double[][] res;
	
	public static void main(String[] args) {		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				a[i][j] = Math.random() * 1000;
				b[i][j] = Math.random() * 1000;
			}
		}
		
		// parallel method
		System.out.println("Starting Parallel Thread!");
		Thread t1 = new Thread(new MatrixMultiplication(a, b, 0, SIZE/4));
		Thread t2 = new Thread(new MatrixMultiplication(a, b, SIZE/4, (SIZE*2)/4));
		Thread t3 = new Thread(new MatrixMultiplication(a, b, (SIZE*2)/4, (SIZE*3)/4));
		Thread t4 = new Thread(new MatrixMultiplication(a, b, (SIZE*3)/4, SIZE));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) { e.printStackTrace(); };	
		stopTime = System.currentTimeMillis();
		System.out.println("The execution time for adding the matrices together using threading: " + (stopTime-beginTime) + " milliseconds");
		
		// sequential method
		System.out.println("\nStarting Sequential Method!");
		MatrixMultiplication.sequentialMultiplyMatrix(a, b);
		stopTime = System.currentTimeMillis();
		System.out.println("The execution time for adding the matrices together using sequential call: " + (stopTime-beginTime) + " milliseconds");
	}
}

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

public class MatrixMultiplication implements Runnable {
	double[][] a, b;
	static double[][] result;
	static int startPoint;
	static int endPoint;
	
	MatrixMultiplication(double[][] a, double[][] b, int sp, int ep) {
		this.a = a;
		this.b = b;
		startPoint = sp;
		endPoint = ep;
	}

	@Override
	public void run() {
		result = parallelMultiplyMatrix(a, b);
	}
	
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
        result = new double[a.length][b.length];
        for(int i = startPoint; i < endPoint; i++)
            for(int j = 0; j < a[i].length; j++)
                result[i][j] = a[i][j] * b[i][j];
        return result;
    }
	
    public static double[][] sequentialMultiplyMatrix(double[][] c, double[][] d) {
        result = new double[c.length][d.length];
        for(int i = 0; i < c.length; ++i)
            for(int j = 0; j < d.length; ++j)
                result[i][j] = c[i][j] * d[i][j];
        return result;
    }
}

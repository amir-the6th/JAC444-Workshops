
public class MyInteger {
	private int value;
	public MyInteger(int val) {
		this.value = val;
	}
	public int getValue() {
		return value;
	}
	public boolean isEven() {
		return value % 2 == 0;
	}
	public boolean isOdd() {
		return value % 2 == 1;
	}
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
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
	public static boolean isOdd(int num) {
		return num % 2 == 1;
	}
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
	public static boolean isEven(MyInteger mi) {
		return mi.value % 2 == 0;
	}
	public static boolean isOdd(MyInteger mi) {
		return mi.value % 2 == 1;
	}
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
	public boolean equals(int num) {
		return num == this.value;
	}
	public boolean equals(MyInteger mi) {
		return mi.value == this.value;
	}
    public static int parseInt(char[] chars) {
    	int sum = 0;
    	for(char ch : chars) {
    		sum += ch - '0'; // Logic 1: this logic uses TypeCasting to get the ASCII value of the given character.
    		//sum += Integer.parseInt(String.valueOf(ch)); // Logic 2: using String.valueOf() and Integer.parseInt() method
    		//sum += Character.getNumericValue(ch); // using Character.getNumericValue() method
    	}
    	return sum;
    }
    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
    
    public static void main(String[] args) {

    }
}

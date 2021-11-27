import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PrimeFactors {

	public static void main(String[] args) {
		int input = 0;
		boolean exit = false;
		
        while(!exit) {
        	System.out.print("Please enter a number: " );
        	input = readInt();
        	if(isPrime(input)) {
        		System.out.println(input + " is a prime number!");
        		if(!runAgain()) exit = true;
        	}
            else {
            	System.out.println("prime factors of " + input + " are: " + factorize(input));
            	if(!runAgain()) exit = true;
            }
        }
	}
        
	public static boolean isPrime(int num) {
		boolean isPrime = true;
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }    
		
    public static Set<Integer> factorize(int num) {
    	int factor = 2;
        Set<Integer> primeFactors = new TreeSet<Integer>();
        
        while(num > 1) {
        	if(isPrime(factor) && num % factor == 0) {
        		primeFactors.add(factor);
        		num /= factor;
        	} else factor++;
        }
		return primeFactors;
    }
    
    public static int readInt() {
		Scanner scan = new Scanner(System.in);
    	int num = scan.nextInt();
		return num;
    }
    
    public static boolean runAgain() {
		boolean again;
		Scanner scan = new Scanner(System.in);
		System.out.print("\nRun again? (Type \"No\" if you want to exit) ");
		String input = scan.nextLine();
		
		if(input.equalsIgnoreCase("no")) {
			System.out.println("Thank you for using our program. Goodbye!");
			again = false;
		}
		else again = true;
		return again;
	}		
}

import ca.senecacollege.abstracts.*;
import ca.senecacollege.concrete.*;
import java.util.Scanner;

/**
 * Class: PayrollTest
 * Tests the program
 * @author Amir
 *
 */
public class PayrollTest {

	/**
	 * @param args
	 * @throws Exception 	
	 */
	public static void main(String[] args) throws Exception {
		
		////////////// EMPLOYEE PAYROLL TEST ///////////////
		
		HourlyEmployee hourlyEmployee =  new HourlyEmployee("Amir", "Sabagh", "666-66-6666", 16.5, 47);
		SalariedEmployee salariedEmployee =  new SalariedEmployee("Elon", "Musk", "333-33-3333", 1500.00);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Walter", "White", "123-45-6789", 20000, .04);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee( "Sam", "Whisperson", "987-65-4321", 7000, .06, 500);

		printHeader(1);
		
		System.out.println("***************************************");
		System.out.println("*** Print Each Employee Information ***");	
		System.out.println("***************************************\n");
		System.out.printf("Employee #1 - Hourly Employee:\n%s\n\n",hourlyEmployee);
		System.out.printf("Employee #2 - Salaried Employee:\n%s\n\n", salariedEmployee);
		System.out.printf("Employee #3 - Comission Employee:\n%s\n\n",commissionEmployee);
		System.out.printf("Employee #4 - Base Plus Commission Employee:\n%s\n\n",  basePlusCommissionEmployee);
		 
		Employee employees[] = new Employee[ 4 ]; 
		  
		employees[0] = hourlyEmployee;
		employees[1] = salariedEmployee;
	    employees[2] = commissionEmployee; 
		employees[3] = basePlusCommissionEmployee;
		
		System.out.println("******************************************");
		System.out.println("*** Print Each Employee Payment Amount ***");	
		System.out.println("******************************************\n");
 		      
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invoke toString and print emp info
		 
			// if employee is a BasePlusCommissionEmployee -> increase base salary by 10%
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee employee= (BasePlusCommissionEmployee)currentEmployee;	
			    employee.setBaseSalary(1.10 * employee.getBaseSalary());
			    System.out.println("New Base Salary After 10%% Reward: " + employee.getBaseSalary());
			} 
			System.out.printf("Earned: $%,.2f\n\n", currentEmployee.getPaymentAmount() ); //print payment amount
		}
		
		////////////// INVOICE TEST ///////////////
	
		Scanner input = new Scanner(System.in);

		System.out.println("\n");
		printHeader(2);
		
		System.out.print("Enter Part Number: ");
		String partNum = input.next();
		input.reset();
		System.out.print("\nEnter Part Description: ");
		String partDesc = input.next();
		input.reset();
		System.out.print("\nEnter Quantity: ");
		int q = input.nextInt();
		input.reset();
		System.out.print("\nEnter Price Per Item: ");
		double pricePI = input.nextDouble();
		input.reset();
		
		Invoice invoice1 = new Invoice(partNum, partDesc, q, pricePI);
		printInvoice(invoice1);
		
		System.out.println("\n\nTesting another invoice...");
		Invoice invoice2 = new Invoice("564", "test2", 6, 300);
		printInvoice(invoice2);

	}
	
	public static void printHeader(int i) {
		System.out.println("***************************");
		System.out.println("***************************");
		if(i == 1) System.out.println("*** PAYROLL SYSTEM TEST ***");
		else if(i == 2) System.out.println("*** INVOICE SYSTEM TEST ***");
		System.out.println("****                   ****");
		System.out.println("*****                 *****");
		System.out.println("******               ******");
		System.out.println("*******             *******");
		System.out.println("********           ********");
		System.out.println("*********         *********");
		System.out.println("**********       **********");
		System.out.println("***********     ***********");
		System.out.println("************   ************");
		System.out.println("************* *************");
		System.out.println("***************************\n\n");
	}
	public static void printInvoice(Invoice inv) {
		System.out.println("_________________________________");
		System.out.println("|\n| Date:               " + java.time.LocalDate.now());
		System.out.println("| Invoice No:         " + inv.getInvoiceNo());
		System.out.println("|\n|\n|\n|\n|");
		System.out.printf("| %s\n", inv);
		System.out.printf("| Total:              $%,.2f\n", inv.getPaymentAmount());
		System.out.println("_________________________________");
	}
}

/**
 * 
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author amirs
 *
 */
public class FileMatch {

	/**
	 * 
	 */
	public FileMatch() {
		// TODO Auto-generated constructor stub
	}
	
	public static void matchOldWithTrans() throws IOException {
		String accLine, transLine;
		Account acc = new Account();
		TransactionRecord tr = new TransactionRecord();
		
		BufferedReader inputTrans = null, inputAccount = null;
		PrintWriter outputNewMaster = null, outputLog = null;
		try {
			inputTrans	 =    new BufferedReader (new FileReader("trans.txt"));
			inputAccount = 	  new BufferedReader (new FileReader("oldmast.txt"));
			outputNewMaster = new PrintWriter    (new FileWriter("newmast.txt"),true);
			outputLog = 	  new PrintWriter 	 (new FileWriter("log.txt"),true);
			while ((accLine = inputAccount.readLine()) != null) {
				String[] splitAcc = accLine.split(" ");	
				acc.setAccNum(Integer.parseInt(splitAcc[0]));
				acc.setfName(splitAcc[1]);
				acc.setlName(splitAcc[2]);
				acc.setBalance(Double.parseDouble(splitAcc[3]));
				
				while((transLine = inputTrans.readLine()) != null) {
					String[] splitTrans = transLine.split(" ");
					tr.setAccNum(Integer.parseInt(splitTrans[0]));
					tr.setAmount(Double.parseDouble(splitTrans[1]));
					
					// When a match occurs, combine tr and acc balances and write the "newmast.txt" record.
					if(tr.getAccNum() == acc.getAccNum()) {
						System.out.printf("%nMatch found! Account %d's balance has been increased by %.2f.%n", tr.getAccNum(), tr.getAmount());
						System.out.println("New account balance is " + acc.combine(tr));
						System.out.println("Saving new data to 'newmast.txt'\n");
						outputNewMaster.println(acc.getAccNum() + " " + acc.getfName() + " " + acc.getlName() + " " + acc.getBalance());
					}
				}
			}
			
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}

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
	static String accLine, transLine;
	
	static BufferedReader inputTrans = null, inputAccount = null;
	static PrintWriter outputNewMaster = null, outputLog = null;

	/**
	 * @throws IOException 
	 * 
	 */
	public FileMatch() throws IOException {
		matchOldWithTrans();
		checkUnmatchedTransactions();
	}
	
	public static void matchOldWithTrans() throws IOException {
		try {
			inputTrans	 	= new BufferedReader (new FileReader("trans.txt"));
			inputAccount 	= new BufferedReader (new FileReader("oldmast.txt"));
			outputNewMaster = new PrintWriter    (new FileWriter("newmast.txt"),true);
			
			TransactionRecord tr = setTransactionRecord(inputTrans.readLine());
			while ((accLine = inputAccount.readLine()) != null) {
				Account acc = setAccountRecord(accLine);
				
				while (acc.getAccNum() > tr.getAccNum()) {
					tr = setTransactionRecord(inputTrans.readLine());
				}  
                
				while (acc.getAccNum() == tr.getAccNum()){
					acc.combine(tr);
					if((transLine = inputTrans.readLine()) != null) {
						tr = setTransactionRecord(transLine);
					} else break;
				}
				
				/*
				while((transLine = inputTrans.readLine()) != null) {
					String[] splitTrans = transLine.split(" ");
					tr.setAccNum(Integer.parseInt(splitTrans[0]));
					tr.setAmount(Double.parseDouble(splitTrans[1]));
					
					// When a match occurs, combine transaction and old master amounts and write a "newmast.txt" record.
					if(tr.getAccNum() == acc.getAccNum()) {
						System.out.printf("%nMatch found! Account %d's balance has been increased by %.2f.%n", tr.getAccNum(), tr.getAmount());
						System.out.println("New account balance is " + acc.combine(tr));
						outputNewMaster.println(acc.getAccNum() + " " + acc.getfName() + " " + acc.getlName() + " " + acc.getBalance());
					}
					
					// When there’s a transaction record, but no corresponding master record, write a "log.txt" record. 
					if(tr.getAccNum() != acc.getAccNum()) {
						System.out.println("Unmatched transaction record for account number " + tr.getAccNum());
						outputLog.println("Unmatched transaction record for account number " + tr.getAccNum());
					}
				}
				*/
				
				outputNewMaster.println(acc.getAccNum() + " " + acc.getfName() + " " + acc.getlName() + " " + acc.getBalance());
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (inputTrans != null)		 inputTrans.close();
			if (inputAccount != null) 	 inputAccount.close();
			if (outputNewMaster != null) outputNewMaster.close();
		}
	}
	
	public static void checkUnmatchedTransactions() throws IOException {
		try {
			inputTrans	 	= new BufferedReader (new FileReader("trans.txt"));
			inputAccount 	= new BufferedReader (new FileReader("oldmast.txt"));
			outputLog 		= new PrintWriter 	 (new FileWriter("log.txt"),true);
			
			Account acc = setAccountRecord(inputAccount.readLine());
			while((transLine = inputTrans.readLine()) != null) {
				TransactionRecord tr = setTransactionRecord(transLine);
				while(tr.getAccNum() > acc.getAccNum() && (accLine = inputAccount.readLine()) != null) {
						acc = setAccountRecord(accLine);
				}
				if(acc.getAccNum() != tr.getAccNum()) {
					outputLog.println("Unmatched transaction record for account number " + tr.getAccNum());
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (inputTrans != null)		 inputTrans.close();
			if (inputAccount != null) 	 inputAccount.close();
			if (outputLog != null)		 outputLog.close();
		}
	}
	
	public static Account setAccountRecord(String str) {
		if(str != null) {
			String[] splitAcc = str.split(" ");	
			return new Account(Integer.parseInt(splitAcc[0]),splitAcc[1],splitAcc[2],Double.parseDouble(splitAcc[3]));
		}
		return null;
	}
	
	public static TransactionRecord setTransactionRecord(String str) {
		String[] splitTrans = str.split(" ");	
		return new TransactionRecord(Integer.parseInt(splitTrans[0]),Double.parseDouble(splitTrans[1]));
	}
}

/**********************************************
Workshop #5
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-11-01
**********************************************/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author Amir
 *
 */
public class FileMatch {
	static String accLine, transLine;
	
	static BufferedReader inputTrans = null, inputAccount = null;
	static PrintWriter outputNewMaster = null, outputLog = null;

	/**
	 * no-arg constructor
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
				
				// when there's a master record but no corresponding transaction record 
				while (acc.getAccNum() > tr.getAccNum()) {
					tr = setTransactionRecord(inputTrans.readLine());
				}  
                
				// when a match occurs, combine the amounts and add it to the master record
				while (acc.getAccNum() == tr.getAccNum()){
					acc.combine(tr);
					if((transLine = inputTrans.readLine()) != null) {
						tr = setTransactionRecord(transLine);
					} else break;
				}
				
				// write the master record to newmast.txt
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

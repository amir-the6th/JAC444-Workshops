/**
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author amirs
 *
 */
public class CreateData {

	/**
	 * @throws IOException 
	 * 
	 */
	CreateData() throws IOException {
		try(PrintWriter oldMaster = new PrintWriter(new FileWriter("oldmast.txt"),true)) {
			writeOldMaster(oldMaster, new Account(100, "Alan", "Jones", 348.17));
			writeOldMaster(oldMaster, new Account(300, "Mary", "Smith", 27.19));
			writeOldMaster(oldMaster, new Account(500, "Sam", "Sharp", 0.00));
			writeOldMaster(oldMaster, new Account(700, "Suzy", "Green", -14.22));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(PrintWriter transcation = new PrintWriter(new FileWriter("trans.txt"),true)) {
			writeTransaction(transcation, new TransactionRecord(100, 27.14));
			writeTransaction(transcation, new TransactionRecord(300, 62.11));
			writeTransaction(transcation, new TransactionRecord(300, 83.89));
			writeTransaction(transcation, new TransactionRecord(400, 100.56));
			writeTransaction(transcation, new TransactionRecord(700, 80.78));
			writeTransaction(transcation, new TransactionRecord(700, 1.53));
			writeTransaction(transcation, new TransactionRecord(900, 82.17));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void writeOldMaster(PrintWriter om, Account acc) {
		om.println(acc.getAccNum() + " " + acc.getfName() + " " + acc.getlName() + " " + acc.getBalance());
	}
	
	private void writeTransaction(PrintWriter om, TransactionRecord tr) {
		om.println(tr.getAccNum() + " " + tr.getAmount());
	}

}

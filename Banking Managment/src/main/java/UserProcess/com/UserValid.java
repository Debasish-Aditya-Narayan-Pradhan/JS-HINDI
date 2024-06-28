package UserProcess.com;

import java.sql.ResultSet;

public interface UserValid {

	boolean addUser(String name,String phn,String pass);
	boolean CheckPh(String ph);
	boolean isValidUser(String phn,String pass);
	boolean isValidPhnTo(String phn);
	int isUpdateOne(String phn,int restFund);
	int isUpdateTwo(String phn,int restFund);
	void HistoryOfDiposite(String phn,String mny,String restMny);
	void HistoryOfWithdraw(String phn,String mny,String restMny);
	void HistoryOfTransfer(String phn1,String phn2,String mny,String restMny);
	void HistoryOfTransferTo(String phn1,String phn2,String mny,String restMny);
	
	
	
}

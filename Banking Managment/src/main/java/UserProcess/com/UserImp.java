package UserProcess.com;

import java.sql.*;


import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

import DBcon.connect.DBECONN;
import java.lang.*;
import java.math.BigDecimal;

import com.resister.bank.*;

public class UserImp implements UserValid {
	
	private static final String url = "jdbc:mysql://localhost:3306/dbs";
	private static final String user = "root";
	private static final String pass1 = "lulu@2004";
	private DBECONN c = new DBECONN();
	private getMoney g = new getMoney();
	private getterSetter gt = new getterSetter();
	private getSet gs = new getSet();
	
        public boolean addUser(String name,String phn,String pass)
        {
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		Connection con = DriverManager.getConnection(url,user,pass1);
        		
        		String qry = "INSERT INTO bank_user (username,phone_no,balance,password,CreateAccountTime) VALUES (?,?,?,?,NOW())";
        		PreparedStatement pt = con.prepareStatement(qry);
        		pt.setString(1, name);
        		pt.setString(2, phn);
        		pt.setInt(3, 0);
        		pt.setString(4, pass);
        		int i = pt.executeUpdate();
        		System.out.println("Connected");
        		if(i > 0)
        		{
        			return true;
        		}
        		else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return false;
			}
        }
        
     public  boolean CheckPh(String ph)
        {
        	try {
        		Connection con = c.getCon();
        		String qry = "select phone_no from bank_user";
        		PreparedStatement pt = con.prepareStatement(qry);
        		ResultSet rs = pt.executeQuery();
        		System.out.println("Connection is going on");
        		boolean c = false;
        		while(rs.next())
        		{
        			String chPh = rs.getString("phone_no");
        			if(chPh.equals(ph))
        			{
        				System.out.println("phone number has been checked");
        				c = true;
        			}
        		}
        		
        		return c;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
        }
     
  public  boolean isValidPhnTo(String phn)
     {
    	 try {
			Connection con = c.getCon();
			String sql = "select * from bank_user where phone_no = ?";
			boolean c = false;
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, phn);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
				c = true;
			}
			
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
     }
     public boolean isValidUser(String phn,String pass)
     {
    	 try {
    		 
			Connection con = c.getCon();
			String sql = "select * from  bank_user where phone_no = ? and password = ? ";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, phn);
			pt.setString(2, pass);
			boolean c = false;
			ResultSet rs = pt.executeQuery();
			
			while(rs.next())
			{
				c=true;
			}
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
     }
     
     public int isUpdateOne(String phn,int restFund)
     {
    	 try {
			Connection con = c.getCon();
			String sql = "update bank_user set balance = ? where phone_no = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, restFund);
			pt.setString(2, phn);
		    int c = pt.executeUpdate();
		    return c;
		} catch (SQLException e) {
		       e.printStackTrace();
		       return -1;
		}
     }
     
     public int isUpdateTwo(String phn,int restFund)
     {
    	 try {
			Connection con = c.getCon();
			String sql = "update bank_user set balance = ? where phone_no = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, restFund);
			pt.setString(2, phn);
		    int c = pt.executeUpdate();
		    return c;
		} catch (SQLException e) {
		       e.printStackTrace();
		       return -1;
		}
     }
     
     public void HistoryOfDiposite(String phn,String mny,String resMny)
     {
    	 String name = g.getName(phn);
    	 char[] arr = {'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
         char[] num = {'1','2','3','4','5','6','7','8','9','0'};

         String str = "DAN";
         String Tid = str+arr[(int)Math.round(Math.random()*23)]+arr[(int)Math.round(Math.random()*23)]+num[(int)Math.round(Math.random()*9)]+num[(int)Math.round(Math.random()*9)]+num[(int)Math.round(Math.random()*9)];
    	 try {
    		 Connection con = c.getCon();
    		 String qry = "insert into transcations(T_id,username,phone_no,trans_fund,remaining_fund,Date_time) values(?,?,?,?,?,NOW())";
    		 PreparedStatement pt = con.prepareStatement(qry);
    		 pt.setString(1, Tid);
    		 pt.setString(2, name);
    		 pt.setString(3,phn);
    		 pt.setString(4, "+"+mny);
    		 pt.setString(5, resMny);
    		 pt.executeUpdate();
    		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
     
     public void HistoryOfWithdraw(String phn,String mny,String resMny)
     {
    	 char[] arr = {'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
         char[] num = {'1','2','3','4','5','6','7','8','9','0'};

         String str = "DAN";
         String Tid = str+arr[(int)Math.round(Math.random()*23)]+arr[(int)Math.round(Math.random()*23)]+num[(int)Math.round(Math.random()*9)]+num[(int)Math.round(Math.random()*9)]+num[(int)Math.round(Math.random()*9)];

    	 String name = g.getName(phn);
    	 try {
    		 Connection con = c.getCon();
    		 String qry = "insert into transcations(T_id,username,phone_no,trans_fund,remaining_fund,Date_time) values(?,?,?,?,?,NOW())";
    		 PreparedStatement pt = con.prepareStatement(qry);
    		 pt.setString(1, Tid);
    		 pt.setString(2, name);
    		 pt.setString(3, phn);
    		 pt.setString(4, "-"+mny);
    		 pt.setString(5, resMny);
    		 pt.executeUpdate();
    		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
     public void HistoryOfTransfer(String phn1,String phn2,String mny,String restMny)
     {
    	 String name = g.getName(phn1);
    	 char[] arr = {'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
         char[] num = {'1','2','3','4','5','6','7','8','9','0'};

         String str = "DAN";
         String Tid = str+arr[(int)Math.round(Math.random()*23)]+arr[(int)Math.round(Math.random()*23)]+num[(int)Math.round(Math.random()*9)]+num[(int)Math.round(Math.random()*9)]+num[(int)Math.round(Math.random()*9)];
    	 try {
    		 Connection con = c.getCon();
    		 String qry = "insert into transcations(T_id,username,phone_no,phone_no_to,trans_fund,remaining_fund,Date_time) values(?,?,?,?,?,?,NOW())";
    		 PreparedStatement pt = con.prepareStatement(qry);
    		 pt.setString(1, Tid);
    		 pt.setString(2, name);
    		 pt.setString(3, phn1);
    		 pt.setString(4, phn2);
    		 pt.setString(5, "-"+mny);
    		 pt.setString(6, restMny);
    		 pt.executeUpdate();
    		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
     public void HistoryOfTransferTo(String phn1,String phn2,String mny,String restMny)
     {
    	 String name = g.getName(phn2);
    	 try {
    		 Connection con = c.getCon();
    		 String qry = "insert into transcations(T_id,username,phone_no,phone_no_to,trans_fund,remaining_fund,Date_time) values(?,?,?,?,?,?,NOW())";
    		 PreparedStatement pt = con.prepareStatement(qry);
    		 pt.setString(1, name);
    		 pt.setString(2, phn1);
    		 pt.setString(3, phn2);
    		 pt.setString(4, "+"+mny);
    		 pt.setString(5, restMny);
    		 pt.executeUpdate();
    		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
     
     
}

package UserProcess.com;
import java.sql.*;


import DBcon.connect.*;
import jakarta.servlet.jsp.tagext.TryCatchFinally;
public class getMoney {
	String name;
	String phn1;
	String phn2;
	String pass;
    private  DBECONN c = new DBECONN();
    
    int fund;
    
    public int money(String phn)
    {
    	try {
			Connection con = c.getCon();
			String qry = "select balance from bank_user where phone_no = ? ";
			PreparedStatement pt = con.prepareStatement(qry);
			pt.setString(1, phn);
			ResultSet rs =pt.executeQuery();
			while(rs.next())
			{
				fund = rs.getInt("balance");
			}
			return fund;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
    }
    
    
    
    public String getName(String phn)
    {
    	try {
    		String name = "";
			Connection con = c.getCon();
			String qry = "select username from bank_user where phone_no = ?";
			PreparedStatement pt = con.prepareStatement(qry);
			pt.setString(1, phn);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
				name = rs.getString("username");
			}
			return name;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
    }
    
    
    
}

package DBcon.connect;
import java.sql.*;
public class DBECONN {

	private static final String url = "jdbc:mysql://localhost:3306/dbs";
	private static final String user = "root";
	private static final String pass = "lulu@2004";
	
	static 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		     e.printStackTrace();
		}
	}
	public  Connection getCon() throws SQLException
	{
		System.out.println("Connection ho raha he:)");
		return DriverManager.getConnection(url,user,pass);
	}
	
}

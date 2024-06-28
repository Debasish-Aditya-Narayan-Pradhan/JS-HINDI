package com.resister.bank;

import jakarta.servlet.ServletException;
import UserProcess.com.*;
import DBcon.connect.DBECONN;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class authentication
 */
public class authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DBECONN c = new DBECONN();
	private  getterSetter gt = new getterSetter();
	private getSet gs = new getSet();
	private getMoney m = new getMoney();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phn = request.getParameter("phn");
		String pass = request.getParameter("pass");
		
		gs.setPhn(phn);
		gs.setPass(pass);
		
		
		
		try {
			Connection con = c.getCon();
			String qry = "select * from bank_user where phone_no = ? and password = ?";
			PreparedStatement pt = con.prepareStatement(qry);
			pt.setString(1, phn);
			pt.setString(2, pass);
			
			System.out.println("Phne: "+gs.getPhn());
			
			ResultSet rs = pt.executeQuery();
			boolean ch = false;
			while(rs.next())
			{
				ch = true;
			}
			
			if(ch == true)
			{
				response.sendRedirect("BankProcess.jsp?name="+m.getName(phn));
			
			}
			else {
				response.sendRedirect("loginUser.jsp?user=1");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.resister.bank;

import jakarta.servlet.ServletException;
import UserProcess.com.*;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import DBcon.connect.DBECONN;

/**
 * Servlet implementation class balanceUser
 */
public class balanceUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DBECONN c = new DBECONN();

	private  getSet gt = new getSet();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public balanceUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phn = request.getParameter("phn");
		String pass = request.getParameter("pass");
		int fund = -1;
		
		try {
			Connection  con = c.getCon();
			String sql = "select balance from bank_user where phone_no = ? and password = ?";
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1,phn);
			pt.setString(2,pass);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
				fund = rs.getInt("balance"); 
			}
			
			System.out.println("Ph in bal: "+gt.getPhn());
			
			if(fund > -1)
			{
				response.sendRedirect("UserBalance.jsp?fund="+fund);
			}
			else {
				response.sendRedirect("balance.jsp?fund=err");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

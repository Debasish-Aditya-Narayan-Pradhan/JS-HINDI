package com.resister.bank;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBcon.connect.DBECONN;

/**
 * Servlet implementation class historySvlt
 */
public class historySvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DBECONN c = new DBECONN();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public historySvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phn = request.getParameter("phn");
		String pass = request.getParameter("pass");
		
		
		
		
		try {
			Connection con = c.getCon();
			String qry = "select * from bank_user where phone_no = ? and password = ?";
			PreparedStatement pt = con.prepareStatement(qry);
			pt.setString(1, phn);
			pt.setString(2, pass);
		
			
			ResultSet rs = pt.executeQuery();
			boolean ch = false;
			while(rs.next())
			{
				ch = true;
			}
			
			if(ch == true)
			{
				response.sendRedirect("History.jsp?phn="+phn);
			
			}
			else {
				response.sendRedirect("HistoryChecker.jsp?user=1");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

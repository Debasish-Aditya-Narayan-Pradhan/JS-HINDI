package com.resister.bank;

import jakarta.servlet.ServletException;
import UserProcess.com.UserImp;
import UserProcess.com.UserValid;
import UserProcess.com.getMoney;
import DBcon.connect.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class withdrawMoney
 */
public class withdrawMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private getMoney g = new getMoney();
    private DBECONN d = new DBECONN();
    private UserValid u = new UserImp();
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public withdrawMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phn = request.getParameter("phn");
		String mny = request.getParameter("mny");
		String pass = request.getParameter("pass");
		
		
		Integer i = Integer.parseInt(mny);
		int User_ph = g.money(phn);
		
		int remain_bal = User_ph - i;
		String restFund = ""+remain_bal;
		if(i > User_ph)
		{
			response.sendRedirect("withdraw.jsp?fund=no");
		}
		else {
			
		
		try {
			Connection con = d.getCon();
			String qry = "update bank_user set balance = ? where phone_no = ? and password = ?";
			PreparedStatement pt = con.prepareStatement(qry);
			pt.setInt(1, remain_bal);
			pt.setString(2, phn);
			pt.setString(3, pass);
			int x = pt.executeUpdate();
			System.out.println("Updated ");
			if(x > 0)
			{
				u.HistoryOfWithdraw(phn, mny,restFund);
				response.sendRedirect("withdraw.jsp?fund=yes");
			}
			else {
				response.sendRedirect("withdraw.jsp?fund=1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	}

}

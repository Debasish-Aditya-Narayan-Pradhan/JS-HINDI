package com.resister.bank;

import jakarta.servlet.ServletException;
import java.sql.*;

import UserProcess.com.UserImp;
import UserProcess.com.UserValid;
import UserProcess.com.getMoney;
import UserProcess.com.getterSetter;
import DBcon.connect.DBECONN;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class depositeMoney
 */
public class depositeMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBECONN c = new DBECONN();
    private getMoney g = new getMoney();
    private getSet gt = new getSet();
    private UserValid u = new UserImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public depositeMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phn = request.getParameter("phn");
		String moy = request.getParameter("mny");
		String pass = request.getParameter("pass");
		
		Integer m = Integer.parseInt(moy);
		int fund = g.money(phn);
		int total = m+fund;
		String restMoney = ""+total;
		System.out.println(gt.getPhn());
		try {
			Connection con = c.getCon();
			
			String qry = "update bank_user set balance = ? where phone_no = ? and password = ?";
			PreparedStatement pt = con.prepareStatement(qry);
			pt.setInt(1, total);
			pt.setString(2, phn);
			pt.setString(3, pass);
			int i =pt.executeUpdate();
			if(i > 0)
			{
				
				u.HistoryOfDiposite(phn, moy,restMoney);
				response.sendRedirect("deposite.jsp?transfer=success");
			}
			else {
				response.sendRedirect("deposite.jsp?transfer=err");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

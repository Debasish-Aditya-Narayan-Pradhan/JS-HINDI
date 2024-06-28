package com.resister.bank;

import jakarta.servlet.ServletException;
import DBcon.connect.*;
import UserProcess.com.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NewTransfer
 */
public class NewTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBECONN c = new DBECONN();
	private getMoney g = new getMoney();
	private UserValid u = new UserImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String phn = request.getParameter("phn");
			String toPhn = request.getParameter("to");
			String mny = request.getParameter("mny");
			Integer fund = Integer.parseInt(mny);
			String pass = request.getParameter("pass");
			
			int p1 = g.money(phn);
			int p2 = g.money(toPhn);
			
			if(fund > p1)
			{
				response.sendRedirect("transfer.jsp?err=no");
			}
			
			else {
				if( u.isValidUser(phn, pass) && u.isValidPhnTo(toPhn) )
				{
					int totalOfp1 = p1 - fund;
					int totalOfp2 = fund + p2;
					
					
					int c1 = u.isUpdateOne(phn, totalOfp1);
					int c2 = u.isUpdateTwo(toPhn, totalOfp2);
					
					
					String tp = ""+totalOfp1;
					String tp1 = ""+totalOfp2;
					if(c1 > 0 && c2 > 0)
					{
						u.HistoryOfTransfer(phn, toPhn, mny, tp);
						u.HistoryOfTransferTo(phn, toPhn, mny,tp1 );
						response.sendRedirect("transfer.jsp?err=yes");
					}
					else {
						response.sendRedirect("transfer.jsp?err=1");
					}
				}
				else {
					response.sendRedirect("transfer.jsp?err=0");
				}
			}
	}

}

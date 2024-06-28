package com.resister.bank;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import UserProcess.com.UserImp;

/**
 * Servlet implementation class ResisterUser
 */
public class ResisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserImp u = new UserImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String phn = request.getParameter("phone");
		String pass = request.getParameter("pass");
		if(u.CheckPh(phn))
		{
			response.sendRedirect("loginBank.jsp?valid=err");
		}
		else {
			if(u.addUser(name, phn, pass))
			{
				response.sendRedirect("loginBank.jsp?valid=success");
			}
			else {
				response.sendRedirect("loginBank.jsp?valid=1");
			}
			
		}
	}

}

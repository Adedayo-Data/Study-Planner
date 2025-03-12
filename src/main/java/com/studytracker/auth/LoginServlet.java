package com.studytracker.auth;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studytracker.utils.UserDAOImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(UserDAOImpl.authUser(username, password)) {
			try {
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				res.sendRedirect("Dashboard.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				res.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

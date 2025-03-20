package com.studytracker.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studytracker.models.User;
import com.studytracker.utils.UserDAOImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// create object of UserDAOImpl
		UserDAOImpl dao = new UserDAOImpl();
		User user = new User(username, password);
		
		if(dao.addUser(user)) {
			// create session for the user
			HttpSession session = req.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("username", user.getUsername());
			res.sendRedirect("Dashboard.jsp");
		}
		else {
			PrintWriter out = res.getWriter();
			out.println("An error occured!");
					
		}
		
		
		
		
	}
	
	

}

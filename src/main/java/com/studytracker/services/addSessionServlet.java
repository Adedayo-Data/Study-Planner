package com.studytracker.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studytracker.models.StudySessionData;
import com.studytracker.utils.StudySessionDAOImpl;

/**
 * Servlet implementation class addSessionServlet
 */
@WebServlet("/addsession")
public class addSessionServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String subject = req.getParameter("subject");
		String topic = req.getParameter("topic");
		String wishTimeStr = req.getParameter("wishTime");
		String dateStr = req.getParameter("date");
		
		LocalTime wishTime = LocalTime.parse(wishTimeStr);
		LocalDate date = LocalDate.parse(dateStr);
		
		// get hold of the session
		HttpSession session = req.getSession();
		
		// get the userId from the session
		int userId = (int) session.getAttribute("userId");
		
		// pass data to DB
		// StudySessionDAOImpl instance
		StudySessionDAOImpl sessionImpl = new StudySessionDAOImpl();
		
		// StudySessionData Instance
		StudySessionData sessionData = new StudySessionData(userId, subject, topic, wishTime, date);
		
		// pass to the database
		boolean status = sessionImpl.addStudySession(sessionData);
		
		if(status) {
			res.sendRedirect("dashboard.jsp?msg=SessionAdded");
		}else {
			res.sendRedirect("dashboard.jsp?msp=Error");
		}
		
	}
}

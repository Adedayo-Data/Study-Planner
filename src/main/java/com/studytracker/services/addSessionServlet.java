package com.studytracker.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studytracker.constant.Status;
import com.studytracker.models.StudySessionData;
import com.studytracker.utils.StudySessionDAOImpl;

/**
 * Servlet implementation class addSessionServlet
 */
@WebServlet("/createSession")
public class addSessionServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String subject = req.getParameter("subject");
		String topic = req.getParameter("topic");
		String wishTimeStr = req.getParameter("wishTime");

		
		LocalTime wishTime = LocalTime.parse(wishTimeStr);
//		LocalDate date = LocalDate.parse(dateStr);
		
		// get hold of the session
		HttpSession session = req.getSession();
		
		// get the userId from the session
		int userId = (int) session.getAttribute("userId");
		
		// pass data to DB
		// StudySessionDAOImpl instance
		StudySessionDAOImpl sessionImpl = new StudySessionDAOImpl();
		
		// StudySessionData Instance
		Status statusEnum = Status.NOT_STARTED;
		String statusStr = statusEnum.name();
		StudySessionData sessionData = new StudySessionData(userId, subject, topic, wishTime, statusStr);
		
		// pass to the database
		boolean status = sessionImpl.addStudySession(sessionData);
		
//		REQUIRES UPDATE*
//
		if(status) {
			res.sendRedirect("Dashboard.jsp");
		}else {
			res.sendRedirect("Dashboard.jsp?msg=Error");
		}
//		
	}
}

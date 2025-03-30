package com.studytracker.services;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studytracker.models.StudySessionData;
import com.studytracker.utils.StudySessionDAOImpl;
import com.studytracker.constant.Status;

@WebServlet("/startSession")
public class startSessionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		String subject = req.getParameter("subject");
		String topic = req.getParameter("topic");
		String wishTimeStr = req.getParameter("wishTime");
		
		LocalTime wishTime = LocalTime.parse(wishTimeStr);
		
		// get hold of the session details
		HttpSession session = req.getSession();
		
		int userId = (int) session.getAttribute("userId");
		
		// create object of the DAO class
		StudySessionDAOImpl sessionDao = new StudySessionDAOImpl();
		
		// create object of the data holder class
		Status statusEnum = Status.NOT_STARTED;
		String statusStr = statusEnum.name();
		StudySessionData sessionData = new StudySessionData(userId, subject, topic, wishTime, statusStr);
		
		// pass the data to DAO
		boolean status = sessionDao.startStudySession(sessionData);
		
		if(status) {
			res.sendRedirect("Timer.jsp");
		}else {
			res.sendRedirect("Timer.jsp?msg=Error");
		}
		
	}
}
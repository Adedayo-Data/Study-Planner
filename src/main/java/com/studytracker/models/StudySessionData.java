package com.studytracker.models;

import com.studytracker.constant.Status;

import java.time.LocalDate;
import java.time.LocalTime;


public class StudySessionData {
	
	private int sessionId;
	private int userId;
	private String subject;
	private String topic;
	private LocalTime wishTime;
	private LocalTime actualTime;
	private LocalDate date;
	private String status;
	
	// Constructor 1
	public StudySessionData(int userId, String subject, String topic, LocalTime wishTime, String status) {
		this.userId = userId;
		this.subject = subject;
		this.topic = topic;
		this.actualTime = LocalTime.of(0, 0);
		this.wishTime = wishTime;
		this.date = LocalDate.now();
		this.status = status;
	}
	
	// constructor 2
	public StudySessionData(int sessionId) {
		this.sessionId = sessionId;
	}// end constructor2
	
	public void setSessionId(int id) {
		this.sessionId = id;
	}
	
	public int getSessionId() {
		return sessionId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getSubject() {
		return subject;
	}
	public String getTopic() {
		return topic;
	}
	public LocalTime getActualTime() {
		return actualTime;
	}
	public LocalTime getWishTime() {
		return wishTime;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
}

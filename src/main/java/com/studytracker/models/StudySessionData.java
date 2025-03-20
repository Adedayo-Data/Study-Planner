package com.studytracker.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class StudySessionData {
	
	private int userId;
	private String subject;
	private String topic;
	private LocalTime wishTime;
	private LocalTime actualTime;
//	private LocalDate date;
	
	// Constructor 1
	public StudySessionData(int userId, String subject, String topic, LocalTime wishTime) {
		this.userId = userId;
		this.subject = subject;
		this.topic = topic;
		this.actualTime = LocalTime.of(0, 0);
		this.wishTime = wishTime;
//		this.date = date;
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
//	public LocalDate getDate() {
//		return date;
//	}
}

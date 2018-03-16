package com.demo.entity;

public class StudentScore {
	private String studentId;
	private String kanjiScore;
	private String goiScore;
	private String level;
	private String times;
	private String datepicker; 
	
	public String getGoiScore() {
		return goiScore;
	}
	public void setGoiScore(String goiScore) {
		this.goiScore = goiScore;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getDatepicker() {
		return datepicker;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getKanjiScore() {
		return kanjiScore;
	}
	public void setKanjiScore(String kanjiScore) {
		this.kanjiScore = kanjiScore;
	}
}

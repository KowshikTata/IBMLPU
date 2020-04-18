package com.example.model;

public class League {
	private String leagueId;
	private int year;
	private String season;
	private String title;
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLeagueId() {
		return leagueId;
	}
	public int getYear() {
		return year;
	}
	public String getSeason() {
		return season;
	}
	public String getTitle() {
		return title;
	}
	public League(String leagueId, int year, String season, String title) {
		super();
		this.leagueId = leagueId;
		this.year = year;
		this.season = season;
		this.title = title;
	}
	
	
	
	
	
	
}

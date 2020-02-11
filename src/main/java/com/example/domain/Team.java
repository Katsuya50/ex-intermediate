package com.example.domain;

import java.time.LocalDate;

public class Team {
	
	private Integer id;
	private String leagueName;
	private String teamName;
	private String headquarters;
	private LocalDate inaguration;
	private String history;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public LocalDate getInaguration() {
		return inaguration;
	}
	public void setInaguration(LocalDate inaguration) {
		this.inaguration = inaguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inaguration=" + inaguration + ", history=" + history + "]";
	}

}

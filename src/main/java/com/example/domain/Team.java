package com.example.domain;

/**
 * 野球チームのドメイン.
 * 
 * @author katsuya.fujishima
 *
 */
public class Team {
	
	/** 野球チームのid */
	private Integer id;
	/** 野球チームのリーグ名 */
	private String leagueName;
	/** 野球チームのチーム名 */
	private String teamName;
	/** 野球チームの本拠地 */
	private String headquarters;
	/** 野球チームの発足年月日 */
	private String inauguration;
	/** 野球チームの歴史 */
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
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
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
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}

}

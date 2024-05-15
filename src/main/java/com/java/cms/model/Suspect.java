package com.java.cms.model;

import java.sql.Date;

public class Suspect {

	private int suspectID;
    private int crimeID;
    private String name;
    private String description;
    private String criminalHistory;
    private Date dateofbirth;
    
	public int getSuspectID() {
		return suspectID;
	}
	public void setSuspectID(int suspectID) {
		this.suspectID = suspectID;
	}
	public int getCrimeID() {
		return crimeID;
	}
	public void setCrimeID(int crimeID) {
		this.crimeID = crimeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCriminalHistory() {
		return criminalHistory;
	}
	public void setCriminalHistory(String criminalHistory) {
		this.criminalHistory = criminalHistory;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public Suspect() {
		
	}
	
	public Suspect(int suspectID, int crimeID, String name, String description, String criminalHistory, Date dateofbirth) {
		this.suspectID = suspectID;
		this.crimeID = crimeID;
		this.name = name;
		this.description = description;
		this.criminalHistory = criminalHistory;
		this.dateofbirth = dateofbirth;
	}
	
	@Override
	public String toString() {
		return "Suspect [suspectID=" + suspectID + ", crimeID=" + crimeID + ", name=" + name + ", description="
				+ description + ", criminalHistory=" + criminalHistory + ", dateofbirth=" + dateofbirth + "]";
	}
	
    
	
	
    
}

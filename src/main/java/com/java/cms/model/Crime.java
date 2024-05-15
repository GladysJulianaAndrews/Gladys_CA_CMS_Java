package com.java.cms.model;

import java.sql.Date;

public class Crime {

	private int crimeid;
	private String incidenttype;
	private Date incidentdate;
	private String location;
	private String description;
	private String status;
	
	public int getCrimeid() {
		return crimeid;
	}
	public void setCrimeid(int crimeid) {
		this.crimeid = crimeid;
	}
	public String getIncidenttype() {
		return incidenttype;
	}
	public void setIncidenttype(String incidenttype) {
		this.incidenttype = incidenttype;
	}
	public Date getIncidentdate() {
		return incidentdate;
	}
	public void setIncidentdate(Date incidentdate) {
		this.incidentdate = incidentdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Crime() {
		
		
	}
	public Crime(int crimeid, String incidenttype, Date incidentdate, String location, String description,
			String status) {
		this.crimeid = crimeid;
		this.incidenttype = incidenttype;
		this.incidentdate = incidentdate;
		this.location = location;
		this.description = description;
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Crime [crimeid=" + crimeid + ", incidenttype=" + incidenttype + ", incidentdate=" + incidentdate
				+ ", location=" + location + ", description=" + description + ", status=" + status + "]";
	}
	
	
	
}

package com.java.cms.model;

import java.sql.Date;

public class Victim {
 
	private int victimid;
    private int crimeid;
    private String name;
    private String contactinfo;
    private String injuries;
    private Date dateofbirth;
    
	public int getVictimid() {
		return victimid;
	}
	public void setVictimid(int victimid) {
		this.victimid = victimid;
	}
	public int getCrimeid() {
		return crimeid;
	}
	public void setCrimeid(int crimeid) {
		this.crimeid = crimeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactinfo() {
		return contactinfo;
	}
	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}
	public String getInjuries() {
		return injuries;
	}
	public void setInjuries(String injuries) {
		this.injuries = injuries;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public Victim() {
		
	}
	
	public Victim(int victimid, int crimeid, String name, String contactinfo, String injuries, Date dateofbirth) {
		this.victimid = victimid;
		this.crimeid = crimeid;
		this.name = name;
		this.contactinfo = contactinfo;
		this.injuries = injuries;
		this.dateofbirth = dateofbirth; 
	}
	
	@Override
	public String toString() {
		return "Victim [victimid=" + victimid + ", crimeid=" + crimeid + ", name=" + name + ", contactinfo="
				+ contactinfo + ", injuries=" + injuries + ", dateofbirth=" + dateofbirth + "]";
	}
    
}
package com.java.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.model.Crime;
import com.java.cms.util.DBConnUtil;
import com.java.cms.util.DBPropertyUtil;


public class CrimeDaoImpl implements CrimeDao {
	
      Connection connection; 
      PreparedStatement pst;



  	@Override
  	public List<Crime> showCrimes() throws ClassNotFoundException, SQLException {
  	    String connStr = DBPropertyUtil.connectionString("db");
  	    connection = DBConnUtil.getConnection(connStr);
  	    String cmd = "select * from Crime";
  	    pst = connection.prepareStatement(cmd);
  	    ResultSet rs = pst.executeQuery();
  	    List<Crime> crimeList = new ArrayList<>();
  	    while (rs.next()) {
  	        Crime crime = new Crime();
  	        crime.setCrimeid(rs.getInt("crimeid"));
  	        crime.setIncidenttype(rs.getString("incidenttype"));
  	        crime.setIncidentdate(rs.getDate("incidentdate"));
  	        crime.setLocation(rs.getString("location"));
  	        crime.setDescription(rs.getString("description"));
  	        crime.setStatus(rs.getString("status"));
  	        crimeList.add(crime);
  	    }
  	    return crimeList;
  	}
	

	@Override
	public Crime searchByCrimeId(int crimeid) throws ClassNotFoundException, SQLException {
	    String connStr = DBPropertyUtil.connectionString("db");
	    connection = DBConnUtil.getConnection(connStr);
	    String cmd = "select * from Crime where crimeid=?";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, crimeid);
	    ResultSet rs = pst.executeQuery();
	    Crime crime = null;
	    if (rs.next()) {
	        crime = new Crime();
	        crime.setCrimeid(rs.getInt("crimeid"));
	        crime.setIncidenttype(rs.getString("incidenttype"));
	        crime.setIncidentdate(rs.getDate("incidentdate"));
	        crime.setLocation(rs.getString("location"));
	        crime.setDescription(rs.getString("description"));
	        crime.setStatus(rs.getString("status"));
	    }
	    return crime;
	}

	@Override
	public List<Crime> searchByIncidentType(String incidenttype) throws ClassNotFoundException, SQLException {
	    String connStr = DBPropertyUtil.connectionString("db");
	    connection = DBConnUtil.getConnection(connStr);
	    String cmd = "select * from crime where incidenttype=?";
	    pst = connection.prepareStatement(cmd);
	    pst.setString(1, incidenttype);
	    ResultSet rs = pst.executeQuery();
	    List<Crime> crimeList = new ArrayList<>();
	    while (rs.next()) {
	        Crime crime = new Crime();
	        crime.setCrimeid(rs.getInt("crimeid"));
	        crime.setIncidenttype(rs.getString("incidenttype"));
	        crime.setIncidentdate(rs.getDate("incidentdate"));
	        crime.setLocation(rs.getString("location"));
	        crime.setDescription(rs.getString("description"));
	        crime.setStatus(rs.getString("status"));
	        crimeList.add(crime);
	    }
	    return crimeList;
	}

	@Override
	public List<Crime> searchByIncidentDate(Date incidentdate) throws ClassNotFoundException, SQLException {
	    String connStr = DBPropertyUtil.connectionString("db");
	    connection = DBConnUtil.getConnection(connStr);
	    String cmd = "select * from Crime where incidentdate=?";
	    pst = connection.prepareStatement(cmd);
	    pst.setDate(1, incidentdate);
	    ResultSet rs = pst.executeQuery();
	    List<Crime> crimeList = new ArrayList<>();
	    while (rs.next()) {
	        Crime crime = new Crime();
	        crime.setCrimeid(rs.getInt("crimeid"));
	        crime.setIncidenttype(rs.getString("incidenttype"));
	        crime.setIncidentdate(rs.getDate("incidentdate"));
	        crime.setLocation(rs.getString("location"));
	        crime.setDescription(rs.getString("description"));
	        crime.setStatus(rs.getString("status"));
	        crimeList.add(crime);
	    }
	    return crimeList;
	}

	@Override
	public List<Crime> showAllOpenIncidents() throws ClassNotFoundException, SQLException {
	    String connStr = DBPropertyUtil.connectionString("db");
	    connection = DBConnUtil.getConnection(connStr);
	    String cmd = "select * from Crime where status='open'";
	    pst = connection.prepareStatement(cmd);
	    ResultSet rs = pst.executeQuery();
	    List<Crime> crimeList = new ArrayList<>();
	    while (rs.next()) {
	        Crime crime = new Crime();
	        crime.setCrimeid(rs.getInt("crimeid"));
	        crime.setIncidenttype(rs.getString("incidenttype"));
	        crime.setIncidentdate(rs.getDate("incidentdate"));
	        crime.setLocation(rs.getString("location"));
	        crime.setDescription(rs.getString("description"));
	        crime.setStatus(rs.getString("status"));
	        crimeList.add(crime);
	    }
	    return crimeList;
	}

	@Override
	public boolean addCrime(Crime crime) throws ClassNotFoundException, SQLException {
	    String connStr = DBPropertyUtil.connectionString("db");
	    connection = DBConnUtil.getConnection(connStr);
	    String cmd = "insert into Crime (crimeid, incidenttype, incidentdate, location, description, status) values (?, ?, ?, ?, ?, ?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, crime.getCrimeid());
	    pst.setString(2, crime.getIncidenttype());
	    pst.setDate(3, crime.getIncidentdate());
	    pst.setString(4, crime.getLocation());
	    pst.setString(5, crime.getDescription());
	    pst.setString(6, crime.getStatus());
	    int rowsAffected = pst.executeUpdate();
	    return rowsAffected > 0;
	}

}
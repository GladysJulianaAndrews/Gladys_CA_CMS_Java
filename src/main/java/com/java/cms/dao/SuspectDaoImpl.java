package com.java.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.model.Suspect;
import com.java.cms.util.DBConnUtil;
import com.java.cms.util.DBPropertyUtil;

public class SuspectDaoImpl implements SuspectDao {
    Connection connection;
    PreparedStatement pst;

    @Override
    public boolean addSuspect(Suspect suspect) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "insert into Suspect (suspectid, crimeid, name, description, criminalhistory, dateofbirth) values (?, ?, ?, ?, ?, ?)";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, suspect.getSuspectID());
        pst.setInt(2, suspect.getCrimeID());
        pst.setString(3, suspect.getName());
        pst.setString(4, suspect.getDescription());
        pst.setString(5, suspect.getCriminalHistory());
        pst.setDate(6, suspect.getDateofbirth());
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public List<Suspect> showSuspectByCrimeId(int crimeId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "select * from Suspect where crimeid=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, crimeId);
        ResultSet rs = pst.executeQuery();
        List<Suspect> suspectList = new ArrayList<>();
        while (rs.next()) {
            Suspect suspect = new Suspect();
            suspect.setSuspectID(rs.getInt("suspectid"));
            suspect.setCrimeID(rs.getInt("crimeid"));
            suspect.setName(rs.getString("name"));
            suspect.setDescription(rs.getString("description"));
            suspect.setCriminalHistory(rs.getString("criminalhistory"));
            suspect.setDateofbirth(rs.getDate("dateofbirth"));
            suspectList.add(suspect);
        }
        return suspectList;
    }

    @Override
    public Suspect showSuspectBySuspectId(int suspectId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "select * from Suspect where suspectid=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, suspectId);
        ResultSet rs = pst.executeQuery();
        Suspect suspect = null;
        if (rs.next()) {
            suspect = new Suspect();
            suspect.setSuspectID(rs.getInt("suspectid"));
            suspect.setCrimeID(rs.getInt("crimeid"));
            suspect.setName(rs.getString("name"));
            suspect.setDescription(rs.getString("description"));
            suspect.setCriminalHistory(rs.getString("criminalhistory"));
            suspect.setDateofbirth(rs.getDate("dateofbirth"));
        }
        return suspect;
    }
}

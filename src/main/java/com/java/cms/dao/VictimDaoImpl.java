package com.java.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.model.Victim;
import com.java.cms.util.DBConnUtil;
import com.java.cms.util.DBPropertyUtil;

public class VictimDaoImpl implements VictimDao {
    Connection connection;
    PreparedStatement pst;

    @Override
    public List<Victim> showAllVictimByCrimeId(int crimeId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "select * from Victim where crimeid=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, crimeId);
        ResultSet rs = pst.executeQuery();
        List<Victim> victimList = new ArrayList<>();
        while (rs.next()) {
            Victim victim = new Victim();
            victim.setVictimid(rs.getInt("victimid"));
            victim.setCrimeid(rs.getInt("crimeid"));
            victim.setName(rs.getString("name"));
            victim.setContactinfo(rs.getString("contactinfo"));
            victim.setInjuries(rs.getString("injuries"));
            victim.setDateofbirth(rs.getDate("dateofbirth"));
            victimList.add(victim);
        }
        return victimList;
    }

    @Override
    public Victim showByVictimId(int victimId) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "select * from Victim where victimid=?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, victimId);
        ResultSet rs = pst.executeQuery();
        Victim victim = null;
        if (rs.next()) {
            victim = new Victim();
            victim.setVictimid(rs.getInt("victimid"));
            victim.setCrimeid(rs.getInt("crimeid"));
            victim.setName(rs.getString("name"));
            victim.setContactinfo(rs.getString("contactinfo"));
            victim.setInjuries(rs.getString("injuries"));
            victim.setDateofbirth(rs.getDate("dateofbirth"));
        }
        return victim;
    }

    @Override
    public boolean addVictim(Victim victim) throws ClassNotFoundException, SQLException {
        String connStr = DBPropertyUtil.connectionString("db");
        connection = DBConnUtil.getConnection(connStr);
        String cmd = "insert into Victim (victimid, crimeid, name, contactinfo, injuries, dateofbirth) values (?, ?, ?, ?, ?, ?)";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, victim.getVictimid());
        pst.setInt(2, victim.getCrimeid());
        pst.setString(3, victim.getName());
        pst.setString(4, victim.getContactinfo());
        pst.setString(5, victim.getInjuries());
        pst.setDate(6, victim.getDateofbirth());
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }
}

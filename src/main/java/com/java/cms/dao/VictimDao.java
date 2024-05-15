package com.java.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.cms.model.Victim;

public interface VictimDao {
    List<Victim> showAllVictimByCrimeId(int crimeId) throws ClassNotFoundException, SQLException;
    Victim showByVictimId(int victimId) throws ClassNotFoundException, SQLException;
    boolean addVictim(Victim victim) throws ClassNotFoundException, SQLException;
}

package com.java.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.cms.model.Suspect;

public interface SuspectDao {
    boolean addSuspect(Suspect suspect) throws ClassNotFoundException, SQLException;
    List<Suspect> showSuspectByCrimeId(int crimeId) throws ClassNotFoundException, SQLException;
    Suspect showSuspectBySuspectId(int suspectId) throws ClassNotFoundException, SQLException;
}

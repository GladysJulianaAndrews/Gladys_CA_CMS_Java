package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class ShowCrimeMain {

    public static void main(String[] args) {
        CrimeDao dao = new CrimeDaoImpl();
        try {
            List<Crime> crimeList = dao.showCrimes();
            for (Crime crime : crimeList) {
                System.out.println(crime);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

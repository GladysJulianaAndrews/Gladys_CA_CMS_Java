package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class SearchByIncidentTypeMain {

    public static void main(String[] args) {
        CrimeDao dao = new CrimeDaoImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter incident type: ");
        String incidentType = scanner.nextLine();

        try {
            List<Crime> crimeList = dao.searchByIncidentType(incidentType);
            if (!crimeList.isEmpty()) {
                System.out.println("Crimes with incident type '" + incidentType + "':");
                for (Crime crime : crimeList) {
                    System.out.println(crime);
                }
            } else {
                System.out.println("No crimes found with incident type '" + incidentType + "'.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

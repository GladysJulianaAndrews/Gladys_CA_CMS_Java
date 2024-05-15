package com.java.cms.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class SearchByIncidentDateMain {

    public static void main(String[] args) {
        CrimeDao dao = new CrimeDaoImpl();
        Scanner scanner = new Scanner(System.in);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.print("Enter incident date (yyyy-MM-dd): ");
        String inputDateStr = scanner.nextLine();
        
        try {
            Date incidentDate = new Date(dateFormat.parse(inputDateStr).getTime());
            List<Crime> crimeList = dao.searchByIncidentDate(incidentDate);
            if (!crimeList.isEmpty()) {
                System.out.println("Crimes on " + inputDateStr + ":");
                for (Crime crime : crimeList) {
                    System.out.println(crime);
                }
            } else {
                System.out.println("No crimes found on " + inputDateStr + ".");
            }
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
        } 
    }
}

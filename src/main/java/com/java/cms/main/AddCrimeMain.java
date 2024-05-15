package com.java.cms.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class AddCrimeMain {

    public static void main(String[] args) {
        CrimeDao dao = new CrimeDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            Crime newCrime = new Crime();
            
            System.out.print("Enter crime ID: ");
            newCrime.setCrimeid(scanner.nextInt());
            scanner.nextLine(); 
            
            System.out.print("Enter incident type: ");
            newCrime.setIncidenttype(scanner.nextLine());
            
            System.out.print("Enter incident date (yyyy-MM-dd): ");
            String incidentDateStr = scanner.nextLine();
            newCrime.setIncidentdate(Date.valueOf(incidentDateStr));
            
            System.out.print("Enter location: ");
            newCrime.setLocation(scanner.nextLine());
            
            System.out.print("Enter description: ");
            newCrime.setDescription(scanner.nextLine());
            
            System.out.print("Enter status: ");
            newCrime.setStatus(scanner.nextLine());

            boolean crimeAdded = dao.addCrime(newCrime);
            if (crimeAdded) {
                System.out.println("New crime added successfully.");
            } else {
                System.out.println("Failed to add new crime.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}

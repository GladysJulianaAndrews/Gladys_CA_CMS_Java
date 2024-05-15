package com.java.cms.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.SuspectDao;
import com.java.cms.dao.SuspectDaoImpl;
import com.java.cms.model.Suspect;

public class AddSuspectMain {
    public static void main(String[] args) {
        SuspectDao dao = new SuspectDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter suspect ID: ");
            int suspectId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter crime ID: ");
            int crimeId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            System.out.print("Enter criminal history: ");
            String criminalHistory = scanner.nextLine();
            System.out.print("Enter date of birth (yyyy-MM-dd): ");
            String dobString = scanner.nextLine();
            Date dateofbirth = Date.valueOf(dobString);
            
            Suspect suspect = new Suspect(suspectId, crimeId, name, description, criminalHistory, dateofbirth);
            boolean isAdded = dao.addSuspect(suspect);
            if (isAdded) {
                System.out.println("Suspect added successfully.");
            } else {
                System.out.println("Failed to add suspect.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}

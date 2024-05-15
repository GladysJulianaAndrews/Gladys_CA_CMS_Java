package com.java.cms.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.VictimDao;
import com.java.cms.dao.VictimDaoImpl;
import com.java.cms.model.Victim;

public class AddVictimMain {
    public static void main(String[] args) {
        VictimDao dao = new VictimDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter victim ID: ");
            int victimId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter crime ID: ");
            int crimeId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter contact info: ");
            String contactInfo = scanner.nextLine();
            System.out.print("Enter injuries: ");
            String injuries = scanner.nextLine();
            System.out.print("Enter date of birth (yyyy-MM-dd): ");
            String dobString = scanner.nextLine();
            Date dateofbirth = Date.valueOf(dobString);

            Victim victim = new Victim(victimId, crimeId, name, contactInfo, injuries, dateofbirth);
            boolean isAdded = dao.addVictim(victim);
            if (isAdded) {
                System.out.println("Victim added successfully.");
            } else {
                System.out.println("Failed to add victim.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

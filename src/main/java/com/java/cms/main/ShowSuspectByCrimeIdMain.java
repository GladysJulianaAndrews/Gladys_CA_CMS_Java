package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.SuspectDao;
import com.java.cms.dao.SuspectDaoImpl;
import com.java.cms.model.Suspect;

public class ShowSuspectByCrimeIdMain {
    public static void main(String[] args) {
        SuspectDao dao = new SuspectDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter crime ID: ");
            int crimeId = scanner.nextInt();
            List<Suspect> suspects = dao.showSuspectByCrimeId(crimeId);
            for (Suspect suspect : suspects) {
                System.out.println(suspect);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}

package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class SearchByCrimeIdMain {

    public static void main(String[] args) {
        CrimeDao dao = new CrimeDaoImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter crime ID: ");
        int crimeId = scanner.nextInt();

        try {
            Crime crime = dao.searchByCrimeId(crimeId);
            if (crime != null) {
                System.out.println("Crime found: " + crime);
            } else {
                System.out.println("Crime with ID " + crimeId + " not found.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}


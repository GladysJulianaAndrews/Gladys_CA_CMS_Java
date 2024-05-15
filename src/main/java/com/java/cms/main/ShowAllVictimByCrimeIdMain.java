package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.VictimDao;
import com.java.cms.dao.VictimDaoImpl;
import com.java.cms.model.Victim;

public class ShowAllVictimByCrimeIdMain {
    public static void main(String[] args) {
        VictimDao dao = new VictimDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter crime ID: ");
            int crimeId = scanner.nextInt();
            List<Victim> victims = dao.showAllVictimByCrimeId(crimeId);
            for (Victim victim : victims) {
                System.out.println(victim);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}

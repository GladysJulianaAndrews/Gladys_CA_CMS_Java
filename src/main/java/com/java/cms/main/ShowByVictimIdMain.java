package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.VictimDao;
import com.java.cms.dao.VictimDaoImpl;
import com.java.cms.model.Victim;

public class ShowByVictimIdMain {
    public static void main(String[] args) {
        VictimDao dao = new VictimDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter victim ID: ");
            int victimId = scanner.nextInt();
            Victim victim = dao.showByVictimId(victimId);
            System.out.println(victim);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }
}

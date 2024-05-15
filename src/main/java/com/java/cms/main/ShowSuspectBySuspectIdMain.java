package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.SuspectDao;
import com.java.cms.dao.SuspectDaoImpl;
import com.java.cms.model.Suspect;

public class ShowSuspectBySuspectIdMain {
    public static void main(String[] args) {
        SuspectDao dao = new SuspectDaoImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter suspect ID: ");
            int suspectId = scanner.nextInt();
            Suspect suspect = dao.showSuspectBySuspectId(suspectId);
            System.out.println(suspect);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

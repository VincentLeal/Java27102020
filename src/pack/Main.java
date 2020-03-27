package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DAOAcces daoAcces = new DAOAcces("Test", "root", "rootroot");
        daoAcces.Lister();
        daoAcces.Add(10, "Kojak", "Lind", "Dalbayob", "Pidaraz", 23);
        System.out.println("Added");
        daoAcces.Lister();
        daoAcces.Delete(10);
        System.out.println("Deleted");

        for (Acces acces: daoAcces.listAccess()
             ) {
            System.out.println(acces.toString());
        }

        Acces a = new Acces(10, "Kojak", "Lind", "Dalbayob", "Pidaraz", 23);
        daoAcces.addDao(a);

        for (Acces ac: daoAcces.listAccess()
        ) {
            System.out.println(ac.toString());
        }

        daoAcces.deleteDao(a);
        for (Acces ac: daoAcces.listAccess()
        ) {
            System.out.println(ac.toString());
        }


    }
}
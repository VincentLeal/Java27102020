package pack;

import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void main(String[] args){
        try {
            System.out.println("Begin Update");
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "Test";
            String login = "root";
            String motdepasse = "rootroot";
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);




            Scanner sc = new Scanner(System.in);


            System.out.println("Entrer l'id de la personne à modifier : ");
            String id = sc.nextLine();
            System.out.println("Quel statut lui affecter : ");
            String status = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement("UPDATE Acces SET statut = ? WHERE id = ?");

            ps.setString(1, status);
            ps.setString(2, id);

            ps.execute();

            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("LAAAAAA");
            System.err.println(e.getMessage());
        }
    }
}

package pack;


import javafx.util.Pair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args){
        try {
            System.out.println("Begin Insert");
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "Test";
            String login = "root";
            String motdepasse = "rootroot";
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);

            Statement stAddUser = conn.createStatement();


            stAddUser.executeUpdate("insert into Acces values ( 6, 'Vincent', 'MadaFukaz', 'azerty', 'Dieu', 24 )");

            System.out.println("Normalement c'est insert");
// . . .
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

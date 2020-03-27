package pack;

import java.sql.*;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args){
        try {
            System.out.println("Begin Delete");
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "Test";
            String login = "root";
            String motdepasse = "rootroot";
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);


            Scanner sc = new Scanner(System.in);

            System.out.println("Entrer l'id de l'utilisateur à supprimer : ");

            String str = sc.nextLine();

            String query = "DELETE from Acces WHERE id = " + str;

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.execute();



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

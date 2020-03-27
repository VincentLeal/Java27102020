package pack;

import java.sql.*;

public class Select {
    public static void main(String[] args){
        try {
            System.out.println("Begin Select");
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "Test";
            String login = "root";
            String motdepasse = "rootroot";
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);



            Statement stUsers = conn.createStatement();

            ResultSet rsUsers = stUsers.executeQuery("select * from Acces");
            while(rsUsers.next()) {
                System.out.print("Id[" + rsUsers.getInt(1) + "]"
                        + rsUsers.getString(2)
                        + "[" + rsUsers.getString("statut") + "] "
                        + rsUsers.getInt("age") +"\n"); }
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

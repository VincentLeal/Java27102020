package pack;

import java.sql.*;
import java.util.ArrayList;

public class DAOAcces {
    /*String dbName;
    String login;
    String mdp;
    String url;*/
    private String strClassName = "com.mysql.jdbc.Driver";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public DAOAcces(String dbName, String login, String mdp){
        try{
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            Class.forName(strClassName);
            connection = DriverManager.getConnection(strUrl, login, mdp);
        }catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("LAAAAAA");
            System.err.println(e.getMessage());
        }
    }

    public void Delete(int id){
        try{
            String query = "DELETE from Acces WHERE id = ?";
            createPreparedStatement(query);
            this.preparedStatement.setInt(1,id);
            this.preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void Add(int id, String prenom, String login, String pwd, String statut, int age){
        try {
            createPreparedStatement("insert into Acces (id, prenom, login, password, statut, age)"
                    +" values ( ?, ?, ?, ?, ?, ?)");
            this.preparedStatement.setInt(1,id);
            this.preparedStatement.setString(2, prenom);
            this.preparedStatement.setString(3, login);
            this.preparedStatement.setString(4, pwd);
            this.preparedStatement.setString(5, statut);
            this.preparedStatement.setInt(6, age);
            this.preparedStatement.execute();
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    private void createStatement(){
        try {
            statement = connection.createStatement();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private void createPreparedStatement(String query){
        try {
            preparedStatement = connection.prepareStatement(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void Lister(){
        try{
            String query = "Select * From Acces";
            createStatement();
            ResultSet rsUsers = this.statement.executeQuery(query);
            while(rsUsers.next()) {
                System.out.print("Id[" + rsUsers.getInt(1) + "]"
                        + rsUsers.getString(2)
                        + "[" + rsUsers.getString("statut") + "] "
                        + rsUsers.getInt("age") +"\n"); }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Acces> listAccess(){
        String query = "Select * From Acces";
        createStatement();
        ArrayList<Acces> usersList = new ArrayList<>();
        try(ResultSet resUsers = this.statement.executeQuery(query)){
            while(resUsers.next()){
                Acces user = new Acces(
                        resUsers.getInt(1), resUsers.getString(2),
                        resUsers.getString("login"), resUsers.getString("password"),
                        resUsers.getString("statut"), resUsers.getInt("age")
                );
                usersList.add(user);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    public void addDao(Acces a){
        try {
            createPreparedStatement("insert into Acces (id, prenom, login, password, statut, age)"
                    +" values ( ?, ?, ?, ?, ?, ?)");
            this.preparedStatement.setInt(1,a.getId());
            this.preparedStatement.setString(2, a.getName());
            this.preparedStatement.setString(3, a.getLogin());
            this.preparedStatement.setString(4, a.getPassword());
            this.preparedStatement.setString(5, a.getStatus());
            this.preparedStatement.setInt(6, a.getAge());
            this.preparedStatement.execute();
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
    public void deleteDao(Acces a){
        try{
            String query = "DELETE from Acces WHERE id = ?";
            createPreparedStatement(query);
            this.preparedStatement.setInt(1,a.getId());
            this.preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}

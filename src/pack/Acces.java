package pack;
import java.sql.*;

public class Acces {
    private int id;
    private String name;
    private String login;
    private String password;
    private String status;
    private int age;
    public Acces(int id, String name, String login, String password, String status, int age) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.status = status;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLogin() {
        return login;
    }
    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Acces{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", age=" + age +
                '}';
    }
}
package Classes;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String name;
    private char gender;
    private String contactNo;
    private static int nextID = 1000;

    public User() {
    }

    public User(String username, String password, String name, char gender, String contactNo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.contactNo = contactNo;
        this.id = nextID++;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        User.nextID = nextID;
    }
    
    @Override
    public String toString() {
        return String.format("%-4d %-10s %-20s %-6s %-12s", id,username,name,gender,contactNo);
    }
}
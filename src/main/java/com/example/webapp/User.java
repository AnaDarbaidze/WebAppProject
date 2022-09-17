package com.example.webapp;
public class User {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String profession;
    private String password;
    private String email;

    public User(int id, String username, String firstname, String lastname, String profession, String password, String email) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.password = password;
        this.email = email;
    }

    public User(String username, String firstname, String lastname, String profession, String password, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getProfession() {
        return profession;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



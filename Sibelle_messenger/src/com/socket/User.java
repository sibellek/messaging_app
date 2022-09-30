package com.socket;


import java.time.LocalDate;
import java.util.Date;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sibelle Khayrallah
 */
public class User {
    private int id;
    private String firstname ;
    private String lastname ;
    private String username ;
    private String password ;
    private String gender;
    private String profilepic;

    public User(int id, String firstname, String lastname, String username, String password, String gender, String profilepic) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.profilepic = profilepic;
    }

    public User() {
    
    }

    User(String uname, String pic) {
        this.username=uname;
        this.profilepic=pic;
    }

   

  

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }
    
    public boolean equals(User user){
        return this.id==user.id;
    }
}

package com.CS157AProject.CourseBrief.model;

//import org.apache.tools.ant.types.resources.comparators.Date;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "userID", nullable = false)
    private String userID;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "DOB", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob; 
    
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
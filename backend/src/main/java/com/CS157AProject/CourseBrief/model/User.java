package com.CS157AProject.CourseBrief.model;

//import org.apache.tools.ant.types.resources.comparators.Date;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @Column(name = "userID", nullable = false)
    private String userID;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    /* @Column(name = "DOB", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;  */
    
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    } */

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
}
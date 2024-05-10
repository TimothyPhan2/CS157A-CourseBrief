package com.CS157AProject.CourseBrief.model;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "userID", nullable = false, unique = true)
    private String userID;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    /* @Column(name = "DOB", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;  */
    
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username" ,nullable = false, unique = true)
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
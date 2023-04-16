/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Student {
    public String stID;
    public String fName = null;
    public String lName = null;
    public boolean gender = true;
    public Date bDate = null;
    public String email = null;
    public String phone = null;

    public Student(String stID) {
        this.stID = stID;
    }
    
    public Student(String stID, String fName, String lName, boolean gender, Date bDate, String email, String phone) {
        this.stID = stID;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDate = bDate;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return stID + ", " + fName + " " + lName + ", " +
                (gender == true? "male, ": "female, ") + bDate +
                ", " + email + ", " + phone;
    }

    @Override
    public boolean equals(Object obj) {
        return stID.equals(((Student) obj).stID);
    }
    
    
    
}

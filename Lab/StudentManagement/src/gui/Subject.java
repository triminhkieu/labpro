/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Admin
 */
public class Subject {
    public String subID;
    public String subName;
    public int credit;

    public Subject() {
        this.subID = "";
        this.subName = "";
        this.credit = 0;
    }

    public Subject(String subID, String subName, int credit) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
    }

    public Subject(String subID) {
        this.subID = subID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit > 0) {
            this.credit = credit;
        }
    }
    
    @Override
    public String toString() {
        return "ID: " + subID + ", Name: " + subName + ", Credit: " + credit;
    }

    @Override
    public boolean equals(Object obj) {
        return subID.equals(((Subject) obj).subID);
    }
    
    
    
    
    
}

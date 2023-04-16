/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import myUtil.Inputter;

/**
 *
 * @author Admin
 */
public class Doctor {
    String doctorID;
    String doctorName;
    Boolean sex;
    String address;
    String deptID;
    Date createDate;
    Date lastUpdateDate;

    // constructor with 7 fiels
    public Doctor(String doctorID, String doctorName, Boolean sex, String address, String deptID, Date createDate, Date lastUpdateDate) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.deptID = deptID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    // constructor without lastUpdateDate field
    public Doctor(String doctorID, String doctorName, Boolean sex, String address, String deptID, Date createDate) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.deptID = deptID;
        this.createDate = createDate;
    }

    // Getters and Setters
    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.doctorID, other.doctorID)) {
            return false;
        }
        if (!Objects.equals(this.doctorName, other.doctorName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.deptID, other.deptID)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        if (!Objects.equals(this.lastUpdateDate, other.lastUpdateDate)) {
            return false;
        }
        return false;
    }
    
    // Convert gender
    public String convertToString(boolean sex) {
        if (sex == true) {
            return "Male";
        } else {
            return "Female";
        }
    }
    
    @Override
    public String toString() {
        String createDate;
        String updateDate;
        if (this.createDate == null) {
            createDate = "null";

        } else {
            createDate = Inputter.strDMY(this.createDate);

        }
        if (this.lastUpdateDate == null) {
            updateDate = "null";
        } else {
            updateDate = Inputter.strDMY(this.lastUpdateDate);
        }
        return "[" + doctorID + ", " + doctorName + ", " + convertToString(sex) + ", " + address + ", " + deptID + ", " + createDate + ", " + updateDate + "]";
    }
        
    // display
    public void displayDoctor(){
        String createDate;
        String updateDate;
        if (this.createDate == null) {
            createDate = "null";

        } else {
            createDate = Inputter.strDMY(this.createDate);

        }
        if (this.lastUpdateDate == null) {
            updateDate = "null";
        } else {
            updateDate = Inputter.strDMY(this.lastUpdateDate);
        }

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("\n| %-10s | %-15s | %-7s | %-25s | %-13s | %-13s | %-13s |", doctorID, doctorName, convertToString(sex), address, deptID, createDate, updateDate);
    }
    
    
}

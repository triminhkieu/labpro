/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.Objects;
import myUtil.Inputter;

/**
 *
 * @author Admin
 */
public class Department {
    String deptID;
    String deptName;
    Date createDate;
    Date lastUpdateDate;
    
    // constructor with 4 fields
    public Department(String deptID, String deptName, Date createDate, Date lastUpdateDate) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    // constructor without lastUpdateDate field
    public Department(String deptID, String deptName, Date createDate) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.createDate = createDate;
    }

    //Setters and Getters
    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
        int hash = 7;
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.deptID, other.deptID)) {
            return false;
        }
        if (!Objects.equals(this.deptName, other.deptName)) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        return Objects.equals(this.lastUpdateDate, other.lastUpdateDate);
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
        return "["  + deptID + ", " + deptName + ", " + createDate + ", " + updateDate + "]";
    }
    
    // display
    public void displayDepartment() {
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
        System.out.printf("\n| %-13s | %-18s | %-13s | %-13s |", deptID, deptName, createDate, updateDate);
    }
}

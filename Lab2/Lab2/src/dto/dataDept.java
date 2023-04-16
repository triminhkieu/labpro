/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class dataDept {

    Department department;
    Doctor aDoctor;

    public dataDept(Department department, Doctor aDoctor) {
        this.department = department;
        this.aDoctor = aDoctor;
    }

    // Getters and Setters
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctor getaDoctor() {
        return aDoctor;
    }
        
    public void setaDoctor(Doctor aDoctor) {
        this.aDoctor = aDoctor;
    }

}

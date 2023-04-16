/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentList extends ArrayList<Student>{

    public StudentList() {
        super();
    }

    @Override
    public String toString() {
        String S = "";
        for (Student st : this) {
            S += st.toString() + "\n";
        }
        return S;
    }
    
}

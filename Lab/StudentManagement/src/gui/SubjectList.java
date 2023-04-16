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
public class SubjectList extends ArrayList<Subject>{

    public SubjectList() {
        super();
    }

    @Override
    public String toString() {
        String S = "";
        for (Subject sub : this) {
            S += sub.toString() + "\n";
        }
        return S;
    }
    
    
}

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
public class TranscriptList extends ArrayList<Transcript>{

    public TranscriptList() {
        super();
    }
    
    public boolean containSubject(String subID) {
        for (Transcript t : this) {
            if (t.sub.subID.equals(subID)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean containStudent (String stID) {
        for (Transcript t : this) {
            if (t.st.stID.equals(stID)) {
                return true;
            }
        }
        return false;
    }
    
}

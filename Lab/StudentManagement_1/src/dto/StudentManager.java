/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import gui.StudentList;
import gui.Subject;
import gui.SubjectList;
import gui.TranscriptList;
import tools.MyUtil;

/**
 *
 * @author Admin
 */
public class StudentManager {
    SubjectList subList;
    StudentList stList;
    TranscriptList trList;

    public StudentManager() {
        subList = new SubjectList();
        stList = new StudentList();
        trList = new TranscriptList();
    }
    
    public void addSubject() {
        String subID;
        int pos;
        do {            
            subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        String name = MyUtil.readNonBlankStr("Subject name").toUpperCase();
        int credit = MyUtil.readInt("Credit", 1, 10);
        Subject sb = new Subject(subID, name, credit);
        subList.add(sb);
        System.out.println("A subject was added.");
    }
    //
    public void updateSubject() {
        String subID;
        subID = MyUtil.readNonBlankStr("Subject ID");
        for (Subject subject : subList) {
            if (subject.getSubID().equals(subID)){
                String newName = MyUtil.readNonBlankStr("New name subject");
                subject.setSubName(newName);
                int newCredit = MyUtil.readInt("New credit", 1, 10);
                subject.setCredit(newCredit);
            }
        }
    }
    //
    public void deleteSubject() {
        String subID;
        subID = MyUtil.readNonBlankStr("Sub ID will be remove:");
        if (trList.containSubject(subID)) {
            System.out.println("Deployed. It can not be removed!");
        } else {
            for (Subject subject : subList) {
                if (subject.getSubID().equals(subID)) {
                    subList.remove(subject);
                }
            }
        }  
    }
    //
    public void addStudent() {
        
    }
    //
    public void updateStudent() {
        
    }
    //
    public void deleteStudent() {
        
    }
    //
    public void addGrade() {
        
    }
    //
    public void reportSubject() {
        
    }
    //
    public void reportStudent() {
        
    }
    
}

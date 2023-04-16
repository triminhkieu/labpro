/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.Student;
import gui.StudentList;
import gui.Subject;
import gui.SubjectList;
import gui.Transcript;
import gui.TranscriptList;
import java.util.Date;
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
    public void updateSubject() {
        String subID;
        subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
        for (Subject subject : subList) {
            if (subject.getSubID().equals(subID)){
                String newName = MyUtil.readNonBlankStr("New name subject").toUpperCase();
                subject.setSubName(newName);
                int newCredit = MyUtil.readInt("New credit", 1, 10);
                subject.setCredit(newCredit);
                System.out.println("A subject was updated!");
            } else {
                System.out.println("Subject does not exit!");
            }
        }
    }
    public void deleteSubject() {
        String subID;
        boolean flag = false;
        do {
            subID = MyUtil.readNonBlankStr("Sub ID will be remove").toUpperCase();
            if (trList.containSubject(subID)) {
                System.out.println("Deployed. It can not be removed!");
            } else {
                for (Subject subject : subList) {
                    if (subject.getSubID().equals(subID)) {
                        subList.remove(subject);
                        System.out.println("A subject was deleted!");
                        break;
                    } else {
                        System.out.println("Wrong ID Subject");
                        flag = true;
                    }

                }
            }
        } while (flag);
    }
    public void addStudent() {
        String id;
        int pos;
        do {            
            id = MyUtil.readNonBlankStr("Student ID").toUpperCase();
            pos = stList.indexOf(new Student(id));
            if (pos >= 0) {
                System.out.println("ID duplicated!");
            }
        } while (pos >= 0);
        String fname = MyUtil.readNonBlankStr("Student first name").toUpperCase();
        String lname = MyUtil.readNonBlankStr("Student last name").toUpperCase();
        Boolean bGender = MyUtil.readBool("Input gender");
        
        Date bDate = MyUtil.readDMY("Nhay Ngay/Thang/Nam");
        String email = MyUtil.readPattern("Student email", MyUtil.EMAIL);
        String phone = MyUtil.readPattern("Student Phone", MyUtil.PHONE_10to12);
        Student stu = new Student(id, fname, lname, bGender, bDate, email, phone);
        stList.add(stu);
        System.out.println("A student was added");
    }
    public void updateStudent() {
        String stID;
        boolean flag = false;
        int pos;
        do {
            stID = MyUtil.readNonBlankStr("ID of student to update").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Student does not exit");
                flag = true;
            } 
            else {
                stList.get(pos).fName = MyUtil.readNonBlankStr("New first name").toUpperCase();
                stList.get(pos).lName = MyUtil.readNonBlankStr("Input new last name").toUpperCase();
                Boolean bGender = MyUtil.readBool("Input gender");
                stList.get(pos).gender = bGender;
                stList.get(pos).bDate = MyUtil.readDMY("Nhay Ngay/Thang/Nam");
                stList.get(pos).email = MyUtil.readPattern("Student email", MyUtil.EMAIL);
                stList.get(pos).phone = MyUtil.readPattern("Student Phone", MyUtil.PHONE_10to12);
                System.out.println("A student was updated");
                flag = false;
            }
        } while (flag);
        for (Student stu : stList) {
            System.out.println(stu);
        }
    }
    public void deleteStudent() {
        String stID;
        boolean flag = false;
        int pos;
        do {
            stID = MyUtil.readNonBlankStr("ID of student to update:").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Student does not exit");
                flag = true;
            } 
            else {
                stList.remove(stList.get(pos));
                System.out.println("That student was deleted");
                flag = false;
            }
        } while (flag);
        
    }
    public void addGrade() {
        String stId;
        String subID;
        Student st = null;
        Subject sub = null;
        int pos;
        do {            
            stId = MyUtil.readNonBlankStr("Input ID student").toUpperCase();
            pos = stList.indexOf(new Student(stId));
            if (pos < 0 ) {
                System.out.println("Not found student");
            }
            else {
                st = stList.get(pos);
            }
        } while (pos < 0);
        do {            
            subID = MyUtil.readNonBlankStr("Input ID subject").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos < 0) {
                System.out.println("Not found subject");
            } 
            else {
                sub = subList.get(pos);
            }
        } while (pos < 0);
        pos = trList.indexOf(new Transcript(st, sub));
        double lab = MyUtil.readDouble("Input lab test points");
        double test = MyUtil.readDouble("Input progress test points");
        double ftest = MyUtil.readDouble("Input final test points");
        Transcript t = new Transcript(st, sub, lab, test, ftest);
        if (pos < 0) {
            trList.add(t);
        } else {
            
            trList.set(pos, t);
        }
                
    }
        
    public void reportSubject() {
        String subID;
        subID = MyUtil.readNonBlankStr("Input subject ID").toUpperCase();
        boolean check = trList.containSubject(subID);
        boolean boo = false;
        if (check == false) {
            System.out.println("Subject does not exit");
        } else {

            for (Transcript t : trList) {
                if (t.sub.subID.equals(subID)) {
                    System.out.println("Subject ID " + subID);
                    System.out.println("Subject name: " + t.sub.subName);
                    System.out.println("List of student sort by student Name: ");
                    System.out.println("|++Student ID ++|++Student name++|++Average mark++|++Status++|");
                    break;
                }
            }      
            for (Transcript t : trList) {
                if (t.sub.subID.equals(subID)) {
                    String con = "Pass";
                    if (t.average() < 5) {
                        con = "Not Pass";
                    }
                    String str = String.format("|   %s    |         %s %s        |     %2.1f     |    %s  |", t.st.stID, t.st.fName, t.st.lName, t.average(), con);
                    System.out.println(str);
                }
            }
        }
    }
    public void reportStudent() {
        String stID;
        stID = MyUtil.readNonBlankStr("Input student ID").toUpperCase();
        int a = 0;
        boolean check = trList.containStudent(stID);
        if (check == false) {
            System.out.println("Student does not exit");
        } else {
            for (Transcript t : trList) {
                if (t.st.stID.equals(stID)) {
                    System.out.println("Student ID " + stID);
                    System.out.println("Student name: " + t.st.lName + " " + t.st.fName);
                    System.out.println("|++No++|+++++++Subject name++++++++|++Average mark++|++Status++|");
                    System.out.println("List of subject sort by Subject Name: ");
                    break;
                }
            }   
            for (Transcript t : trList) {
                if (t.st.stID.equals(stID)) {
                    String con = "Pass";
                    if (t.average() < 5) {
                        con = "Not Pass";
                    }
                    String str = String.format("|  %d   |       %-13s       |      %2.1f      |    %s  |", ++a, t.sub.subName, t.average(), con);
                    System.out.println(str);
                }
            }
        }
    }
    
}

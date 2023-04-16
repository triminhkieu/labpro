/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import gui.StudentManager;
import java.util.Scanner;
import tools.MyUtil;

/**
 *
 * @author Admin
 */
public class GradeProgram {

    public static void main(String[] args) {
        //tao cac menu chinh
        Menu mainMnu = new Menu();
        mainMnu.add("Add new Student");
        mainMnu.add("Update Student");
        mainMnu.add("Add new Subject");
        mainMnu.add("Update Subject");
        mainMnu.add("Enter Grade");
        mainMnu.add("Student Grade Report");
        mainMnu.add("Subject Grade Report");
        //tao cac menu phu 1
        Menu stMnu = new Menu();
        stMnu.add("Update Student information");
        stMnu.add("Delete Student");
        stMnu.add("Back to menu");
        //tao cac menu phu 2
        Menu subMnu = new Menu();
        subMnu.add("Update Subject");
        subMnu.add("Delete Subject");
        subMnu.add("Back to menu");
        //tao student manager
        StudentManager mng = new StudentManager();
        //bien menu
        int choice1 = 0;
        int choice2 = 0;
        boolean flag = false;
        do {
            do {
                try {
                    choice1 = mainMnu.getChoice();
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Input error");
                    flag = true;
                }
            } while (flag);
            switch (choice1) {
                case 1://Add new student
                    do {
                        System.out.println("Add new student");
                        mng.addStudent();
                        do {
                            flag = MyUtil.readBool("Do you want to continous create new student: ");
                            if (flag) {
                                break;
                            }
                        } while (flag);
                    } while (flag);
                    break;
                case 2://Update student
                    System.out.println("Update student");
                    do {
                        do {
                            try {
                                choice2 = stMnu.getChoice();
                                flag = false;
                            } catch (Exception e) {
                                System.out.println("Input error");
                                flag = true;
                            }
                        } while(flag);
                        if (choice2 == 1) {
                            mng.updateStudent();
                        } 
                        else if (choice2 == 2) {
                            mng.deleteStudent();
                        }
                        else if (choice2 == 3) {
                            break;
                        }
                    } while (choice2 != 1 || choice2 != 2 || choice2 != 3);
                    break;
                case 3://add new subject 
                    do {
                        System.out.println("Add new subject");
                        mng.addSubject();
                        do {
                            flag = MyUtil.readBool("Do you want to continous create new subject: ");
                            if (flag) {
                                break;
                            }
                        } while (flag);
                    } while (flag);
                    break;
                case 4://Update subject information
                    System.out.println("Update subject information ");
                    do {
                        do {
                            try {
                                choice2 = subMnu.getChoice();
                                flag = false;
                            } catch (Exception e) {
                                System.out.println("Input error");
                                flag = true;
                            }
                        } while (flag);
                        if (choice2 == 1) {
                            mng.updateSubject();
                        } 
                        else if (choice2 == 2) {
                            mng.deleteSubject();
                        }
                        else if (choice2 == 3) {
                            break;
                        }
                    } while (choice2 != 1 || choice2 != 2 || choice2 != 3);
                    break;
                case 5://Enterting student's grade
                    do {
                        System.out.println("Enterting student's grade");
                        mng.addGrade();
                        do {
                            flag = MyUtil.readBool("Do you want to continous entering student's grade: ");
                            if (flag) {
                                break;
                            }
                        } while (flag);
                    } while (flag);
                    break;
                case 6: //Student Grade report
                    do {
                        System.out.println("Student Grade report");
                        mng.reportStudent();
                        do {
                            flag = MyUtil.readBool("Do you want to continous see student grade report: ");
                            if (flag) {
                                break;
                            }
                        } while (flag);
                    } while (flag);
                    break;
                case 7://Subject Grade report
                    do {
                        System.out.println("Subject Grade report");
                        mng.reportSubject();
                        do {
                            flag = MyUtil.readBool("Do you want to continous see student grade report: ");
                            if (flag) {
                                break;
                            }
                        } while (flag);
                    } while (flag);
                    break;
                default:
                    System.out.println("Bye!");
            }

        } while (choice1 > 0 && choice1 <= mainMnu.size());
    }

}

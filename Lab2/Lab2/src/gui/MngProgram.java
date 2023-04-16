/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.DeptList;
import dto.DoctorList;
import myUtil.Menu;

/**
 *
 * @author Admin
 */
public class MngProgram {
    public static void main(String[] args) {
        String Doc_DataFname = "doctors.dat";
        String Dept_DataFname = "departments.dat";
        
        String BackUp_Doc_DataFname = "backupDepartments.dat";
        String BackUp_Dept_DataFname = "backupDoctors.dat";
        
        DoctorList docList = new DoctorList();
        DeptList departmentList = new DeptList();
        
        HospitalMng manager = new HospitalMng(departmentList, docList);
        String[] options = {"Show all", "Add", "Update", "Delete", "Search", "Load data from file.", "Store data to file.", "Exist."};
        String[] addOptions = {"Add new doctor.", "Add new department." };
        String[] showOptions = {"Show doctor list.", "Show department list." };
        String[] upDateOptions = {"Update doctor.", "Update department." };
        String[] delOptions = {"Remove doctor.", "Remove department." };
        String[] searchOptions = {"Search doctor by name.", "Search department by ID." };
        String[] loadOptions = {"Load doctors data.", "Load department data." };
        String[] saveOptions = {"Save doctors data.", "Save department data." };
        int intChoice;
        do {
            System.out.println("\nMENU");
            intChoice = Menu.getChoice(options);
            
            switch (intChoice) {
                case 1: //Show all
                {
                    System.out.println("\nShow");
                    int getSubChoice = Menu.getChoice(showOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.printAllDoctorList();
                            break;
                        case 2:
                            manager.printAllDepartmentList();
                            break;
                    }
                    break;
                }
                case 2: //Add
                {
                    System.out.println("\nAdd");
                    int getSubChoice = Menu.getChoice(addOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.addNewDoctor();
                            break;
                        case 2:
                            manager.addNewDepartment();
                            break;
                    }
                    break;
                }
                case 3: //Update 
                {
                    System.out.println("\nUpdate");
                    int getSubChoice = Menu.getChoice(upDateOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.updateDoctor();
                            break;
                        case 2:
                            manager.updateDepartment();
                            break;
                    }
                    break;
                }
                case 4: //Remove
                {
                    System.out.println("\nRemove");
                    int getSubChoice = Menu.getChoice(delOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.removeDoctor();
                            break;
                        case 2:
                            manager.removeDepartment();
                            break;
                    }
                    break;
                }
                case 5: //Search
                {
                    System.out.println("\nSearch");
                    int getSubChoice = Menu.getChoice(searchOptions);
                    switch (getSubChoice) {
                        case 1:
                            manager.searchDoctorByName();
                            break;
                        case 2:
                            manager.searchDepartmentByID();
                            break;
                    }
                    break;
                }
                case 6: //Load
                {
                    System.out.println("\nLoad");
                    int getSubChoice = Menu.getChoice(loadOptions);
                    switch (getSubChoice) {
                        case 1:
                            try {
                                manager.loadFromFileDoc_Data(Doc_DataFname);
                            } catch(Exception e) {
                                System.out.println("File error!");
                            }
                            manager.printAllDoctorList();
                            break;
                        case 2:
                            try {
                                manager.loadFromFileDept_Data(Dept_DataFname);
                            } catch(Exception e) {
                                System.out.println("File error!");
                            }
                            manager.printAllDepartmentList();
                            break;
                    }
                    break;
                }
                case 7: //Store
                {
                    System.out.println("\nSave");
                    int getSubChoice = Menu.getChoice(saveOptions);
                    switch (getSubChoice) {
                        case 1:
                            try {
                                manager.SaveToDocFile(BackUp_Doc_DataFname);
                            } catch(Exception e) {
                                System.out.println("File error!");
                            }
                            break;
                        case 2:
                            try {
                                manager.SaveToDeptFile(BackUp_Dept_DataFname);
                            } catch(Exception e) {
                                System.out.println("File error");
                            }
                            break;
                    }
                    break;
                }
            }

        } while (intChoice > 0 && intChoice < 8);

    }
}

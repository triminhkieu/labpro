/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Department;
import dto.DeptList;
import dto.Doctor;
import dto.DoctorList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import myUtil.Inputter;
import static myUtil.Inputter.valid;

/**
 *
 * @author Admin
 */
public class HospitalMng {
    DeptList departmentList;
    DoctorList docList;
    
    private static Scanner sc = new Scanner(System.in);
    
   // constructor
    public HospitalMng(DeptList departmentList, DoctorList docList) {
        this.departmentList = departmentList;
        this.docList = docList;

    }
    
    // print list of doctors
    public void printAllDoctorList() {
        System.out.println();
        System.out.println("Doctor List: ");
        if (this.docList.isEmpty()) {
            System.out.println("Empty list!");

        } else {
            System.out.printf("\n| %-10s | %-15s | %-7s | %-25s | %-13s | %-13s | %-13s |", "Doctor ID", "Name", "Gender", "Address", "Department ID", "Create Date", "Update Date");
            for (String st : this.docList.keySet()) {
                String key = st;
                Doctor value = this.docList.get(key);
                value.displayDoctor();
            }
        }
    }

    // print list of departments
    public void printAllDepartmentList() {
        System.out.println();
        System.out.println("Department List: ");
        if (this.departmentList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.printf("\n| %-13s | %-18s | %-13s | %-13s |", "Department ID", "Name", "Create Date", "Update Date");
            for (String st : this.departmentList.keySet()) {
                String key = st;
                Department value = this.departmentList.get(key);
                value.displayDepartment();
            }
        }
    }

    // date
    public static long toDate(String ymd) {
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int y = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        if (!valid(y, m, d)) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m , d); 
        long t = cal.getTime().getTime();
        return t;

    }

    // new doctor
    private Doctor createDoctor(String line) {
        Doctor aDoc;
        boolean sex;
        long lastDateLong;
        long creDateLong;
        StringTokenizer stk = new StringTokenizer(line, "|");
        String doctorID = stk.nextToken().toUpperCase().trim();
        String doctorName = stk.nextToken().toUpperCase().trim();
        String gender = stk.nextToken().toUpperCase().trim();
        if (gender.startsWith("T")) {
            sex = true;
        } else {
            sex = false;
        }
        String address = stk.nextToken().toUpperCase().trim();
        String deptID = stk.nextToken().toUpperCase().trim();

        String creDateStr = stk.nextToken().trim();
        creDateLong = toDate(creDateStr);
        Date creDate = new Date(creDateLong);

        String lastDateStr = stk.nextToken().trim();
        lastDateLong = toDate(lastDateStr);
        Date upDate = new Date(lastDateLong);

        return aDoc = new Doctor(doctorID, doctorName, sex, address, deptID, creDate, upDate);
    }

    // load file doctor
    public void loadFromFileDoc_Data(String fName) throws Exception {
        FileReader fr = new FileReader(fName);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        while (((line = bf.readLine()) != null)) {
            Doctor doc = this.createDoctor(line);
            this.docList.put(doc.getDoctorID(), doc);
        }
        System.out.println("Completed");

        bf.close();
        fr.close();
    }

    // new department
    private Department createDepartment(String line) {
        Department aDept;
        long creDateLong;
        long lastDateLong;
        StringTokenizer stk = new StringTokenizer(line, "|");
        String deptID = stk.nextToken().toUpperCase().trim();
        String deptName = stk.nextToken().toUpperCase().trim();
        String creDateStr = stk.nextToken().trim();
        creDateLong = toDate(creDateStr);
        Date creDate = new Date(creDateLong);

        String lastDateStr = stk.nextToken().trim();
        lastDateLong = toDate(lastDateStr);
        Date upDate = new Date(lastDateLong);

        return aDept = new Department(deptID, deptName, creDate, upDate);
    }

    // load file department
    public void loadFromFileDept_Data(String fName) throws Exception {
        FileReader fr = new FileReader(fName);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        while (((line = bf.readLine()) != null)) {
            Department dept = this.createDepartment(line);
            this.departmentList.put(dept.getDeptID(), dept);
        }
        System.out.println("Completed");

        bf.close();
        fr.close();
    }

    // save file doctor
    public void SaveToDocFile(String fName) throws Exception {
        BufferedWriter bw = null;
        FileWriter fw = null;
        File file = new File(fName);
        
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        for (String key : this.docList.keySet()) {
            Doctor value = this.docList.get(key);
            String valueStr = value.toString();
            bw.write(valueStr);

            bw.newLine();
        }
        bw.close();
        fw.close();
        System.out.println("Done");
    }

    // save file department
    public void SaveToDeptFile(String fName) throws Exception {
        BufferedWriter bw = null;
        FileWriter fw = null;
        File file = new File(fName);
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        for (String key : this.departmentList.keySet()) {
            Department value = this.departmentList.get(key);
            String valueStr = value.toString();
            bw.write(valueStr);

            bw.newLine();
        }
        bw.close();
        fw.close();
        System.out.println("Done");
    }

    // same doctor
    public boolean isDocDupplicated(String id) {
        if (this.docList.containsKey(id)) {
            return true;
        }
        return false;
    }

    // same department
    public boolean isDepartmentDupplicated(String id) {

        if (this.departmentList.containsKey(id)) {
            return true;
        }
        return false;

    }

    // more doctor
    public void addNewDoctor() {
        String id;
        long t = -1;
        String deptID;
        boolean stop = true;
        do {
            id = Inputter.inputNonBlankStr("Input Doctor ID: ");
            id = id.toUpperCase();
            if (!this.isDocDupplicated(id)) {
                String doctorName = Inputter.inputNonBlankStr("Input Name's Doctor: ");
                boolean sex = DoctorList.checkGender("Enter Gender [Male: T/1 - Female: F/0]: ");
                String address = Inputter.inputNonBlankStr("Input address: ");

                deptID = Inputter.inputNonBlankStr("Input department ID: ");
                deptID = deptID.toUpperCase();
                if (!this.isDepartmentDupplicated(deptID)) {
                    System.out.println("Department Id must be existed!!!");
                    boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                    if (choice == false) {
                        return;
                    } else {
                        stop = false;
                    }
                } else {
                    Date creDate = new Date(System.currentTimeMillis());
                    Date upDate = new Date(System.currentTimeMillis());
                    Doctor o = new Doctor(id.toUpperCase(), doctorName.toUpperCase(), sex, address.toUpperCase(), deptID.toUpperCase(), creDate, upDate);
                    this.docList.put(id, o);
                    break;
                }

            } else {
                System.out.println("ID is dupplicated!!");
                String choice = Inputter.inputNonBlankStr("Do you want to continue?(Y/N)").toUpperCase();
                if (!choice.startsWith("T")) {
                    break;
                }
            }
        } while (!stop);

    }

    // more department
    public void addNewDepartment() {
        String deptID;
        String deptName = null;
        Date creDate;
        Date upDate;
        boolean ok = true;

        do {
            deptID = Inputter.inputNonBlankStr("Input department ID: ");
            if (!this.isDepartmentDupplicated(deptID)) {
                deptID = deptID.toUpperCase();
                break;
            } else {
                System.out.println("ID is dupplicated!!");
                boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                if (choice == false) {
                    return;
                }
            }
        } while (!ok);

        deptName = Inputter.inputNonBlankStr("Input department name: ");
        deptName = deptName.toUpperCase();
        creDate = new Date(System.currentTimeMillis());
        upDate = new Date(System.currentTimeMillis());
        Department o = new Department(deptID, deptName, creDate, upDate);
        this.departmentList.put(deptID, o);
    }

    // update doctor
    public void updateDoctor() {
        boolean stop = false;
        do {
            boolean sex;
            String id = Inputter.inputNonBlankStr("Input doctor ID to update: ");
            id = id.toUpperCase();
            if (this.docList.containsKey(id)) {
                System.out.println("Update doctor Name: ");
                String doctorName = sc.nextLine();
                if (!doctorName.isEmpty()) {
                    doctorName = doctorName.toUpperCase();
                    this.docList.get(id).setDoctorName(doctorName);
                }
                System.out.println("Update sex:T(male)/F(Female)");
                String gender = sc.nextLine();
                gender = gender.toUpperCase();
                if (!gender.isEmpty()) {
                    if (gender.startsWith("T")) {
                        sex = true;
                    } else {
                        if (gender.startsWith("F")) {
                            sex = false;
                        } else {
                            sex = true;
                        }
                    }
                    this.docList.get(id).setSex(sex);
                }
                System.out.println("Update address: ");
                String addrs = sc.nextLine();
                addrs = addrs.toUpperCase();
                if (!addrs.isEmpty()) {
                    this.docList.get(id).setAddress(addrs);
                }
                System.out.println("Update department ID:");
                String deptID = sc.nextLine();
                if (!deptID.isEmpty()) {
                    do {
                        if (!this.isDepartmentDupplicated(deptID)) {
                            System.out.println("Department Id must be existed!!!");
                            boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                            if (choice == false) {
                                return;
                            } else {
                                stop = false;
                            }
                        } else {
                            this.docList.get(id).setDeptID(deptID);
                            Date currentDate = new Date(System.currentTimeMillis());
                            this.docList.get(id).setLastUpdateDate(currentDate);
                            System.out.println("Updated!!");
                            System.out.println(this.departmentList.get(id));
                        }
                    } while (stop == false);

                } else {
                    Date currentDate = new Date(System.currentTimeMillis());
                    this.docList.get(id).setLastUpdateDate(currentDate);
                    break;
                }

            } else {
                System.out.println("Doctor does not exist!");
                boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                if (choice == false) {
                    return;
                }
            }
        } while (stop == false);
    }

    // update department
    public void updateDepartment() {
        boolean stop = false;
        do {
            String id = Inputter.inputNonBlankStr("Input department ID: ");
            id = id.toUpperCase();
            if (this.departmentList.containsKey(id)) {
                System.out.println("Update Department name: ");
                String deptName = sc.nextLine();
                deptName = deptName.toUpperCase();
                if (!deptName.isEmpty()) {
                    this.departmentList.get(id).setDeptName(deptName);
                }

                Date currentDate = new Date(System.currentTimeMillis());
                this.departmentList.get(id).setLastUpdateDate(currentDate);
                System.out.println("Updated!!");
                System.out.println(this.departmentList.get(id));
            } else {
                System.out.println("Department does not exist!");
                boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                if (choice == false) {
                    return;
                } else {
                    stop = false;
                }
            }
        } while (stop == false);

    }

    // remove doctor
    public void removeDoctor() {
        boolean stop = false;
        do {
            String id = Inputter.inputNonBlankStr("Input Doctor ID to detele.");
            id = id.toUpperCase();
            if (this.docList.containsKey(id)) {
                this.docList.remove(id);
                System.out.println("Removed.");
                break;
            } else {
                System.out.println("Doctor does not exist!");
                boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                if (choice == false) {
                    return;
                } else {
                    stop = false;
                }
            }

        } while (stop == false);
    }

    // remove department
    public void removeDepartment() {
        boolean stop = false;
        do {
            String id = Inputter.inputNonBlankStr("Input Department ID to detele.");
            id = id.toUpperCase();
            if (this.departmentList.containsKey(id)) {
                this.departmentList.remove(id);
                System.out.println("Removed.");
                break;
            } else {
                System.out.println("Department does not exist!");
                boolean choice = Inputter.inputBoolean("Do you want to continue?(Y/N)");
                if (choice == false) {
                    return;
                } else {
                    stop = false;
                }
            }

        } while (stop == false);
    }

    // search name for doctor
    public void searchDoctorByName() {
        String name = Inputter.inputNonBlankStr("Input name to search: ");
        boolean found = false;
        name = name.toUpperCase().trim();
        for (String st : this.docList.keySet()) {
            String key = st;
            if (this.docList.get(key).getDoctorName().equals(name)) {
                System.out.println(this.docList.get(key));
                found = true;
            }

        }
        if (found == false) {
            System.out.println("Doctor does not exist!");
        }
    }

    // search id for department
    public void searchDepartmentByID() {
        String id = Inputter.inputNonBlankStr("Input ID to search: ");
        boolean found = false;
        id = id.toUpperCase().trim();
        for (String st : this.departmentList.keySet()) {
            String key = st;
            if (this.departmentList.get(key).getDeptID().equals(id)) {
                System.out.println(this.departmentList.get(key));
                found = true;
            }

        }
        if (found == false) {
            System.out.println("Department does not exist!");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DoctorList extends HashMap<String, Doctor>{

    public DoctorList() {
        super();
    }
    
    // convert gender
    public static boolean checkGender(String msg) {
        String str;
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.print(msg);
            str = sc.nextLine();
            str = str.trim().toUpperCase();
            char c = str.charAt(0);
            try {

                if (null == str) {
                    throw new Exception();
                } else {
                    switch (c) {
                        case 'M':
                        case '1':
                        case 'T':
                            return true;
                        case '0':
                        case 'F':
                            return false;

                        default:
                            throw new Exception();
                    }

                }

            } catch (Exception e) {
                System.out.println("Error! Try again.");
                flag = true;
            }
        } while (flag);

        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MyUtil {
    public static final int DMY = 0;
    public static final int MDY = 1;
    public static final int YMD = 2;
    
    public static final String PHONE_10to12 = "[\\d]{10,12}";
    public static final String EMAIL = ".+@.+[.].+";
    
    static Scanner sc = new Scanner(System.in);
    
    public static int readInt(String message, int min, int max) {
        int t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {            
            System.out.println(message + ": ");
            t = Integer.parseInt(sc.nextLine());
        } while (!OK);
        return t;
    }
    
    public static int readInt(String message, int min) {
        return readInt(message, min, Integer.MAX_VALUE);
    }
    
    public static String readNonBlankStr(String message) {
        String S;
        boolean OK = true;
        do {            
            System.out.println(message + ": ");
            S = sc.nextLine().trim();
            if (S == null || S.isEmpty()) {
                OK = false;
            }
        } while (!OK);
        return S;
    }
    
    public static String readPattern(String message, String regex) {
        String S;
        boolean OK;
        do {            
            System.out.println(message + ": ");
            S = sc.nextLine().trim();
            OK = S.matches(regex);
            if (!OK) {
                System.out.println("Invalid input!");
            }
        } while (!OK);
        return S;
    }
    
    public static boolean readBool(String message) {
        System.out.println(message + "[T/F, Y/N, 1/0: ]");
        String S = sc.nextLine().trim().toUpperCase();
        char c = S.charAt(0);
        return (c == 'T' || c == 'Y' || c == '1');
    }
    
    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) {
            result = true;
        }
        return result;
    }
    
    public static boolean valid (int y, int m, int d) {
        if (y < 0 || m < 0 || m > 12 || d < 0 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        }
        else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            }
        }
        return d <= maxD;
    }
    
    public static Date toDate (int y, int m, int d) {
        if (!valid(y, m, d)) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m-1, d);
        return cal.getTime();
    }
    
    public static Date toDate(String dateStr, int dateFormat) {
        int yIndex, mIndex, dIndex;
        switch (dateFormat) {
            case YMD:
                yIndex = 0;
                mIndex = 1;
                dIndex = 2;
                break;
            case MDY:
                yIndex = 2;
                mIndex = 0;
                dIndex = 1;
                break;
            case DMY:
                yIndex = 2;
                mIndex = 1;
                dIndex = 0;
                break;
            default: return null;
        }
        String[] parts = dateStr.split("[/-]");
        if (parts.length != 3) {
            return null;
        }
        int y = Integer.parseInt(parts[yIndex]);
        int m = Integer.parseInt(parts[mIndex]);
        int d = Integer.parseInt(parts[dIndex]);
        return toDate(y, m, d);
    }
    public static Date readMDY(String message) {
        Date d;
        String S;
        do {            
            System.out.println(message + "[m/d/y]: ");
            S = sc.nextLine().trim();
            d = toDate(S, MDY);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    } 
    public static Date readDMY(String message) {
        Date d;
        String S;
        do {            
            System.out.println(message + "[d/m/y]: ");
            S = sc.nextLine().trim();
            d = toDate(S, DMY);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    }
    public static Date readYMD(String message) {
        Date d;
        String S;
        do {            
            System.out.println(message + "[y/m/d: ]");
            S = sc.nextLine().trim();
            d = toDate(S, YMD);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    }
    
    public static String strDMY(Date d) {
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + (c.get(Calendar.DATE) + 1) + '-' +
                c.get(Calendar.MONTH) + '-' + c.get(Calendar.YEAR);
    }
    
    public static String strMDY(Date d) {
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + (c.get(Calendar.MONTH) + 1) + '-' +
                c.get(Calendar.DATE) + '-' + c.get(Calendar.YEAR);
    }
    
    public static void main (String[] args) {
        int n = readInt("Nhap so int >= 10", 10);
        System.out.println(n);
        String phone = readPattern("Nhap phone", PHONE_10to12);
        System.out.println(phone);
        String mail = readPattern("Nhap email", EMAIL);
        System.out.println(mail);
        Date d = readDMY("Nhap ngay thang");
        System.out.println("DMY: " + strDMY(d));
        System.out.println("MDY: " + strMDY(d));
    }
}

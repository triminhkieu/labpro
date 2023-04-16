/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    
    // input boolean
    public static boolean inputBoolean(String msg){
        boolean ok = false;
        String data;
        do{
        System.out.println(msg);
            data = sc.nextLine();
            data = data.toUpperCase();
            if (data.equals("T") || data.equals("Y")){
                return true;
            } else {
                if (data.equals("F") || data.equals("N")){
                    return false;
                } else {
                    ok = false;
                    System.out.println("Invalid!");
                }
            }
        } while (!ok);
        return true;
    }
    
    
    // input interger from min to max
    public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int t = min; min = max; max = t;
        }
        int data;
        do{
            System.out.println(msg);
            data = sc.nextInt();
            if(data < min || data > max) {
                System.out.println("Invalid!! Input again.");
            }
        } while (data < min || data > max);
        return data;
    }
    
    // input double from min to max
    public static double inputDouble(String msg, double min, double max ) {
          if(min>max) {
            double t = min; min = max; max = t;
        }
        double data;
        do{
            System.out.println(msg);
            data = sc.nextDouble();
            if(data < min || data >max) {
                System.out.println("Invalid!! Input again.");
            }
        } while (data < min || data >max);
        return data;
    }
    
    // input positive interger
    public static int inputInt_Pos(String msg){
        int data;
        do{
            System.out.println(msg);
            data = Integer.parseInt(sc.nextLine());
            if (data < 0 ) System.out.println("Should be positive!");
        } while (data < 0);
        return data;
    }
    
    // input string
    public static String inputStr(String msg) {
        System.out.println(msg);
        String data = sc.nextLine().trim();
        return data;
    }
    
    // input string with no blank
    public static String inputNonBlankStr(String msg) {
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine();
            if(data.length() == 0 ) System.out.println("Should be no blank!");
        } while (data.length() == 0);
        return data;
    }
    

    // input string with pattern
    public static String inputPattern(String msg, String pattern) {
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
            
        } while (!data.matches(pattern));
        return data;
    }
    
    // is year leap
    public static boolean isLeap(int y) {
        boolean result = false;
        if((y%400==0) || ((y%4==0) && (y%100!=0))) return true;
        return false;  
    }
    
    // is real day, month, year
    public static boolean valid (int y, int m, int d) {
        if(y<0 || m<0 || m>12 || d<0 || d>31) return false;
        int maxD=31;
        if(m == 4 || m == 6 || m == 9 || m == 11);
        else if (m==2) {
            if (isLeap(y)) maxD = 29;
            else maxD = 28;
        }
        return d<=maxD;
    }
    
    // covert date
    public static long toDate(String ymd) {
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int y = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        if(!valid(y,m,d)) return -1;
        Calendar cal = Calendar.getInstance();
        cal.set(y, m, d); 
        long t = cal.getTime().getTime();
        return t;
        
    }
    
    // convert long become date
    public static Date returnDate(String ymd){
        long t = toDate(ymd);
        Date date = new Date(t);
        return date;
    }
    
    // Print date
    public static String strDMY (Date d) {
        String s = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return s + (c.get(Calendar.DATE)) + '-' + 
                c.get(Calendar.MONTH) + '-' + c.get(Calendar.YEAR);
    }
}

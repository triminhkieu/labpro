/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu<T> {
    
    Scanner sc = new Scanner(System.in);
    
    // choice
    
    public int getIntChoice(ArrayList list) {
        for (int i =0; i<list.size(); i++){
            System.out.println((i+1) + "-" +list.get(i));
        }
        System.out.println("************");
        System.out.println("Choose " + "1.." + list.size() + ":");
        return Integer.parseInt(sc.nextLine()); 
    }
    
    public T getObjectChoice(ArrayList<T> list) {
        int n = list.size();
        for (int i =0; i<n; i++){
            System.out.println((i+1) + "-" +list.get(i));
        }
        System.out.println("************");
        System.out.println("Choose "+ "-" + "1.." + list.size() + ":");
        int choiceNo = Integer.parseInt(sc.nextLine());
        return (choiceNo > 0 && choiceNo<=n)? list.get(choiceNo-1): null;
    }
    
    public static int getChoice(ArrayList options) {
        for (int i = 0; i <options.size();i++) {
            System.out.print((i+1)+ "-" + options.get(i));
        }
        System.out.print("\nEnter choice: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static int getChoice(Object[] options) {
        for (int i = 0; i<options.length; i++) {
            System.out.println((i+1) + ". "+options[i]);
        }
        System.out.print("\nEnter choice: ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}

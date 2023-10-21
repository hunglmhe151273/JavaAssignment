/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PCDELL
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);

    //input string
    public static String getString(String msg) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                break;
            }
            System.err.println("String is not empty");
        }
        return s;
    }

    //input choice
    public static int getInt(String msg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        while (true) {
            try {
                System.out.print(msg);
                int choice = Integer.parseInt(sc.nextLine());
                //check choice 1-4 return
                if (min <= choice && choice <= max) {
                    return choice;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Input is number in range: " + min + "->" + max);
            }

        }
    }
    //input choice

    public static double getDouble(String msg, double min, double max) {
        double temp;
        if (min > max) {
            temp = min;
            min = max;
            max = temp;
        }
        double d;
        while (true) {
            try {
                System.out.print(msg);
                d = Double.parseDouble(sc.nextLine());
                if (min <= d && d <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Double is number in range: " + min + "->" + max);
            }
        }
        return d;
    }

    //input name, assignnee, expert
    public static String getName(String msg) {
        String s;
        while (true) {
            s = getString(msg);
            if (checkName(s)) {
                break;
            }
            System.err.println("Invalid Name");
        }
        return s;
    }

    //valid name?
    public static boolean checkName(String name) {
        if (name.matches("^[a-zA-Z ]+$")) {
            return true;
        } else {
            return false;
        }
    }

    //get date
    public static String getDate() {
        //format date
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        Date inputDate;
        while (true) {
            try {
                System.out.print("Date: ");
                inputDate = df.parse(sc.nextLine().trim());//has date
                if(checkDate(inputDate,df))
                    return df.format(inputDate);
                System.out.println("Input date >= date now");
            } catch (ParseException ex) {
                System.err.println("Date to correct format(dd-MM-yyyy)");
            }
        }
    }

    public static boolean checkDate(Date inputDate,SimpleDateFormat df) {
        Date now = new Date();
        String strNow = df.format(now);
        try {
            now = df.parse(strNow);
            if (inputDate.before(now))
            return false;
        } catch (ParseException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static double getFrom(String msg, double min, double max){
        double d;
        while(true){
            d = getDouble(msg, min, max);
            if(d % 0.5 == 0){
                break;
            }
            System.err.println("From must be number % 0.5 == 0");
        }
        return d;
    }
    
    public static double getTo(String msg, double min, double max, double from){
        double d;
        while(true){
            d = getDouble(msg, min, max);
            if(d % 0.5 == 0 && d > from){
                break;
            }
            System.err.println("To must be double % 0.5 == 0 and To > From");
        }
        return d;
    }

}

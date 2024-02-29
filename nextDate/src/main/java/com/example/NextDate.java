package com.example;
import java.util.Scanner;
import java.time.Year;

public class NextDate {
    public static void main(String[] args) {

        int day;
        int month;
        int year;

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the corresponding day, month, and year for the corresponding date to print out the next date below: ");
        
        System.out.println("Please enter the day (01-31): ");
        day = input.nextInt();

        System.out.println("Please enter the month (01-12): ");
        month = input.nextInt();

        System.out.println("Please enter the year from 1812 to 2212: ");
        year = input.nextInt();

        System.out.println("The entered date in day, month, year format is: " +  day + "/" + month + "/" + year);
        
        System.out.println("The corresponding next date is: " + NextDate(day, month, year));
    }

    public static String NextDate(int day, int month, int year) {

        //Check if Date given is valid
        if (!validDate(day, month, year))
            return "Please enter a valid Date";

        //Checking for leap years and adjusting for it
        if (month == 2 && day == 29 && !Year.isLeap(year))
            return "Invalid Date Provided";
        else if (month == 2 && (day == 28 || day == 29)) {
            day = 1;
            month++;
        }
        
        //months with 30 days
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
            day = 1;
            month++;
        }

        //months with 31 days
        else if ((month == 12 || day == 31) && month != 2) {
            day = 1;
            month = (month == 12) ? 1 : month + 1;
            if (month == 1) year++;
        }

        else {
            day++;
        }

        return String.format("%02d/%02d/%04d", day, month, year);
    }

    //checking if all rules pass and the year is between 1812 to 2212
    public static boolean validDate(int day, int month, int year) {
        return (year >= 1812 && year <= 2212) &&
                (month >= 1 && month <= 12) &&
                (day >= 1 && day <= daysInMonth(month, year));
    }

    //helps figure out how many days in month for validDate method
    public static int daysInMonth(int month, int year) {
        if (month == 2)
            return Year.isLeap(year) ? 29 : 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else
            return 31;
    }
}
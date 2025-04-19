package Fundamentals;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total no of subjects: ");
        int subjectsNum = sc.nextInt();
        int totalMarks = 0;

        for (int i = 1; i <= subjectsNum; i++) {
            System.out.print("Enter marks for subjects "+i+"(out of 100): ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.println("Invalid Marks!!!");
                System.out.print("Enter marks for subjects "+i+"(out of 100): ");
                marks = sc.nextInt();
            }
            totalMarks += marks;
        }

        System.out.println("Student result: " );
        System.out.println("Total marks obtained in all subjects: "+ totalMarks);

        double averagePercentage = (double)totalMarks/subjectsNum;
        System.out.println("Average Percentage: "+ averagePercentage);

        if (averagePercentage >= 90) {
            System.out.println("Your grade: A+");
        }
        else if (averagePercentage >= 80) {
            System.out.println("Your grade: B+");
        }
        else if (averagePercentage >= 70) {
            System.out.println("Your grade: C+");
        }
        else if (averagePercentage >= 60) {
            System.out.println("Your grade: D+");
        }
        else if (averagePercentage >= 50) {
            System.out.println("Your grade: E+");
        }
        else if (averagePercentage >= 40) {
            System.out.println("Your grade: F+");
        }
        else {
            System.out.println("You FAIL!!!");
        }

        sc.close();
    }
}

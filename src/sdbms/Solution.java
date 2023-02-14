package sdbms;

import CustomException.InvalidChoiceException;

import java.util.Scanner;

public class Solution {
    Scanner scanner;
    StudentManagementSystem sms;

    public Solution(){
        System.out.println("Wel Come student Management System");
        System.out.println("----------------------------------");
        scanner = new Scanner(System.in);

        sms = new StudentManagementSystemImpl();

        while (true){
            System.out.println("""
                    1:AddStudent
                    2:DisplayStudent
                    3:DisplayAllStudent
                    4:RemoveStudent
                    5:RemoveAllStudent
                    6:UpdateStudent
                    7:CountStudent
                    8:SortStudent
                    9:StudentsHighestMarks
                    10:StudentsLowestMarks
                    11:EXIT
                    Enter Your choice""");
            int choice = scanner.nextInt();

            switch (choice){
                case 1 -> sms.addStudent();
                case 2 -> sms.displayStudent();
                case 3 -> sms.displayAllStudent();
                case 4 -> sms.removeStudent();
                case 5 -> sms.removeAllStudent();
                case 6 -> sms.updateStudent();
                case 7 -> sms.countStudent();
                case 8 -> sms.sortStudent();
                case 9 -> sms.getStudentWithHighestMarks();
                case 10 -> sms.getStudentWithLowestMarks();
                case 11 -> {
                    System.out.println("Thank You!!!");
                    System.exit(0);
                }
                default -> {
                    try {
                        throw new InvalidChoiceException("Kindly Enter Valid Choice");
                    } catch (Exception e) {
                        System.out.println(  e.getMessage());
                    }
                }

            }
            System.out.println("-------------------");
        }
    }
}

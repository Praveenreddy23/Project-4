package sdbms;

import CustomException.InvalidChoiceException;
import CustomException.StudentInfoNotFoundException;
import StudentDetails.Student;
import customSorting.SortBy_Age;
import customSorting.SortBy_ID;
import customSorting.SortBy_Marks;
import customSorting.SortBy_Name;

import java.util.*;

public class StudentManagementSystemImpl implements  StudentManagementSystem {
    Scanner scanner = new Scanner(System.in);
    Map<String, Student> details = new LinkedHashMap<>();
    @Override
    public void addStudent() {
        System.out.println("Enter Student Age: ");
        int age = scanner.nextInt();
        System.out.println("Enter Student Name");
        String name = scanner.next();
        System.out.println("Enter Student Marks");
        int marks = scanner.nextInt();

        Student student = new Student(age,name,marks);
        details.put(student.getId(),student);
        System.out.println("Student Details Inserted Successfully!!!");
        System.out.println("Student Id is "+student.getId());
    }

    @Override
    public void displayStudent() {
        System.out.println("Enter Student Id:");
        String id = scanner.next().toUpperCase(Locale.ROOT);
        if (details.containsKey(id)){
            Student s = details.get(id);
            System.out.println("ID: "+s.getId());
            System.out.println("Age: "+s.getAge());
            System.out.println("Name: "+s.getName());
            System.out.println("Marks: "+s.getMarks());
        }else{
            try {
                throw new StudentInfoNotFoundException();
            }catch (Exception e){
                System.out.println("Student with ID "+id+" Not found");
            }
        }

    }

    @Override
    public void displayAllStudent() {
        System.out.println("Student details are as follows:");
        System.out.println("---------------------------------");
        Set<String> keys = details.keySet();
        for (Object key: keys) {
            System.out.println(details.get(key));
        }
    }
    @Override
    public void removeStudent() {
        System.out.println("Enter student Id:");
        String id = scanner.next().toUpperCase();

        if (details.containsKey(id)){
            System.out.println("Student Record found!");
            System.out.println(details.get(id));//getting student object and printing it
            details.remove(id);
            System.out.println("Student Record Deleted successfully!");
        }else {
            try {
                throw new StudentInfoNotFoundException();
            }catch (Exception e){
                System.out.println("Student with ID "+id+" Not found");
            }

        }

    }

    @Override
    public void removeAllStudent() {
        if (details.size() != 0){
            System.out.println("Number Of Student details: "+details.size());

            details.clear();
            System.out.println("All student record Deleted successfully!!!");
            System.out.println("Number Of Student details: "+details.size());
        }else {
            try {
                throw new StudentInfoNotFoundException();
            }catch (Exception e){
                System.out.println("Student Records Not found");
            }

        }

    }

    @Override
    public void updateStudent() {
        System.out.println("Enter Student ID:");
        String id = scanner.next().toUpperCase();

        if (details.containsKey(id)){
            Student student = details.get(id);
            System.out.println("1:Update Age\n2:Update Name\n3:Update Marks\nEnter choice");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Enter Age");
                   // int age = scanner.nextInt();
                    student.setAge(scanner.nextInt());
                    System.out.println("Age Updated successfully");
                }
                case 2 ->{
                    System.out.println("Enter Name");
                    student.setName(scanner.next());
                    System.out.println("Name Update successfully");
                }
                case 3 ->{
                    System.out.println("Enter Marks");
                    student.setMarks(scanner.nextInt());
                    displayStudent();
                    System.out.println("Marks Update successfully");
                }
                default -> {
                    try {
                        throw new InvalidChoiceException("kindly Enter valid choice");
                    }catch (Exception e){
                        System.out.println(e.getMessage());

                    }
                }
            }
        }
    }

    @Override
    public void countStudent() {
        System.out.println("Number Of Student details: "+details.size());

    }
    SortBy_ID id = new SortBy_ID();
    SortBy_Age age = new SortBy_Age();
    SortBy_Name name = new SortBy_Name();
    SortBy_Marks marks = new SortBy_Marks();
    @Override
    public void sortStudent() {
        List<Student> list = new ArrayList<>();
        for(String key : details.keySet()){
           Student student = details.get(key);
            list.add(student);
        }
        System.out.println("1:Sort By Id\n2:Sort By Age\n3:Sort By Name\n4:Sort By Marks\nEnter your choice");
        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> {
                System.out.println("Sorted By ID:");
                list.sort(id);
                display(list);
            }
            case 2 -> {
                System.out.println("Sorted By Age:");
                list.sort(age);
                display(list);
            }
            case 3 -> {
                System.out.println("Sorted By Name:");
                list.sort(name);
                display(list);
            }
            case 4 -> {
                System.out.println("Sort By Marks:");
                list.sort(marks);
                display(list);
            }
            default -> {
                try {
                    throw new InvalidChoiceException("Kindly Enter Valid Choice");
                } catch (Exception e) {
                    System.out.println(  e.getMessage());
                }
            }
        }
    }

    @Override
    public void getStudentWithHighestMarks() {
            Set<String> keys = details.keySet();
            List<Student> list = new ArrayList<>();
            for (String key : keys) {
                list.add(details.get(key));
            }
        if (details.size() != 0){
            list.sort(new SortBy_Marks());
            System.out.println("Student Details With Highest Marks:");

            System.out.println(list.get(list.size() - 1));
       }else {
            try {
                throw new StudentInfoNotFoundException();
            }catch (Exception e){
                System.out.println("Student Records Not found");
            }
        }
    }

    @Override
    public void getStudentWithLowestMarks() {
            Set<String> keys = details.keySet();
            List<Student> list = new ArrayList<>();
            for (String key : keys) {
                list.add(details.get(key));
            }
        if (details.size() != 0) {
            list.sort(new SortBy_Marks());
            System.out.println("Student Details With Lowest Marks:");
            System.out.println(list.get(list.size()));
        }else {
            try {
                throw new StudentInfoNotFoundException();
            }catch (Exception e){
                System.out.println("Student Records Not found");
            }
       }

    }

    private void display(List<Student> list) {
       list.forEach(System.out::println);
    }
}

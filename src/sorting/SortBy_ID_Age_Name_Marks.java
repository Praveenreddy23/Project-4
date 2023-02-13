package sorting;

import StudentDetails.Student;

import java.util.Comparator;

public class SortBy_ID_Age_Name_Marks implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - (o2.getAge());
    }
}

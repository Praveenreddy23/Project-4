package customSorting;

import StudentDetails.Student;

import java.util.Comparator;

public class SortBy_ID implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId().compareTo(o2.getId());
    }
}


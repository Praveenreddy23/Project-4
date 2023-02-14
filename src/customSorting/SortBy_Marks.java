package customSorting;

import StudentDetails.Student;

import java.util.Comparator;

public class SortBy_Marks implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getMarks() - o2.getMarks());
    }
}

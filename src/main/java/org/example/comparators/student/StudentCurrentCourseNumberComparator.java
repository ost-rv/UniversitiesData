package org.example.comparators.student;

import org.example.interfaces.IStudentComparator;
import org.example.models.Student;

public class StudentCurrentCourseNumberComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}

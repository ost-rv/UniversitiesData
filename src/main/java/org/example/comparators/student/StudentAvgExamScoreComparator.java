package org.example.comparators.student;

import org.example.interfaces.IStudentComparator;
import org.example.models.Student;

public class StudentAvgExamScoreComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore()) * -1;
    }
}

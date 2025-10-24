package org.example.interfaces;

import org.example.models.Student;

import java.util.Comparator;

public interface IStudentComparator extends Comparator<Student> {
    @Override
    int compare(Student o1, Student o2);
}

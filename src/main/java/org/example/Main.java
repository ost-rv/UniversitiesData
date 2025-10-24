package org.example;


import org.example.enums.StudyProfile;
import org.example.models.Student;
import org.example.models.StudentBuilder;
import org.example.models.University;
import org.example.models.UniversityBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = XlsxReader.readStudentsFromExcel("universityInfo.xlsx");
        List<University> universityList = XlsxReader.readUniversitiesFromExcel("universityInfo.xlsx");

        universityList.forEach(System.out::println);
        studentList.forEach(System.out::println);
    }
}
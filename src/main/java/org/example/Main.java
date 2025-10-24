package org.example;


import org.example.enums.StudentSortBy;
import org.example.enums.StudyProfile;
import org.example.enums.UniversitySortBy;
import org.example.models.Student;
import org.example.models.StudentBuilder;
import org.example.models.University;
import org.example.models.UniversityBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = XlsxReader.readStudentsFromExcel("universityInfo.xlsx");
        List<University> universityList = XlsxReader.readUniversitiesFromExcel("universityInfo.xlsx");

        System.out.println("==============СТУДЕНТЫ===============");
        System.out.println("***Сортировка студентов по FullName***");
        studentList.stream()
                .sorted(StudentSortBy.FULL_NAME.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка студентов по UniversityId***");
        studentList.stream()
                .sorted(StudentSortBy.UNIVERSITY_ID.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка студентов по CurrentCourseNumber***");
        studentList.stream()
                .sorted(StudentSortBy.CURRENT_COURSE_NUMBER.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка студентов по AvgExamScore***");
        studentList.stream()
                .sorted(StudentSortBy.AVG_EXAM_SCORE.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("==============УНИВЕРСИТЕТЫ===============");

        System.out.println("***Сортировка университетов по Id***");
        universityList.stream()
                .sorted(UniversitySortBy.UNIVERSITY_ID.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка университетов по FullName***");
        universityList.stream()
                .sorted(UniversitySortBy.FULL_NAME.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка университетов по ShortName***");
        universityList.stream()
                .sorted(UniversitySortBy.SHORT_NAME.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка университетов по YearOfFoundation***");
        universityList.stream()
                .sorted(UniversitySortBy.YEAR_OF_FOUNDATION.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

        System.out.println("***Сортировка университетов по MainProfile***");
        universityList.stream()
                .sorted(UniversitySortBy.MAIN_PROFILE.getComparator())
                .forEach(System.out::println);
        System.out.println("************************************");

    }
}
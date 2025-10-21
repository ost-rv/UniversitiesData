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
        University university1 =  new UniversityBuilder()
                .setId("1")
                .setFullName("Российский биотехнологический университет")
                .setShortName("РОСБИОТЕХ")
                .setYearOfFoundation(1930)
                .setMainProfile(StudyProfile.MEDICINE)
                .createUniversity();

        University university2 =  new UniversityBuilder()
                .setId("2")
                .setFullName("Государственный университет просвещения")
                .setShortName("ГУП")
                .setYearOfFoundation(1931)
                .setMainProfile(StudyProfile.PEDAGOGICAL)
                .createUniversity();

        University university3 =  new UniversityBuilder()
                .setId("3")
                .setFullName("Московский государственный технический университет им. Н.Э. Баумана")
                .setShortName("МГТУ им. Н.Э. Бауман")
                .setYearOfFoundation(1830)
                .setMainProfile(StudyProfile.ENGINEERING)
                .createUniversity();

        List<Student> studentList = new ArrayList<>() {{
            add(new StudentBuilder()
                    .setFullName("Остап Бендер")
                    .setUniversityId(university1.getId())
                    .setCurrentCourseNumber(3)
                    .setAvgExamScore(4.1f)
                    .createStudent());

            add(new StudentBuilder()
                    .setFullName("Эраст Фандорин")
                    .setUniversityId(university2.getId())
                    .setCurrentCourseNumber(4)
                    .setAvgExamScore(4.5f)
                    .createStudent());

           add(new StudentBuilder()
                    .setFullName("Илья Муромец")
                    .setUniversityId(university3.getId())
                    .setCurrentCourseNumber(5)
                    .setAvgExamScore(4.9f)
                    .createStudent());
        }};

        List<University> universityList = new ArrayList<>(){{
            add(university1);
            add(university2);
            add(university3);
        }};
        universityList.forEach(System.out::println);
        studentList.forEach(System.out::println);
    }
}
package org.example;

import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utils.JsonUtil;
import org.example.utils.StatisticsUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = XlsxReader.readStudentsFromExcel("universityInfo.xlsx");
        List<University> universityList = XlsxReader.readUniversitiesFromExcel("universityInfo.xlsx");

        List<Statistics> statistics = StatisticsUtils.collectStatistics(studentList, universityList);

        XlsxWriter.WriteStatistics(statistics, "statistics.xlsx");
    }
}
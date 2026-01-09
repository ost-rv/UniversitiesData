package org.example;

import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utils.StatisticsUtils;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

        logger.info("Начало работы приложения");

        List<Student> studentList = XlsxReader.readStudentsFromExcel("universityInfo.xlsx");
        List<University> universityList = XlsxReader.readUniversitiesFromExcel("universityInfo.xlsx");

        List<Statistics> statistics = StatisticsUtils.collectStatistics(studentList, universityList);

        XlsxWriter.WriteStatistics(statistics, "statistics.xlsx");

        logger.info("Конец работы приложения");
    }
}
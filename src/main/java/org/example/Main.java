package org.example;

import org.example.enums.StudentSortBy;
import org.example.enums.UniversitySortBy;
import org.example.models.ExportStructData;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utils.JsonUtil;
import org.example.utils.StatisticsUtil;
import org.example.utils.XmlUtil;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

        logger.info("Начало работы приложения");

        List<Student> studentList = XlsxReader.readStudentsFromExcel("universityInfo.xlsx")
                .stream()
                .sorted(StudentSortBy.UNIVERSITY_ID.getComparator())
                .toList();
        List<University> universityList = XlsxReader.readUniversitiesFromExcel("universityInfo.xlsx")
                .stream()
                .sorted(UniversitySortBy.UNIVERSITY_ID.getComparator())
                .toList();

        List<Statistics> statisticalList = StatisticsUtil.collectStatistics(studentList, universityList);

        ExportStructData exportStructData = new ExportStructData(studentList, universityList, statisticalList, OffsetDateTime.now().toString());

        XmlUtil.writeXml(exportStructData);
        JsonUtil.writeJson(exportStructData);
        //XlsxWriter.WriteStatistics(statisticalList, "statistics.xlsx");

        logger.info("Конец работы приложения");
    }
}
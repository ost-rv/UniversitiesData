package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.models.Student;
import org.example.models.StudentBuilder;
import org.example.models.University;
import org.example.models.UniversityBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class XlsxReader {
    private static final String STUDENT_SHEET_NAME = "Студенты";
    private static final String UNIVERSITY_SHEET_NAME = "Университеты";

    private static final String STUD_CLMN_UNIVERSITY_ID = "id университета";
    private static final String STUD_CLMN_FIO = "ФИО";
    private static final String STUD_CLMN_COURSE = "Курс";
    private static final String STUD_CLMN_AVG_EXAM_SCORE = "Средний балл";

    private static final String UNIV_CLMN_UNIVERSITY_ID = "id университета";
    private static final String UNIV_CLMN_FULL_NAME = "Полное название";
    private static final String UNIV_CLMN_SHORT_NAME = "Аббревиатура";
    private static final String UNIV_CLMN_YEAR = "Год основания";
    private static final String UNIV_CLMN_PROFILE = "Профиль обучения";

    private XlsxReader() {
    }

    //region Студенты
    public static List<Student> readStudentsFromExcel(String fileName) {
        List<Student> result = new ArrayList<>();
        try (InputStream excelFile = XlsxReader.class.getClassLoader().getResourceAsStream(fileName)) {
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet sheet = workbook.getSheet(STUDENT_SHEET_NAME);
            if (sheet == null) {
                System.err.println("Лист '" + STUDENT_SHEET_NAME + "' не найден.");
                return null;
            }

            // Получаем индексы столбцов по их заголовкам
            Map<String, Integer> columnIndices = getStudentColumnIndices(sheet.getRow(0));
            if (columnIndices == null) {
                System.err.println("Не удалось найти все необходимые заголовки столбцов для студентов.");
                return null;
            }

            // Итерация по строкам, начиная со второй (после заголовка)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    continue; // Пропускаем пустые строки
                }

                try {
                    // Извлекаем данные из ячеек, используя найденные индексы столбцов
                    String universityId = currentRow.getCell(columnIndices.get(STUD_CLMN_UNIVERSITY_ID)).getStringCellValue();
                    String fullName = currentRow.getCell(columnIndices.get(STUD_CLMN_FIO)).getStringCellValue();
                    int course = (int) currentRow.getCell(columnIndices.get(STUD_CLMN_COURSE)).getNumericCellValue();
                    float avgExamScore = (float) currentRow.getCell(columnIndices.get(STUD_CLMN_AVG_EXAM_SCORE)).getNumericCellValue();

                    result.add(new StudentBuilder().setUniversityId(universityId).setFullName(fullName).setCurrentCourseNumber(course).setAvgExamScore(avgExamScore).createStudent());

                } catch (NullPointerException | IllegalStateException e) {
                    System.err.println("Ошибка при чтении строки " + (i + 1) + ": " + e.getMessage());
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private static Map<String, Integer> getStudentColumnIndices(Row headerRow) {
        if (headerRow == null) {
            return null;
        }

        Map<String, Integer> columnIndices = new HashMap<>();

        for (Cell cell : headerRow) {
            String header = cell.getStringCellValue().trim();

            switch (header) {
                case STUD_CLMN_UNIVERSITY_ID:
                case STUD_CLMN_FIO:
                case STUD_CLMN_COURSE:
                case STUD_CLMN_AVG_EXAM_SCORE:
                    columnIndices.put(header, cell.getColumnIndex());
                    break;
            }
        }

        // Проверяем, что все необходимые заголовки найдены
        if (columnIndices.size() == 4) {
            return columnIndices;
        }
        return null;
    }
    //endregion Студенты

    //region Университеты
    public static List<University> readUniversitiesFromExcel(String fileName) {
        List<University> result = new ArrayList<>();
        try (InputStream excelFile = XlsxReader.class.getClassLoader().getResourceAsStream(fileName)) {
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet sheet = workbook.getSheet(UNIVERSITY_SHEET_NAME);
            if (sheet == null) {
                System.err.println("Лист '" + UNIVERSITY_SHEET_NAME + "' не найден.");
                return null;
            }

            // Получаем индексы столбцов по их заголовкам
            Map<String, Integer> columnIndices = getUniversityColumnIndices(sheet.getRow(0));

            if (columnIndices == null) {
                System.err.println("Не удалось найти все необходимые заголовки столбцов для студентов.");
                return null;
            }

            // Итерация по строкам, начиная со второй (после заголовка)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    continue; // Пропускаем пустые строки
                }

                try {
                    // Извлекаем данные из ячеек, используя найденные индексы столбцов
                    String universityId = currentRow.getCell(columnIndices.get(UNIV_CLMN_UNIVERSITY_ID)).getStringCellValue();
                    String fullName = currentRow.getCell(columnIndices.get(UNIV_CLMN_FULL_NAME)).getStringCellValue();
                    String shortName = currentRow.getCell(columnIndices.get(UNIV_CLMN_SHORT_NAME)).getStringCellValue();
                    int year = (int) currentRow.getCell(columnIndices.get(UNIV_CLMN_YEAR)).getNumericCellValue();
                    StudyProfile profile = StudyProfile.valueOf(currentRow.getCell(columnIndices.get(UNIV_CLMN_PROFILE)).getStringCellValue());

                    result.add(new UniversityBuilder().setId(universityId).setFullName(fullName).setShortName(shortName).setYearOfFoundation(year).setMainProfile(profile).createUniversity());

                } catch (NullPointerException | IllegalStateException e) {
                    System.err.println("Ошибка при чтении строки " + (i + 1) + ": " + e.getMessage());
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private static Map<String, Integer> getUniversityColumnIndices(Row headerRow) {
        if (headerRow == null) {
            return null;
        }

        Map<String, Integer> columnIndices = new HashMap<>();

        for (Cell cell : headerRow) {
            String header = cell.getStringCellValue().trim();

            switch (header) {
                case UNIV_CLMN_UNIVERSITY_ID:
                case UNIV_CLMN_FULL_NAME:
                case UNIV_CLMN_SHORT_NAME:
                case UNIV_CLMN_YEAR:
                case UNIV_CLMN_PROFILE:
                    columnIndices.put(header, cell.getColumnIndex());
                    break;
            }
        }

        // Проверяем, что все необходимые заголовки найдены
        if (columnIndices.size() == 5) {
            return columnIndices;
        }
        return null;
    }
    //endregion Университеты

}

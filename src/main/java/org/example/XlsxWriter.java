package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.models.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

public class XlsxWriter {

    public static void WriteStatistics(List<Statistics> statisticsList, String filePath) {
        // 1. Создание книги
        Workbook workbook = new XSSFWorkbook();
        // 2. Создание нового листа в книге
        Sheet sheet = workbook.createSheet("Статистика");
        try {
            // 3. Создаем заголовочную строку
            createHeaderRow(sheet, workbook);

            // 4. Заполняем данными из списка объектов
            int rowNum = 1;
            for (Statistics stats : statisticsList) {
                Row row = sheet.createRow(rowNum++);
                // Используем вспомогательный метод для заполнения ячеек
                fillRowWithStatsData(row, stats);
            }

            // Автоматически подстраиваем ширину столбцов для красоты (опционально)
            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            // Записываем книгу в файл
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Файл " + filePath + " успешно создан и заполнен.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createHeaderRow(Sheet sheet, Workbook workbook) {
        Row headerRow = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short)14);
        font.setBold(true);

        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        String[] headers = {"Профиль обучения", "Средний балл за экзамен", "Кол-во студентов по профилю", "Кол-во университетов по профилю", "Название университета"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
    }

    private static void fillRowWithStatsData(Row row, Statistics stats) {
        // Заполнение ячеек по порядку полей класса Statistics
        row.createCell(0).setCellValue(stats.getMainProfile().name()); // Enum в строку
        Optional<Double> avg = stats.getAvgExamScore();

        if(avg.isPresent())
            row.createCell(1).setCellValue(BigDecimal.valueOf(stats.getAvgExamScore().get()).setScale(2, RoundingMode.HALF_UP).doubleValue());

        row.createCell(2).setCellValue(stats.getCountStudentByProfile());
        row.createCell(3).setCellValue(stats.getCountUniversityByProfile());
        row.createCell(4).setCellValue(stats.getUniversityNames());
    }
}

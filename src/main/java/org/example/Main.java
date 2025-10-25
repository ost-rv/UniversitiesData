package org.example;


import org.example.models.Student;
import org.example.models.University;
import org.example.utils.JsonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = XlsxReader.readStudentsFromExcel("universityInfo.xlsx");
        List<University> universityList = XlsxReader.readUniversitiesFromExcel("universityInfo.xlsx");

        //4. В методе main выполнить сериализацию коллекций, вывести получившиеся JSON-строки в консоль.
        String jsonStudents = JsonUtil.serializeCollection(studentList);
        String jsonUniversities = JsonUtil.serializeCollection(universityList);

        System.out.println("=========Сериализация в json списка студентов=========");
        System.out.println(jsonStudents);

        System.out.println("=========Сериализация в json списка университетов=========");
        System.out.println(jsonUniversities);

        //5. В методе main выполнить десериализацию полученных строк, сохранить результаты в новые коллекции.
        List<Student> deserializeStudents = JsonUtil.deserializeJsonToCollection(jsonStudents, Student.class);
        List<University> deserializeUniversities = JsonUtil.deserializeJsonToCollection(jsonUniversities, University.class);

        System.out.println("=========Десериализация из json в список студентов=========");
        deserializeStudents.forEach(System.out::println);

        System.out.println("=========Десериализация из json в список университетов=========");
        deserializeUniversities.forEach(System.out::println);

        // 6. Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться, что десериализация выполняется корректно.
        if(studentList.stream().count() == deserializeStudents.stream().count()){
            System.out.println("=========Десериализация студентов прошла успешно!=========");
        } else {
            System.out.println("=========Десериализация студентов не прошла.=========");
        }

        if(universityList.stream().count() == deserializeUniversities.stream().count()){
            System.out.println("=========Десериализация университетов прошла успешно!=========");
        } else {
            System.out.println("=========Десериализация университетов не прошла.=========");
        }
        //7. С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
        //8. Там же внутри стрима выводить получающиеся JSON-строки.
        //9. Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
        //10. Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
        System.out.println("Поэлементная сериализаци/десериализация студентов");
        studentList.stream()
                .map(JsonUtil::serializeJson)
                .peek(System.out::println)
                .map(item -> JsonUtil.deserializeJson(item, Student.class))
                .forEach(System.out::println);

        System.out.println("=========Поэлементная сериализаци/десериализация университетов=========");
        universityList.stream()
                .map(JsonUtil::serializeJson)
                .peek(System.out::println)
                .map(item -> JsonUtil.deserializeJson(item, University.class))
                .forEach(System.out::println);
    }
}
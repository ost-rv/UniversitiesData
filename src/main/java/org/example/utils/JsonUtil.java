package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {
    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting() //Делает json читаемый с отступами
            .create();

    private JsonUtil(){}

    public static <T> String serializeJson(T model){
        // Сериализация объекта в JSON-строку
        return GSON.toJson(model);
    }

    public static <T> T deserializeJson(String jsonString, Class<T> classOfT){
        // Десериализация JSON-строки в объект
        return GSON.fromJson(jsonString, classOfT);
    }

    public static <T> String serializeCollection(Collection<T> collection) {
        return GSON.toJson(collection);
    }

    public static <T> ArrayList<T> deserializeJsonToCollection(String jsonString, Class<T> elementType) {
        Type collectionType = TypeToken.getParameterized(ArrayList.class, elementType).getType();
        return GSON.fromJson(jsonString, collectionType);
    }

    public static <T> void writeJson(T model) {
        try {
            // Подготовка пути (папка jsonReqs и расширение .json)
            Path directory = Files.createDirectories(Path.of("jsonReqs"));
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String fileName = "req_" + timestamp + ".json";
            Path filePath = directory.resolve(fileName);

            // Запись в файл через Writer (с автоматическим закрытием ресурсов)
            try (Writer writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
                GSON.toJson(model, writer);
            }

            logger.info("JSON файл успешно сохранен: " + filePath);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Ошибка при записи JSON: " + e.getMessage());
        }
    }
}

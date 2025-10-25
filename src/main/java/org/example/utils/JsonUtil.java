package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil(){}

    public static <T> String serializeJson(T model){
        // Сериализация объекта в JSON-строку
        return gson.toJson(model);
    }

    public static <T> T deserializeJson(String jsonString, Class<T> classOfT){
        // Десериализация JSON-строки в объект
        return gson.fromJson(jsonString, classOfT);
    }

    public static <T> String serializeCollection(Collection<T> collection) {
        return gson.toJson(collection);
    }

    public static <T> ArrayList<T> deserializeJsonToCollection(String jsonString, Class<T> elementType) {
        Type collectionType = TypeToken.getParameterized(ArrayList.class, elementType).getType();
        return gson.fromJson(jsonString, collectionType);
    }
}

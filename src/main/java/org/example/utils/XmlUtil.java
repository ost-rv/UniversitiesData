package org.example.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlUtil {
    private static final Logger logger = Logger.getLogger(XmlUtil.class.getName());

    public static <T> void writeXml(T model) {
        try {
            logger.info("Начало сохранения в XML файл");
            // Подготовка пути
            Path directory = Files.createDirectories(Path.of("xmlReqs"));
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String fileName = "req_" + timestamp + ".xml";
            Path filePath = directory.resolve(fileName);

            // Инициализируем JAXB для класса передаваемого объекта
            JAXBContext context = JAXBContext.newInstance(model.getClass());
            Marshaller marshaller = context.createMarshaller();

            // Настройка: красивые отступы в XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Настройка: кодировка UTF-8
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            // Маршалинг (сохранение)
            marshaller.marshal(model, filePath.toFile());
            logger.info("XML файл успешно сохранен: " + filePath);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Ошибка работы с файлом при записи XML: " + e.getMessage());
        } catch (JAXBException e) {
            logger.log(Level.SEVERE,"Ошибка при записи XML: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

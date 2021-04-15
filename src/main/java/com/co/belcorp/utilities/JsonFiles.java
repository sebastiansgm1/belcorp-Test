package com.co.belcorp.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import net.thucydides.core.steps.StepInterceptor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonFiles<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);
  private static final String EXTENSION = ".json";
  private static final String ERROR_READING_JSON_FILE = "Error al leer archivo Json";

  public static Object readJsonFile(String directory, String fileName) {
    Object obj = null;
    try {
      JSONParser parser = new JSONParser();
      obj = parser.parse(new FileReader(directory + fileName + EXTENSION));
    } catch (Exception e) {
      LOGGER.error(ERROR_READING_JSON_FILE + fileName + ": ", e);
    }
    return obj;
  }

  public static Object writeJsonFile(
      Object information, String directory, String fileName, String key, String keyValue) {
    JSONObject jsonObject = new JSONObject((Map) information);
    jsonObject.put(key, keyValue);
    try {
      FileWriter fileWriter = new FileWriter(directory + fileName + EXTENSION);
      fileWriter.write(jsonObject.toJSONString());
      fileWriter.close();
    } catch (Exception e) {
      LOGGER.error(ERROR_READING_JSON_FILE + fileName + ": ", e);
    }
    return jsonObject;
  }

  public static <T> T getObjectJava(String directory, String fileName, Class<T> clase) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.readValue(new File(directory + fileName + EXTENSION), clase);
    } catch (IOException e) {
      LOGGER.error(ERROR_READING_JSON_FILE + fileName + ": ", e);
      return null;
    }
  }
}

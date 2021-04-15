package com.co.belcorp.utilities;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class CsvUtilities {

  private static final String RESOURCES_PATH = "./src/test/resources/data/";
  private static final String PREFIX_NAME = "data_";
  private static final String EXTENSION = ".csv";
  private static final String FILTER_ID = "idFiltro";
  private static final char SEPARATION_CHARACTER = ';';

  private CsvUtilities() {}

  //Este metodo obtiene toda la data de CSV en una lista de mapas
  public static List<Map<String, String>> getDataCsv(String csvName) throws IOException {
    List<Map<String, String>> dataList = new ArrayList<>();
    File file =
        new File(
            RESOURCES_PATH
                + PREFIX_NAME
                + csvName
                + EXTENSION);
    InputStream in = new FileInputStream(file);
    Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
    Iterator<Map<String, String>> iterator =
        new CsvMapper()
            .readerFor(Map.class)
            .with(CsvSchema.emptySchema().withColumnSeparator(SEPARATION_CHARACTER).withHeader())
            .readValues(reader);
    while (iterator.hasNext()) {
      Map<String, String> row = iterator.next();
      dataList.add(row);
    }
    in.close();
    reader.close();
    return dataList;
  }

  //Este metodo obtiene una lista de mapas con los datos de un CSV que tengan el mismo idFiltro
  public static List<Map<String, String>> getDataTest(String csvName, String filter)
      throws IOException {
    List<Map<String, String>> dataTable =  getDataCsv(csvName);
    List<Map<String, String>> filteredList = new ArrayList<>();
    for (Map<String, String> list : dataTable) {
      if (list.get(FILTER_ID).equalsIgnoreCase(filter.toLowerCase())) {
        filteredList.add(list);
      }
    }
    for (int i = 0; i < filteredList.size(); i++) {
      filteredList.get(i).remove(FILTER_ID);
    }
    return filteredList;
  }

  //Este metodo obtiene la data desde un CSV y por medio de un idFiltro y la entrega en un Map
  public static Map<String, String> getMapTestData(String csvName, String filter)
      throws IOException {
    return getDataTest(csvName, filter).stream().findFirst().orElse(null);
  }
}

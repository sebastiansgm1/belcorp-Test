package com.co.belcorp.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

  public static String getCurrentDateTime() {
    Date fecha = new Date();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(fecha);
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
  }

}

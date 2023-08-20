package org.eoisaac.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
  private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static Instant convertStringToInstant(String dateString) {
    LocalDate localDate = parseDateString(dateString);
    if (localDate != null) {
      Date date = convertLocalDateToDate(localDate);
      return date.toInstant();
    }
    return null;
  }

  public static String convertInstantToString(Instant instant) {
    Date date = Date.from(instant);
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    return localDate.format(dateFormatter);
  }

  private static LocalDate parseDateString(String dateString) {
    try {
      return LocalDate.parse(dateString, dateFormatter);
    } catch (DateTimeParseException e) {
      return null;
    }
  }

  private static Date convertLocalDateToDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }
}

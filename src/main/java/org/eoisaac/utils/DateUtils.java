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

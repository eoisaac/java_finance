package org.eoisaac.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtils { // Utility class for date formatting
  private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Sets the date format

  public static Instant convertStringToInstant(String dateString) { // Converts a string to an instant
    LocalDate localDate = parseDateString(dateString); // Parses the string to a local date
    if (localDate != null) { // If the local date is not null
      Date date = convertLocalDateToDate(localDate); // Converts the local date to a date
      return date.toInstant(); // Returns the instant
    }
    return null; // Returns null
  }

  public static String convertInstantToString(Instant instant) { // Converts an instant to a string
    Date date = Date.from(instant); // Converts the instant to a date
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Converts the date to a local date
    return localDate.format(dateFormatter); // Returns the formatted string
  }

  private static LocalDate parseDateString(String dateString) { // Parses a string to a local date
    try {
      return LocalDate.parse(dateString, dateFormatter); // Returns the parsed local date
    } catch (DateTimeParseException e) { // If the string is not a valid date
      return null; // Returns null
    }
  }

  private static Date convertLocalDateToDate(LocalDate localDate) { // Converts a local date to a date
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()); // Returns the date
  }
}

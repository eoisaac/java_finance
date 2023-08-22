package org.eoisaac.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/*
* That class is responsible for formatting a string to an instant, and an instant to a string. It uses the DateTimeFormatter
* class to format the string, and the LocalDate class to parse the string to a local date. It also uses the Date class to
* convert the local date to a date, and the Instant class to convert the date to an instant. So, it receives a string, and
* returns an instant. For example, if the string is 01/01/2021, it returns 2021-01-01T00:00:00Z.
* It also receives an instant, and returns a string. For example, if the instant is 2021-01-01T00:00:00Z, it returns 01/01/2021.
* */

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

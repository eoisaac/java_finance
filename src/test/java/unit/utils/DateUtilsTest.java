package unit.utils;

import java.time.*;

import org.eoisaac.utils.DateUtils;
import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class DateUtilsTest {

  @Test
  public void convertStringToInstant() {
    String dateString = "21/03/2001";

    // Set the desired time zone (America/Sao_Paulo)
    ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

    LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
    Instant expectedInstant = zonedDateTime.toInstant();

    Instant instantDate = DateUtils.convertStringToInstant(dateString);

    assertNotNull("Instant should not be null", instantDate);
    assertEquals(
        "Instant should be 2001-03-21T00:00:00Z for date 21/03/2001", expectedInstant, instantDate);
  }

  @Test
  public void convertInstantToString() {
    Instant instant = Instant.parse("2001-03-21T12:00:00Z");
    ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

    String expectedDateString = "21/03/2001";

    String dateString = DateUtils.convertInstantToString(instant, zoneId);

    assertNotNull("Date should not be null", dateString);
    assertEquals(
        "Date should be 21/03/2001 for instant 2001-03-21T12:00:00Z",
        expectedDateString,
        dateString);
  }
}

package unit.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eoisaac.utils.CurrencyUtils;
import org.junit.Test;

public class CurrencyUtilsTest {

  @Test
  public void testFormatCurrency() {
    float value = 100.0f;
    String expectedCurrency = "R$ 100,00";
    String formattedCurrency = CurrencyUtils.formatCurrency(value);
    String cleanedFormattedCurrency = formattedCurrency.replace("\u00A0", " ");

    assertNotNull("Currency should not be null", formattedCurrency);
    assertEquals(
        "Currency should be R$ 100,00 for value 100.0", expectedCurrency, cleanedFormattedCurrency);
  }
}

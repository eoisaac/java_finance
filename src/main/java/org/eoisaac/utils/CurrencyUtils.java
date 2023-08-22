package org.eoisaac.utils;

import java.text.NumberFormat;
import java.util.Locale;

/*
* That class is responsible for formatting a float value to a currency string. It uses the NumberFormat class to format, 
* and the Locale class to set the currency to Brazilian Real. So, it receive a float value, and returns a string with the
* currency format. For example, if the value is 100.0, it returns R$ 100,00.
* */

public class CurrencyUtils { // Utility class for currency formatting
    public static String formatCurrency(float value) { // Formats a float value to a currency string
        return NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(value); // Returns the formatted string
    }
}

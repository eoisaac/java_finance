package org.eoisaac.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils { // Utility class for currency formatting
    public static String formatCurrency(float value) { // Formats a float value to a currency string
        return NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(value); // Returns the formatted string
    }
}

package org.eoisaac.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils {
    public static String formatCurrency(float value) {
        return NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(value);
    }
}

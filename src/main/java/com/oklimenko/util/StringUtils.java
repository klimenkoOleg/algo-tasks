package com.oklimenko.util;

import lombok.experimental.UtilityClass;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

@UtilityClass
public class StringUtils {

    public static String month(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
        }
        return "NONE";
    }

    public static String monthCorrected(int monthNumber) {
        return Month   // Enum class, predefining names for each month of the year.
                .of(monthNumber)
                .getDisplayName(
                        TextStyle.SHORT_STANDALONE, Locale.US
                );
    }

}

package dev.juanleon.supermarket_inventory.common.utils.dateutils;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtils {

    public static LocalDateTime extractDateToStartDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    public static LocalDateTime convertLocalDateToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }
}

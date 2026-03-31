package dev.juanleon.supermarket_inventory.common.utils.dateutils;

import java.time.LocalDateTime;

public interface IDateUtils {

    default LocalDateTime extractDateToStartDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }
}

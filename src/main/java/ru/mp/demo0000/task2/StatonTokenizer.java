package ru.mp.demo0000.task2;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
class StatonTokenizer {
    StationToken makeToken(final Station station) {
        if (station == null || StringUtils.isBlank(station.getName())) {
            throw new IllegalArgumentException("Station name can't be blank.");
        }
        final String effectiveName = station.getName().trim().toUpperCase();
        final String code = effectiveName.substring(0, effectiveName.length()>1 ? 2 : 1);
        return new StationToken(code,station);
    }
}

package ru.mp.demo0000.task2;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StationTask {

    private static List<Station> STATION_LIST = Arrays.asList(
            new Station("МОСКВА"),
            new Station("МОЖГА"),
            new Station("МОЗДОК"),
            new Station("САНКТ-ПЕТЕРБУРГ"),
            new Station("САМАРА"));

    private static final Multimap<String, Station> database = TreeMultimap.create();

    public static void main(String[] args) {
        StationTask task = new StationTask(STATION_LIST);
        System.out.println(task.getStationsByTwoFirstLetters("МО"));
        System.out.println(task.getStationsByTwoFirstLetters("СА"));
    }

    StationTask(final List<Station> stationList) {
        if(stationList==null || stationList.isEmpty()){
            throw new IllegalArgumentException("Station list can't be empty");
        }
        stationList.stream()
                .map(StatonTokenizer::makeToken)
                .forEach(t -> database.put(t.getFirstLetters(),t.getValue()));
    }

    Collection<Station> getStationsByTwoFirstLetters(String prefix) {
        if(prefix==null || StringUtils.isBlank(prefix)){
            return Collections.emptyList();
        }
        final String effectivePrefix = prefix.trim().toUpperCase();
        if(!database.containsKey(effectivePrefix)){
            return Collections.emptyList();
        }
        return database.get(effectivePrefix);
    }
}

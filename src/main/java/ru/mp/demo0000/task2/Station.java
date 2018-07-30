package ru.mp.demo0000.task2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Station implements Comparable<Station>{
    private String name;

    @Override
    public int compareTo(Station station) {
        return name.compareTo(station.name);
    }
}

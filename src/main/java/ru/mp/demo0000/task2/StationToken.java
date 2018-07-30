package ru.mp.demo0000.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
class StationToken {
    private String firstLetters;
    private Station value;
}

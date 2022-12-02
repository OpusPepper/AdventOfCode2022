package dev.opuspepper.factory;

import dev.opuspepper.AdventOfCodeDay1.Day1;
import dev.opuspepper.AdventOfCodeDay2.Day2;
import dev.opuspepper.abstracts.Day;

public class GetDayFactory {

    public Day getDay(int dayNumber)
    {
        switch(dayNumber) {
            case 1:
                return new Day1();
            case 2:
                return new Day2();
            default:
                return null;
        }
    }
}

package dev.opuspepper.factory;

import dev.opuspepper.AdventOfCodeDay1.Day1;
import dev.opuspepper.abstracts.Day;

public class GetDayFactory {

    public Day getDay(int dayNumber)
    {
        switch(dayNumber) {
            case 1:
                return new Day1();
            default:
                return null;
        }
    }
}

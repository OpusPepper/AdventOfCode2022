package dev.opuspepper;

import dev.opuspepper.AdventOfCodeDay1.Day1;
import dev.opuspepper.abstracts.Day;
import dev.opuspepper.factory.GetDayFactory;
import dev.opuspepper.helper.FileNamer;
import dev.opuspepper.helper.FileReader;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting application");

        int dayNumber = 4;
        int partNumber = 2;
        int filePartNumber = 1;
        String postFix = "Input";  // "Example" or "Input"
        FileNamer fileNamer = new FileNamer(dayNumber, filePartNumber, postFix);

        GetDayFactory dayFactory = new GetDayFactory();
        Day day = dayFactory.getDay(dayNumber);
        System.out.println("Starting day " + dayNumber + " part " + partNumber);

        List<String> recordsIn = FileReader.getFileReader().getRecords(dayNumber, filePartNumber, postFix);

        switch(partNumber)
        {
            case 1:
                day.part1(recordsIn, fileNamer.getLabel());
                break;
            case 2:
                day.part2(recordsIn, fileNamer.getLabel());
                break;
            default:
                System.out.println("Part " + partNumber + " not found");
                break;
        }


        System.out.println("Ending application");
    }


}
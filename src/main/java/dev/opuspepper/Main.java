package dev.opuspepper;

import dev.opuspepper.AdventOfCodeDay1.Day1;
import dev.opuspepper.abstracts.Day;
import dev.opuspepper.factory.GetDayFactory;
import dev.opuspepper.helper.FileNamer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting application");

        final var basePath = "C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\";

        int dayNumber = 2;
        int partNumber = 2;
        int filePartNumber = 1;
        String postFix = "Input";
        FileNamer fileNamer = new FileNamer(dayNumber, filePartNumber, postFix);

        GetDayFactory dayFactory = new GetDayFactory();
        Day day = dayFactory.getDay(dayNumber);
        System.out.println("Starting day " + dayNumber + " part " + partNumber);

        File inputFile = new File(basePath, fileNamer.getFileName());
        switch(partNumber)
        {
            case 1:
                day.part1(inputFile, fileNamer.getLabel());
                break;
            case 2:
                day.part2(inputFile, fileNamer.getLabel());
                break;
            default:
                System.out.println("Part " + partNumber + " not found");
                break;
        }


        System.out.println("Ending application");
    }
}
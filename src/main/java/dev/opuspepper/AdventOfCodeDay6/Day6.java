package dev.opuspepper.AdventOfCodeDay6;

import dev.opuspepper.AdventOfCodeDay5.objects.CrateStack;
import dev.opuspepper.AdventOfCodeDay5.objects.Instruction;
import dev.opuspepper.AdventOfCodeDay6.objects.DataStream;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day6 extends Day {
    public void getDay()
    {
        day = 6;
    }
    public void part1(List<String> recordsIn, String inputLabel)
    {
        System.out.println("Starting " + inputLabel);

        DataStream dataStream = new DataStream(recordsIn.get(0));

        System.out.println("The sequence is: " + dataStream.getStartOfPacketMarker().toString());

        System.out.println("The position of the sequence ends: " + dataStream.getPositionOfStartOfPacketMarker());



        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        DataStream dataStream = new DataStream(recordsIn.get(0));

        System.out.println("The sequence is: " + dataStream.getStartOfMessageMarker().toString());

        System.out.println("The position of the sequence ends: " + dataStream.getPositionOfStartOfMessageMarker());

        System.out.println("Ending " + inputLabel);
    }



    }

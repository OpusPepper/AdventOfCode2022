package dev.opuspepper.AdventOfCodeDay3.objects;

public class RucksackHelper {
    private static RucksackHelper rucksackHelperSingleton = new RucksackHelper();
    private RucksackHelper() {};

    public static RucksackHelper getRucksackHelper()
    {
        return rucksackHelperSingleton;
    }

    private int convertToPriority(Character inputChar)
    {
        int asciiValue = (int)inputChar;
        if (65 <= asciiValue && asciiValue <= 90)
        {
            return asciiValue - 38;  // A-Z = 65-90
        }
        if (97 <= asciiValue && asciiValue <= 122)
        {
            return asciiValue - 96;  // a-z = 97-122
        }
        return 0;
    }

    public int calculateSumOfPriorities(String inputString)
    {
        int total = 0;
        for (Character c:inputString.toCharArray()
        ) {
            total += convertToPriority(c);
        }
        return total;
    }
}

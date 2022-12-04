package dev.opuspepper.helper;

import dev.opuspepper.AdventOfCodeDay3.objects.RucksackHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    private static FileReader FileReaderSingleton = new FileReader();
    private FileReader() {};

    public static FileReader getFileReader()
    {
        return FileReaderSingleton;
    }
    public List<String> readFile(File inFile)
    {
        try {
            List<String> records = Files.readAllLines(inFile.toPath());
            return records;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getRecords(Integer dayNumber, Integer filePartNumber, String postFix)
    {
        final var basePath = "C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\";
        FileNamer fileNamer = new FileNamer(dayNumber, filePartNumber, postFix);

        File inputFile = new File(basePath, fileNamer.getFileName());

        FileReader fileReader = new FileReader();

        return fileReader.readFile(inputFile);
    }
}

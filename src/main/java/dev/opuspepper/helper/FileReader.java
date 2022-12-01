package dev.opuspepper.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
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
}

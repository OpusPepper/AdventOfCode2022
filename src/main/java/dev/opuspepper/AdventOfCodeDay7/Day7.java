package dev.opuspepper.AdventOfCodeDay7;

import dev.opuspepper.AdventOfCodeDay7.objects.FileContentImpl;
import dev.opuspepper.AdventOfCodeDay7.objects.FolderContent;
import dev.opuspepper.AdventOfCodeDay7.objects.FolderImpl;
import dev.opuspepper.AdventOfCodeDay7.objects.command;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day7 extends Day {
    public void getDay()
    {
        day = 7;
    }
    //private ArrayList<FolderContent> fileSystem = new ArrayList<>();
    private ArrayList<FolderImpl> listOfFolders = new ArrayList<>();
    private ArrayList<FolderImpl> smallFolders = new ArrayList<>();
    private ArrayList<FolderImpl> part2Folders = new ArrayList<>();
    private Integer outerMostDirectorySize = 0;
    Integer availableSpace = 0;
    Integer needMoreThanThisToFreeUp = 0;

    public void part1(List<String> recordsIn, String inputLabel)
    {
        System.out.println("Starting " + inputLabel);

        ArrayList<command> commands = new ArrayList<>();
        command newCommand = new command();

        FolderImpl rootFolder = new FolderImpl();
        rootFolder.setName("/");
        //fileSystem.add(rootFolder);

        FolderImpl currentFolder = rootFolder;

        Boolean foundLsCommand = true;
        for (String s : recordsIn
        ) {
            String[] wordsInCommand = s.split(" ");

            if (wordsInCommand[1].length() == 2 && wordsInCommand[1].compareTo("cd") == 0)
            {
                if (wordsInCommand[2].equals(".."))
                {
                    currentFolder = currentFolder.getParent();
                }
                else if (wordsInCommand[2].equals("/"))
                {
                }
                else {
                    addFolder(wordsInCommand[2], currentFolder);
                    foundLsCommand = false;
                    currentFolder = getFolder(wordsInCommand[2], currentFolder);
                }
            }
            else if (wordsInCommand[1].length() == 2 && wordsInCommand[1].compareTo("ls") == 0)
            {
                foundLsCommand = true;
            }
            else if (foundLsCommand)
            {
                if (wordsInCommand[0].length() == 3 && wordsInCommand[0].compareTo("dir") == 0)
                {
                    addFolder(wordsInCommand[1], currentFolder);
                }
                else
                {

                    addFile(wordsInCommand, currentFolder);
                }
            }
        }

        setSizes((FolderImpl) rootFolder);

        printFileSystem((FolderImpl) rootFolder, 0);

        //Integer totalSizeLessThan = totalFoldersAtMost((FolderImpl) rootFolder, 100000, 0);
        outerMostDirectorySize = rootFolder.getSize();
        System.out.println("Rootfolder size: " + outerMostDirectorySize);
        availableSpace = 70000000 - outerMostDirectorySize;
        System.out.println("Availablespace size: " + availableSpace);
        needMoreThanThisToFreeUp = 30000000 - availableSpace;
        System.out.println("NeedMoreThanThisToFreeUp size: " + needMoreThanThisToFreeUp);
        Integer totalSize = 0;
        for (FolderImpl fi: smallFolders
             ) {
            totalSize += fi.getSize();
        }
        System.out.println("Total (part1): " + totalSize);

        Integer minimum = 70000000;
        for (FolderImpl fi: part2Folders
             ) {
            if (fi.getSize() < minimum && fi.getSize() >= needMoreThanThisToFreeUp)
            {
                minimum = fi.getSize();
            }
        }
        System.out.println("Total (part2): " + minimum);

        System.out.println("Ending " + inputLabel);
    }

    private Integer totalFoldersAtMost(FolderImpl inputFolder, int maxSize, int total) {

        if (inputFolder.getSize() <= maxSize)
        {
            total += inputFolder.getSize();
        }
        for (FolderContent fc : inputFolder.contents
        ) {
            if (fc.getClass() == FolderImpl.class)
            {
                if (((FolderImpl) fc).getSize() <= maxSize)
                {
                    total += ((FolderImpl) fc).getSize();
                }
                totalFoldersAtMost((FolderImpl) fc, maxSize, total);
            }
        }
        return total;
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        part1(recordsIn, inputLabel);


        System.out.println("Ending " + inputLabel);
    }

    public void addFolder(String folderName, FolderImpl parentFolder)
    {
        FolderImpl newFolder = new FolderImpl();
        newFolder.setName(folderName);
        newFolder.setParent(parentFolder);

        Boolean foundFolderExisting = false;
        for (FolderContent fi:parentFolder.contents
             ) {
            if (fi.getClass() == FolderImpl.class)
            {
                if (newFolder.equals(fi))
                {
                    foundFolderExisting = true;
                    break;
                }
            }
        }

        if (!foundFolderExisting)
        {
            //fileSystem.add(newFolder);
            parentFolder.contents.add(newFolder);
            listOfFolders.add(newFolder);
        }
    }

    private void addFile(String[] wordsInCommand, FolderImpl folder)
    {
        try {
            for (FolderContent fi:folder.contents
                 ) {
                if (fi.getClass() == FileContentImpl.class)
                {
                    if (((FileContentImpl)fi).getFilename() == wordsInCommand[1])
                    {
                        return;  // i.e. the file already exists in the folder, nothing to do
                    }
                }

            }

            // need to check current folder for same file name
            Integer parsedSize = Integer.parseInt(wordsInCommand[0]);
            FileContentImpl newFile = new FileContentImpl();
            newFile.setSize(parsedSize);
            newFile.setFilename(wordsInCommand[1]);
            folder.contents.add(newFile);
        }
        catch (Exception ex)
        {
            System.out.println("Add file: " + wordsInCommand[0] + ":" + wordsInCommand[1]+ ":" + wordsInCommand[2]);
            System.out.println("Error: adding file : " + wordsInCommand.toString() + " !! " + ex);
        }
    }

    private FolderImpl getFolder(String folderName, FolderImpl currentFolder)
    {
        for (FolderContent fi:currentFolder.contents
        ) {
            if (fi.getClass() == FolderImpl.class)
            {
                if (((FolderImpl)fi).getName().equals(folderName))
                {
                    return (FolderImpl)fi;  // i.e. the file already exists in the folder, nothing to do
                }
            }

        }
        return null;  // didn't find folder
    }

    private void printFileSystem(FolderImpl inputFolder, Integer spacer)
    {
        String blankSpace = " ";
        System.out.println(blankSpace.repeat(spacer) + "- " + inputFolder.getName() + "(dir) = " + inputFolder.getSize());
        spacer++;
        for (FolderContent fc : inputFolder.contents
             ) {
            if (fc.getClass() == FileContentImpl.class)
            {
                System.out.println(blankSpace.repeat(spacer) + "- " + ((FileContentImpl) fc).getFilename() + " (file, " + ((FileContentImpl) fc).getSize() + ")");
            }
            else {
                printFileSystem((FolderImpl) fc, spacer);
            }
        }

    }

    private Integer getSizeOfFolder(FolderImpl inputFolder)
    {
        String blankSpace = " ";
        Integer size = 0;

        for (FolderContent fc : inputFolder.contents
        ) {
            if (fc.getClass() == FileContentImpl.class)
            {
                size += ((FileContentImpl) fc).getSize();
            }
            else {
                size += getSizeOfFolder((FolderImpl) fc);
            }
        }

        return size;
    }

    private void setSizes(FolderImpl inputFolder)
    {
        inputFolder.setSize(getSizeOfFolder(inputFolder));
        for (FolderContent fc : inputFolder.contents
        ) {
            if (fc.getClass() == FolderImpl.class)
            {
                ((FolderImpl) fc).setSize(getSizeOfFolder((FolderImpl) fc));
                if (((FolderImpl) fc).getSize() <= 100000)
                {
                    smallFolders.add((FolderImpl) fc);
                }

                if (((FolderImpl) fc).getSize() >= needMoreThanThisToFreeUp)
                {
                    part2Folders.add((FolderImpl) fc);
                }

                setSizes((FolderImpl) fc);
            }
        }

    }

    }

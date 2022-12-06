package dev.opuspepper.AdventOfCodeDay6.objects;

import java.util.ArrayList;

public class DataStream {
    protected String inputString;

    public ArrayList<Character> getStartOfPacketMarker() {
        return startOfPacketMarker;
    }

    protected ArrayList<Character> startOfPacketMarker = new ArrayList<>();

    protected ArrayList<Character> startOfMessageMarker = new ArrayList<>();

    public Integer getPositionOfStartOfPacketMarker() {
        return positionOfStartOfPacketMarker;
    }

    protected Integer positionOfStartOfPacketMarker;

    protected Integer positionOfStartOfMessageMarker;


    public DataStream(String inputString) {
        this.inputString = inputString;

        detectStartOfPacketMarker();

        StringBuilder sb = new StringBuilder();
        for (Character c:startOfPacketMarker
             ) {
            sb.append(c);
        }

        positionOfStartOfPacketMarker = inputString.indexOf(sb.toString()) + 4;

        detectStartOfMessageMarker();

        sb = new StringBuilder();
        for (Character c:startOfMessageMarker
        ) {
            sb.append(c);
        }

        positionOfStartOfMessageMarker = inputString.indexOf(sb.toString()) + 14;
    }

    public ArrayList<Character> getStartOfMessageMarker() {
        return startOfMessageMarker;
    }

    public Integer getPositionOfStartOfMessageMarker() {
        return positionOfStartOfMessageMarker;
    }

    private void detectStartOfPacketMarker()
    {
        for (Character c:inputString.toCharArray()
             ) {
            startOfPacketMarker.add(c);
            if (startOfPacketMarker.size() > 4)
            {
                startOfPacketMarker.remove(0);
            }

            if (startOfPacketMarker.size() == 4)
            {
                Boolean didWeFindTheAnswer = isAnswer();
                if (didWeFindTheAnswer)
                {
                    return;
                }
            }
        }
    }

    private void detectStartOfMessageMarker()
    {
        for (Character c:inputString.toCharArray()
        ) {
            startOfMessageMarker.add(c);
            if (startOfMessageMarker.size() > 14)
            {
                startOfMessageMarker.remove(0);
            }

            if (startOfMessageMarker.size() == 14)
            {
                Boolean didWeFindTheAnswer = isAnswerMessage();
                if (didWeFindTheAnswer)
                {
                    return;
                }
            }
        }
    }

    private Boolean isAnswer()
    {
        for (Character c:startOfPacketMarker
             ) {
            if (countCharacterInCharArray(c) > 1)
            {
                return false;
            }
        }
        return true;
    }

    private Boolean isAnswerMessage()
    {
        for (Character c:startOfMessageMarker
        ) {
            if (countCharacterInCharArrayMessage(c) > 1)
            {
                return false;
            }
        }
        return true;
    }

    private Integer countCharacterInCharArray(Character inCharacter)
    {
        Integer countCharacter = 0;
        for (Character c :startOfPacketMarker
             ) {
            if (c == inCharacter)
            {
                countCharacter++;
            }
        }
        return countCharacter;
    }

    private Integer countCharacterInCharArrayMessage(Character inCharacter)
    {
        Integer countCharacter = 0;
        for (Character c :startOfMessageMarker
        ) {
            if (c == inCharacter)
            {
                countCharacter++;
            }
        }
        return countCharacter;
    }
}

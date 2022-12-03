package dev.opuspepper.AdventOfCodeDay3.objects;

public class Rucksack {
    public String getSack1() {
        return sack1;
    }

    public String getSack2() {
        return sack2;
    }

    public Rucksack(String inputString) {
        this.inputString = inputString;
        size = inputString.length();

        sack1 = inputString.substring(0,(size/2));
        sack2 = inputString.substring((size/2), (size));

        hasError = calculateIfError();

        sumOfPriorities = RucksackHelper.getRucksackHelper().calculateSumOfPriorities(getCharactersInBothSacks());
    }

    public String getInputString() {
        return inputString;
    }

    public int getSize() {
        return size;
    }

    public int getSumOfPriorities() {
        return sumOfPriorities;
    }

    protected String inputString;

    protected int size;

    protected int sumOfPriorities;

    protected String sack1;

    protected String sack2;

    protected Boolean hasError;

    protected StringBuilder charactersInBothSacks;

    public String getCharactersInBothSacks() {
        return charactersInBothSacks.toString();
    }

    public Boolean getHasError() {
        return hasError;
    }

    public Boolean calculateIfError()
    {
        Boolean hasError = false;
        charactersInBothSacks = new StringBuilder();
        for (Character c:sack1.toCharArray()) {
            if (sack2.contains(c.toString()))
            {
                hasError = true;
                if (charactersInBothSacks.toString().contains(c.toString()))
                {
                    continue;
                }
                charactersInBothSacks.append(c);
            }
        }
        return hasError;
    }
}

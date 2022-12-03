package dev.opuspepper.AdventOfCodeDay3.objects;

import java.util.ArrayList;

public class RucksackGroup {
    public ArrayList<Rucksack> groupRucksacks;

    protected Character badge;

    protected Integer priorityValueOfBadge;

    public Integer getPriorityValueOfBadge() {
        return priorityValueOfBadge;
    }

    public void setPriorityValueOfBadge(Integer priorityValueOfBadge) {
        this.priorityValueOfBadge = priorityValueOfBadge;
    }

    public RucksackGroup() {
        groupRucksacks = new ArrayList<>();
    }

    public void findBadge()
    {
        if (badge == null)
        {
            for (Character c : groupRucksacks.get(0).getInputString().toCharArray()) {
                if (groupRucksacks.get(1).getInputString().contains(c.toString()) &&
                    groupRucksacks.get(2).getInputString().contains(c.toString()))
                {
                    badge = c;
                    priorityValueOfBadge = RucksackHelper.getRucksackHelper().calculateSumOfPriorities(badge.toString());
                    return;  // Found badge no need to continue
                }
            }
        }
    }
}

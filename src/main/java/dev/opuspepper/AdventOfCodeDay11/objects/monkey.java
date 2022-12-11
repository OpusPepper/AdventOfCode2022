package dev.opuspepper.AdventOfCodeDay11.objects;

import java.util.ArrayList;

public class monkey {
    public Integer id;
    public ArrayList<Integer> items = new ArrayList<>();

    public boolean isTestTrue;

    public monkey(Integer id) {
        this.id = id;
    }
}

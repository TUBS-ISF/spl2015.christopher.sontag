package main;

import java.util.ArrayList;
import java.util.List;

import events.*;

public class Player {

    private static List<Illness> illnessList = new ArrayList<Illness>();

    public static List<Illness> getIllnessList() {
        return illnessList;
    }
}

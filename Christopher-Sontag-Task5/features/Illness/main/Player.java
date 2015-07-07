package de.isf.spl.christopher.sontag.adventure;

import java.util.ArrayList;
import java.util.List;

import de.isf.spl.christopher.sontag.adventure.events.Illness;
import de.isf.spl.christopher.sontag.adventure.events.extender.Polluter;

public class Player {

    private static List<Illness> illnessList = new ArrayList();

    public static List<Illness> getIllnessList() {
        return illnessList;
    }
}

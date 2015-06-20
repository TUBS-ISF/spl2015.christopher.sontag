package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.events.extender.Polluter;

public class Illness extends Polluter{

    public Illness() {
	super("Illness", 1);
    }

	public Illness(String string, int i) {
		super(string,i);
	}
    
}

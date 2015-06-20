package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.Player;
import de.isf.spl.christopher.sontag.adventure.events.extender.Polluter;

public abstract class Event {
	
	public abstract String talk();
	
	public abstract void handle(Player p);
	
	public abstract String getName();
	
	public abstract Polluter isAffecting();
}

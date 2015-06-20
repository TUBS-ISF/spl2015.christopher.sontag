package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.Player;
import de.isf.spl.christopher.sontag.adventure.events.extender.Polluter;
import de.isf.spl.christopher.sontag.adventure.inventory.Item;

public class Event3 extends Event {

	@Override
	public String talk() {
		return "Hocus Pocus Fidibus. Oh is someone there?";
	}

	@Override
	public void handle(Player p) {
		String line = Config.scanner.nextLine();
		if (line.contains("yes")) {
			System.out.println("Here is nothing. Go away.");
			System.out.println("You get an affect!");
		} else {
			System.out.println("Okay thats good ... I think....");
		}
	}

	@Override
	public String getName() {
		return "woman";
	}

	@Override
	public Polluter isAffecting() {
		return new Illness("Poison",10);
	}

}

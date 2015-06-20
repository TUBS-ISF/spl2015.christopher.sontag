package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.Player;
import de.isf.spl.christopher.sontag.adventure.inventory.Item;

public class Event2 extends Event {

	@Override
	public String talk() {
		return "Hi, my name is adam. I'm the son of the farmer nearby. Can you help me to get my bolt back?";
	}

	@Override
	public void handle(Player p) {
		String line = Config.scanner.nextLine();
		if (line.contains("yes")) {
			System.out.println("Thank you. Here for you:");
			System.out.println("You get a bread");
			Game.inventory.addItem(new Item("Bread", 10));
		} else {
			System.out.println("You are a *****");
			System.out.println("He ran away.");
		}
	}

	@Override
	public String getName() {
		return "Adam";
	}

	@Override
	public boolean isAffecting() {
		return false;
	}

}

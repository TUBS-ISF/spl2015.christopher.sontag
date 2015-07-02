package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.Player;

public class Event1 extends Event {

	@Override
	public String talk() {
		return "Hello stranger! Do you want something?";
	}

	@Override
	public void handle(Player p) {
		if (Config.random.nextBoolean()) {
			System.out.println("No I'm not the guy, they search...");
			System.out.println("Look a bee.");
			System.out.println("He runs away...");
			System.out.println("He lost his pocket with 100 gold.");
			Game.inventory.addGold(100);
		} else {
			System.out.println("You go away.");
		}
	}

	@Override
	public String getName() {
		return "stranger";
	}

	@Override
	public Polluter isAffecting() {
		return false;
	}

}

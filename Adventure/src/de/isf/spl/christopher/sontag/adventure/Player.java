package de.isf.spl.christopher.sontag.adventure;

import java.util.ArrayList;
import java.util.List;

import de.isf.spl.christopher.sontag.adventure.events.Illness;
import de.isf.spl.christopher.sontag.adventure.events.extender.Polluter;

public class Player {
    
    /*
     * The name of the player
     */
    private static String name;
    private static int stamina = 100, health = 100, lives = 1;
    private static List<Illness> illnessList = new ArrayList<>();
    
    Player(String name) {
	Player.name = name;
    }
    
    public static void printHeronaming() {
	System.out.println("But before we start, some short questions\nWhat is the name of the hero?");
	Player.name = Config.scanner.nextLine();
	System.out.println("Makes the hero sports?");
	String fitness = Config.scanner.nextLine();
	if (fitness.toUpperCase().equals("YES")) {
	    Player.stamina=100;
	} else {
	    Player.stamina=50;
	}
	System.out.println("How many lives has he?");
	Player.lives = Integer.parseInt(Config.scanner.nextLine());
	System.out.println("So let's start!");
    }
    
    public boolean takeDamage(Polluter polluter) {
	health -= polluter.getDamage();
	if (health<=0) {
	    lives--;
	}
	if (lives<=0) {
	    return false;
	}
	return true;
    }

    public static String getName() {
        return name;
    }

    public static int getStamina() {
        return stamina;
    }

    public static int getHealth() {
        return health;
    }

    public static int getLives() {
        return lives;
    }

    public static List<Illness> getIllnessList() {
        return illnessList;
    }
    
    public static String getPlayerStats() {
	return Player.name+" | "+Player.health+" Health | "+Player.stamina + " Stamina | "+Player.lives +" Lives";
    }
}

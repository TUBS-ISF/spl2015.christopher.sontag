package de.isf.spl.christopher.sontag.adventure;

import java.util.ArrayList;
import java.util.List;

import de.isf.spl.christopher.sontag.adventure.events.Illness;
import de.isf.spl.christopher.sontag.adventure.events.extender.Polluter;

public class Player {
    
    public static String name="Player";
    public static int stamina = 100, health = 100, lives = 1;
    public static List<Illness> illnessList = new ArrayList<>();
    
    Player(String name) {
	Player.name = name;
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

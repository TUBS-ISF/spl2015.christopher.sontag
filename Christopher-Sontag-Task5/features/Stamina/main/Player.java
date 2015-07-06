package main;

import events.extender.Polluter;

public class Player {

    private static int stamina = 100;

    public static int getStamina() {
        return stamina;
    }
    
    public static String getPlayerStats() {
	return original()+" | "+Player.stamina+" Stamina | ";
    }
}

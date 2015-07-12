package main;

import java.util.ArrayList;
import java.util.List;

import events.*;

public class Player {
    
    private static int health = 100;

    public boolean takeDamage(Polluter polluter) {
	health -= polluter.getDamage();
	if (health<=0) {
	    return false;
	}
	return true;
    }
    
    public static int getHealth() {
        return health;
    }

    public static String getPlayerStats() {
        return original()+Player.health+" Health | ";
    }
}

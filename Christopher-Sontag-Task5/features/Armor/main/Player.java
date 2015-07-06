package main;

import events.extender.*;

public class Player {

    private static int health = 100;
 
    public boolean takeDamage(Polluter polluter) {
	health -= polluter.getDamage();
	if (health<=0) {
	    System.exit(0);
	}
	return true;
    }

    public static int getHealth() {
        return health;
    }
    
    public static String getPlayerStats() {
	return original()+" | "+Player.health+" Health | ";
    }
}

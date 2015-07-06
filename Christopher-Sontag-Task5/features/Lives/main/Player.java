package main;

import events.extender.Polluter;

public class Player {

    private static int lives = 1;
    
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

    public static int getLives() {
        return lives;
    }
    
    public static String getPlayerStats() {
	return original()+" | "+Player.lives+" Lives | ";
    }
}

import de.isf.spl.christopher.sontag.adventure.*;

aspect AInventory {
	
	after(): execution(void Game.handleNextInput(..)) {
	    if (Game.curInput.equals("INVENTORY")) {
	        System.out.println(Game.inventory.toString());
	    }
	}
	
	before(): execution(void Game.printAtLosing()) {
	    System.out.println("You lost with:\n"+Game.inventory.toString());
	}
	
	before(): execution(void Game.handleAtGameStart()) {
            System.out.println("You can see your Inventory with Inventory");
	}

}
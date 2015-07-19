import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.inventory.Item;
import de.isf.spl.christopher.sontag.adventure.scenes.Path;

aspect ADig {
	
    after(): execution(void Game.handleNextInput(..)) {
        if (Game.curInput.equals("DIG")) {
            if (Game.curScene instanceof Path) {
                if (((Path) Game.curScene).isDigable()) {
                for (Item i : Game.inventory.getItemList()) {
                    if (i.getName()=="Schaufel") {
                        if (((Path)Game.curScene).dig()) {
                            Game.inventory.remove(i);
                        }
                    }
                }
                if (!((Path) Game.curScene).isDigable()) {
                    System.out.println("You don't own a shovel. Buy one.");
                }
                } else {
                    System.out.println("You can't dig twice.");
                }
            }
        }
    }
    
    before(): execution(void Game.handleAtGameStart()) {
        System.out.println("You can see your Dig with DIG");
    }

}
/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

import java.util.Random;

import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.events.Quest;
import de.isf.spl.christopher.sontag.adventure.events.Quest.QuestType;

/**
 * @author Christopher
 *
 */
public class Beach extends Path {
    
    public Beach() {
	super("Beach", "A wonderful beach");
    }
    
    @Override
    public boolean handleScene() {
	// TODO Auto-generated method stub
	return false;
    }
    
    @Override
    public boolean handleQuests() {
	for (Quest q : Game.questList) {
	    if (q.questType == QuestType.GOTO)
		if (this.name == q.scene.getName()) {
		    System.out.println("You have finished the Quest:\n" + q.toStringCompact()
			    + "\nYou get nothing.");
		    return true;
		}
	    
	}
	return false;
    }
    
    @Override
    public String getSpecialCommands() {
        String ret = "";
        return ret;
    }

    @Override
    public boolean dig() {
        this.isDigable = false;
        Random r = new Random();
        System.out.println("Joho and a bottle of rum.");
        if (r.nextBoolean()) {
            int gold = (r.nextInt(200)+10);
            System.out.println("You have found a chest with "+gold+ " gold");
            Game.inventory.addGold(gold);
            return false;
        }
        System.out.print("You should drink much less rum. You have no luck");
        if (r.nextBoolean()) {
            System.out.println(" and you destroyed your shovel. You must buy a new one.");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
    
}

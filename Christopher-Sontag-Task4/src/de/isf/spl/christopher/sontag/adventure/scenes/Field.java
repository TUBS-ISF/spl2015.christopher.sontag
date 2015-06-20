/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.events.Quest;
import de.isf.spl.christopher.sontag.adventure.events.Quest.QuestType;

/**
 * @author Christopher
 *
 */
public class Field extends Path {
    
    public Field() {
	super("Field", "A wide field!");
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
    
}

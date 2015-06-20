/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.events.Hint;
import de.isf.spl.christopher.sontag.adventure.events.Quest;
import de.isf.spl.christopher.sontag.adventure.events.Quest.QuestType;

/**
 * @author Christopher
 *
 */
public class Town extends Structure {
    
    public Town() {
	super("Town", "A little town. I hope someone will trade with me.");
    }
    
    @Override
    public boolean handleScene() {
	if (!this.canSpecialEvent()) {
	    switch (Config.random.nextInt(4)) {
		case 0:
		    Quest quest = new Quest();
		    System.out.println(quest.talk());
		    String answer = Config.scanner.nextLine();
		    if (answer.toUpperCase().equals("ACCEPT")) {
			Game.questList.add(quest);
			System.out.println("Thank you!");
		    } else {
			System.out.println("Ohhh...");
		    }
		    this.specialEvent = true;
		    return true;
		case 1:
		    Hint hint = new Hint();
		    System.out.println(hint.talk());
		    this.specialEvent = true;
		    return true;
		case 2:
		case 3:
		    return false;
	    }
	}
	return false;
    }
    
    @Override
    public boolean handleQuests() {
	for (Quest q : Game.questList) {
	    if (q.questType == QuestType.GOTO)
		if (this.name == q.scene.getName()) {
		    System.out.println("You have finished the Quest:\n" + q.toStringCompact()
			    + "\nYou get 10 gold");
		    Game.inventory.addGold(10);
		    return true;
		}
	    
	}
	return false;
    }
}

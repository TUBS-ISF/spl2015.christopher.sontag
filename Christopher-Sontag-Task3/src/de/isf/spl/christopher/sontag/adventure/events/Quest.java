package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.events.extender.Talking;
import de.isf.spl.christopher.sontag.adventure.inventory.Item;
import de.isf.spl.christopher.sontag.adventure.scenes.Scene;

public class Quest extends Talking{
    
    public enum QuestType {HUNT,COLLECT,GOTO}
    
    public QuestType questType;
    public Item item;
    //public Monster monster;
    public Scene scene;
    public int remainingTimes;

    public Quest() {
	super("","");
	switch(Config.random.nextInt(3)) {
	    case 0:
		this.name = "Trader";
		this.questType = QuestType.COLLECT;
		this.remainingTimes = Config.random.nextInt(10);
		this.description = "On the marketplace a trader comes to you and say:";
		this.item = new Item("Das unzerbrechliche Schwert", 1);
		break;
	    case 1:
		this.name = "Major";
		this.questType = QuestType.HUNT;
		this.remainingTimes = Config.random.nextInt(10);
		this.description = "";
	    case 2:
		this.name = "little Girl";
		this.questType = QuestType.GOTO;
		this.remainingTimes = 1;
		this.description = "";
		this.scene = Game.scenesList.get(Config.random.nextInt(Game.scenesList.size()));
	}
    }
    
    @Override
    public String toString() {
	String ret = "You find a " + this.name + ":\n" + this.description + "\n";
	switch(this.questType) {
	    case COLLECT:
		ret += "Can you collect " + this.remainingTimes + item.getName();
		break;
	    case GOTO:
		ret += "Can you go to " + scene.getName();
		break;
	    case HUNT:
		ret += "Can you hunt " + this.remainingTimes;// + monster.getName();
		break;
	}
	ret += "\nDo you accept it? ";
	return ret;
    }
    
    public String toStringCompact() {
	String ret = "";
	switch(this.questType) {
	    case COLLECT:
		ret += "Collect " + this.remainingTimes + item.getName();
		break;
	    case GOTO:
		ret += "Go to " + scene.getName();
		break;
	    case HUNT:
		ret += "Hunt " + this.remainingTimes;// + monster.getName();
		break;
	}
	return ret;
    }
    
}

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
public class Mountain extends Path {
    
    public Mountain() {
        super("Mountain", "A big mountain is in my way.");
    }
    
    @Override
    public boolean handleScene() {
        // TODO Auto-generated method stub
        return false;
    }
    
    //#ifdef Quests
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
    
    //#endif
    
    @Override
    public String getSpecialCommands() {
        String ret = "";
        //#ifdef Chests
        ret += "You can dig here with the command dig.\n";
        //#endif
        return ret;
    }
    
    //#ifdef Chests
    @Override
    public boolean dig() {
        this.isDigable = false;
        Random r = new Random();
        if (r.nextBoolean()&&r.nextBoolean()&&r.nextBoolean()) {
            int gold = (r.nextInt(200) + 10);
            System.out.println("You have found a gold vene. You dig and dig. You are coming home with " + gold + " gold");
            Game.inventory.addGold(gold);
            return false;
        }
        if (r.nextBoolean()) {
            System.out.println("Your shovel broke...\nYou must buy a new one.");
            return true;
        }
        return false;
    }
    
    //#endif
    
}

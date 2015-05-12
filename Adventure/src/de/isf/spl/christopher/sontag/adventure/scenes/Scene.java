/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

import java.util.List;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.Game;
import de.isf.spl.christopher.sontag.adventure.events.Hint;
import de.isf.spl.christopher.sontag.adventure.events.Quest;

/**
 * @author Christopher
 *
 */
public abstract class Scene {
    
    protected String name = "Scene";
    protected String description = "";
    protected boolean west = true;
    protected boolean east = true;
    protected boolean north = true;
    protected boolean south = true;
    
    public Scene(String name, String settingsText) {
	this.name = name;
	this.description = settingsText;
	setUpWays();
    }
    
    public void setUpWays() {
	this.west = Config.random.nextBoolean();
	this.east = Config.random.nextBoolean();
	this.north = Config.random.nextBoolean();
	this.south = Config.random.nextBoolean();
    }
    
    @Override
    public String toString() {
	String ret = "You enter " + this.name + ":\n" + this.description;
	return ret;
    }
    
    public String enter() {
	return toString();
    }
    
    public abstract boolean handleQuests();
    
    public abstract boolean handleScene();
    
    public String chooseWay() {
	String ret = "What do you want: ";
	if (this.west)
	    ret += "WEST, ";
	if (this.east)
	    ret += "EAST, ";
	if (this.north)
	    ret += "NORTH, ";
	if (this.south )
	    ret += "SOUTH, ";
	ret += "MAP, QUESTS, EXIT";
	return ret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean canWest() {
        return west;
    }

    public boolean canEast() {
        return east;
    }

    public boolean canNorth() {
        return north;
    }

    public boolean canSouth() {
        return south;
    }
    
}

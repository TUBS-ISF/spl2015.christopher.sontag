/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

/**
 * @author Christopher
 *
 */
public abstract class Structure extends Scene {
    
    	/*
    	 * Indicates if a special event like a quest was already handled 
    	 */
    	protected boolean specialEvent = false;

	public Structure(String name, String settingsText) {
		super(name, settingsText);
	}

	public boolean canSpecialEvent() {
	    return specialEvent;
	}
	
}

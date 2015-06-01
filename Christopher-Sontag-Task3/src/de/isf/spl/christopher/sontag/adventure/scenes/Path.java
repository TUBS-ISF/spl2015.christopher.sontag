/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

/**
 * @author Christopher
 *
 */
public abstract class Path extends Scene{

	public Path(String name, String settingsText) {
		super(name, settingsText);
	}
	
	//#ifdef Chests
	public abstract boolean dig();
	//#endif
}

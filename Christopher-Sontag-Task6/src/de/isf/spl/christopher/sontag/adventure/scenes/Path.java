/**
 * 
 */
package de.isf.spl.christopher.sontag.adventure.scenes;

/**
 * @author Christopher
 *
 */
public abstract class Path extends Scene {
    
    protected boolean isDigable = true;
    
    public Path(String name, String settingsText) {
        super(name, settingsText);
    }
    
    // #ifdef Chests
    /**
     * @return bool if shovel is destroyed
     */
    public abstract boolean dig();
    
    public boolean isDigable() {
        return isDigable;
    }
    
    public void setDigable(boolean isDigable) {
        this.isDigable = isDigable;
    }
    // #endif
}

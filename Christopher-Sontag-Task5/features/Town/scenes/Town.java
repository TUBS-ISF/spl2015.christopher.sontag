/**
 * 
 */
package scenes;

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
	return false;
    }

    @Override
    public String getSpecialCommands() {
        return "";
    }
}

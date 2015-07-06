/**
 * 
 */
package scenes;

/**
 * @author Christopher
 *
 */
public class House extends Structure {
    
    public House() {
	super("House", "A little House in the Forest... Mysterious!");
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

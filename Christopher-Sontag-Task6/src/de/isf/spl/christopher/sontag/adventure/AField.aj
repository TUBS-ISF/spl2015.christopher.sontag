import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.scenes.Field;

aspect AField {
	
	after(): call(void Game.addScenes()) {
	    Game.scenesList.add(new Field());
	}

}
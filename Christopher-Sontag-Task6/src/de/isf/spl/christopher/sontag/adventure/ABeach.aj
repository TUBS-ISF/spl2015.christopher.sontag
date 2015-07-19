import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.scenes.Beach;

aspect ABeach {
	
	after(): call(void Game.addScenes()) {
	    Game.scenesList.add(new Beach());
	}

}
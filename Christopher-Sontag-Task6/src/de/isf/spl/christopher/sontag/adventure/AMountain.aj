import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.scenes.Mountain;

aspect AMountain {
	
	after(): call(void Game.addScenes()) {
	    Game.scenesList.add(new Mountain());
	}

}
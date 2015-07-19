import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.scenes.Town;

aspect ATown {
	
	after(): call(void Game.addScenes()) {
	    Game.scenesList.add(new Town());
	}

}
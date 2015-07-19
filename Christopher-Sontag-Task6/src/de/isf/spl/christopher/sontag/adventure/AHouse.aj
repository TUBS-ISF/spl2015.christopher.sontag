import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.scenes.House;

aspect AHouse {
	
	after(): call(void Game.addScenes()) {
	    Game.scenesList.add(new House());
	}

}
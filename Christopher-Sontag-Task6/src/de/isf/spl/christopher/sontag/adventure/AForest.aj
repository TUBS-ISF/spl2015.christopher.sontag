import de.isf.spl.christopher.sontag.adventure.*;
import de.isf.spl.christopher.sontag.adventure.scenes.Forest;

aspect AForest {
	
	after(): call(void Game.addScenes()) {
	    Game.scenesList.add(new Forest());
	}

}
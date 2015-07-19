import de.isf.spl.christopher.sontag.adventure.*;

aspect AIntroduction {
	
	after(): call(void Game.handleAtGameStart()) {
	    Introduction.printIntroduction();
	}

}
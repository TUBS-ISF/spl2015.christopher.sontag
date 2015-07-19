import de.isf.spl.christopher.sontag.adventure.*;

aspect AQuest {
	
	after(): call(void Game.handleAtTurnEnd()) {
	    if (!Game.curScene.handleQuests()) {
               Game.curScene.handleScene();
            }
	};
	
	after(): execution(void Game.handleNextInput(..)) {
	    if (Game.curInput.equals("QUEST")) {
	        System.out.println("You have actual the following quests:");
                for (de.isf.spl.christopher.sontag.adventure.events.Quest q : Game.questList) {
                    System.out.println(q.toStringCompact());
                }
	    }
	}
	
	before(): execution(void Game.handleAtGameStart()) {
            System.out.println("You can see your Quests with Quest");
        }

}
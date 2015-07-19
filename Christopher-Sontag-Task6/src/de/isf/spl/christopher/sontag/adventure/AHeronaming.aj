import de.isf.spl.christopher.sontag.adventure.*;

aspect AHeronaming {
	
	after(): call(void Game.handleAtGameStart()) {
		System.out.println("But before we start, some short questions\nWhat is the name of the hero?");
		Player.name = Config.scanner.nextLine();
		System.out.println("Makes the hero sports?");
		String fitness = Config.scanner.nextLine();
		if (fitness.toUpperCase().equals("YES")) {
		    Player.stamina=100;
		} else {
		    Player.stamina=50;
		}
		System.out.println("How many lives has he?");
		Player.lives = Integer.parseInt(Config.scanner.nextLine());
		System.out.println("So let's start!");
	}

}
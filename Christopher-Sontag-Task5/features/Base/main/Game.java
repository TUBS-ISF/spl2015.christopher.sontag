package main;

import java.util.ArrayList;
import java.util.List;
import scenes.*;

public class Game {
    
    /*
     * The list of possible scenes
     */
    public static List<Scene> scenesList = new ArrayList<Scene>();
    
    /*
     * The map of the game
     */
    public static Scene[][] sceneMap = new Scene[Config.mapSize][Config.mapSize];
    
    /*
     * The position of the player
     */
    private static int posX = 0, posY = 0;
    
    /*
     * The current input
     */
    private static String curInput = "";
    
    /*
     * The current scene
     */
    private static Scene curScene;
    
    public static void main(String[] args) {
	
	addScenes();
	
	// Generate the map
	for (int i = 0; i < Config.mapSize; i++) {
	    for (int j = 0; j < Config.mapSize; j++) {
		int rand = Config.random.nextInt(scenesList.size());
		Scene scene = scenesList.get(rand);
		sceneMap[i][j] = scene;
	    }
	}
	
	if (Config.DEBUG) {
	    printMap();
	}
	
	curScene = sceneMap[posX][posY];
	
	handleAtGameStart();
	
	
	// Print actual Scene
        System.out.println(curScene.enter());
        
	
	//Handle user input 
	while (!curInput.toUpperCase().equals("EXIT")) {
	    curInput = curInput.toUpperCase();
	    handleNextInput(curInput,curScene);
	    
	    if (curInput.equals("NORTH") || curInput.equals("SOUTH") || curInput.equals("WEST")
		    || curInput.equals("EAST")) {
		
		if (posX < 0)
		    posX = (posX + Config.mapSize);
		if (posY < 0)
		    posY = (posY + Config.mapSize);
		if (posX > Config.mapSize - 1)
		    posX = posX % Config.mapSize;
		if (posY > Config.mapSize - 1)
		    posY = posY % Config.mapSize;
		curScene = sceneMap[posX][posY];
		
		// Print actual Scene
                System.out.println(curScene.enter());
		
		// Handle if all ways are blocked
		if (!curScene.canEast() && !curScene.canNorth() && !curScene.canSouth()
		        && !curScene.canWest()) {
		    System.out.println("You get lost in " + curScene.getName() + ".\nYou lost!");
		    break;
		}
		
		handleAtTurnEnd();
	    }
	    // Get next Step
	    printAtTurnEnd();
	}
	//Exit message
	printAtLosing();
    }
    
    private static void addScenes() {
    }
    
    private static void handleAtGameStart() {
        System.out.println("To view Map: type in MAP");
        System.out.println("To exit: type in EXIT\n\n");
    }
    
    private static void handleNextInput(String curInput, Scene curScene) {
        if (curInput.equals("WEST")) {
            if (curScene.canWest())
                    posY -= 1;
        }
        if (curInput.equals("EAST")) {
            if (curScene.canWest())
                    posY += 1;
        }
        if (curInput.equals("SOUTH")) {
            if (curScene.canWest())
                    posX += 1;
        }
        if (curInput.equals("NORTH")) {
            if (curScene.canWest())
                    posX -= 1;
        }
        if (curInput.equals("MAP")) {
            printMap();
        }
    }
    
    private static void handleAtTurnEnd() {
        
    }
    
    private static void printAtTurnEnd() {
        System.out.println(curScene.chooseWay());
        System.out.println(curScene.getSpecialCommands());
        curInput = Config.scanner.nextLine();
    }
    
    private static void printAtLosing() {
        System.out.println("Exit:");
    }
    
    /**
     * Prints the Map of the Game
     */
    public static void printMap() {
	for (int i = 0; i < Config.mapSize; i++) {
	    for (int j = 0; j < Config.mapSize; j++) {
		if (posX == i && posY == j) {
		    System.out.print(sceneMap[i][j].getName() + "(P)" + " | ");
		} else {
		    System.out.print(sceneMap[i][j].getName() + " | ");
		}
	    }
	    System.out.print("\n");
	}
    }
    
}

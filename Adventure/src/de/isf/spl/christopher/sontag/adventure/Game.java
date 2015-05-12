package de.isf.spl.christopher.sontag.adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import de.isf.spl.christopher.sontag.adventure.events.Hint;
import de.isf.spl.christopher.sontag.adventure.events.Quest;
import de.isf.spl.christopher.sontag.adventure.inventory.Inventory;
import de.isf.spl.christopher.sontag.adventure.scenes.Beach;
import de.isf.spl.christopher.sontag.adventure.scenes.Field;
import de.isf.spl.christopher.sontag.adventure.scenes.Forest;
import de.isf.spl.christopher.sontag.adventure.scenes.House;
import de.isf.spl.christopher.sontag.adventure.scenes.Mountain;
import de.isf.spl.christopher.sontag.adventure.scenes.Path;
import de.isf.spl.christopher.sontag.adventure.scenes.Scene;
import de.isf.spl.christopher.sontag.adventure.scenes.Structure;
import de.isf.spl.christopher.sontag.adventure.scenes.Town;

public class Game {
    
    /*
     * The Inventory
     */
    public static Inventory inventory = new Inventory();
    
    /*
     * The list of possible scenes
     */
    public static List<Scene> scenesList = new ArrayList<>();
    
    /*
     * The list of actual Quests
     */
    public static List<Quest> questList = new ArrayList<>();
    
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
	
	scenesList.add(new Field());
	
	for (String arg : args) {
	    switch (arg) {
		case "-Forest":
		    scenesList.add(new Forest());
		    break;
		case "-Beach":
		    scenesList.add(new Beach());
		    break;
		case "-Mountain":
		    scenesList.add(new Mountain());
		    break;
		case "-Town":
		    scenesList.add(new Town());
		    break;
		case "-House":
		    scenesList.add(new House());
		    break;
	    }
	}
	
	// Generate the map
	for (int i = 0; i < Config.mapSize; i++) {
	    for (int j = 0; j < Config.mapSize; j++) {
		int rand = Config.random.nextInt(scenesList.size());
		Scene scene = scenesList.get(rand);
		if (scene instanceof Forest)
		    sceneMap[i][j] = new Forest();
		if (scene instanceof Field)
		    sceneMap[i][j] = new Field();
		if (scene instanceof Beach)
		    sceneMap[i][j] = new Beach();
		if (scene instanceof Mountain)
		    sceneMap[i][j] = new Mountain();
		if (scene instanceof Town)
		    sceneMap[i][j] = new Town();
		if (scene instanceof House)
		    sceneMap[i][j] = new House();
	    }
	}
	
	if (Config.DEBUG) {
	    printMap();
	}
	
	curScene = sceneMap[posX][posY];
	
	//Print Introduction
	Introduction.printIntroduction();
	//Player.printHeronaming();
	
	if(Config.DEBUG) {
	    System.out.println("Player-Stats: "+Player.getPlayerStats());
	}
	//Print all important Keys
	System.out.println("To view Quests: type in QUESTS");
	System.out.println("To view Map: type in MAP");
	System.out.println("To exit: type in EXIT\n\n");
	
	//Handle user input 
	while (!curInput.toUpperCase().equals("EXIT")) {
	    curInput = curInput.toUpperCase();
	    switch (curInput) {
		case "WEST":
		    if (curScene.canWest())
			posY -= 1;
		    break;
		case "EAST":
		    if (curScene.canEast())
			posY += 1;
		    break;
		case "SOUTH":
		    if (curScene.canSouth())
			posX += 1;
		    break;
		case "NORTH":
		    if (curScene.canNorth())
			posX -= 1;
		    break;
		case "QUESTS":
		    System.out.println("You have actual the following quests:");
		    for (Quest q : questList) {
			System.out.println(q.toStringCompact());
		    }
		    break;
		case "MAP":
		    printMap();
		    break;
		case "INVENTORY":
		    System.out.println(inventory.toString());
		    break;
	    }
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
		
		// Handle quests and if you finished a quest you dont get a new one this time.
		if (!curScene.handleQuests()) {
		    //Handle Scene specific things
		    curScene.handleScene();
		}
	    }
	    
	    // Get next Step
	    System.out.println(curScene.chooseWay());
	    curInput = Config.scanner.nextLine();
	}
	//Exit message
	System.out.println("You lost with:\n"+inventory.toString());
	System.out.println("Your personal Statistics: "+Player.getPlayerStats());
	System.out.println("\n\n Exit.");
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

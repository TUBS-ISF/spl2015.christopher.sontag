package main;

import java.util.ArrayList;
import java.util.List;

import main.Player;
import main.Config;

public class Player {
    
    private static String name = "Player";
    
    Player(String name) {
        Player.name = name;
    }

    public static void printHeronaming() {
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
    
    public static String getName() {
        return name;
    }
}

package de.isf.spl.christopher.sontag.adventure.events;

import de.isf.spl.christopher.sontag.adventure.Config;
import de.isf.spl.christopher.sontag.adventure.events.extender.Talking;

public class Hint extends Talking {

    public Hint() {
	super("","");
	switch(Config.random.nextInt(3)) {
	    case 0:
		this.name = "Trader";
		this.description = "The Trader give you a hint: When you can trade, you can trade.";
		break;
	    case 1:
		this.name = "Major";
		this.description = "The Major gives you a hint: Don't come near to monsters. They are evil!";
	    case 2:
		this.name = "little Girl";
		this.description = "The little girl gives you a hint: Always eat a little snack :)";
	}
    }
    
}

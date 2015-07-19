package de.isf.spl.christopher.sontag.adventure.events.extender;

public abstract class Polluter {
    protected String name = "Polluter";
    protected int damage = 0;
    
    public Polluter(String name, int damage) {
	this.name = name;
	this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    } 
    
}

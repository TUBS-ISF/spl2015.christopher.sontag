package de.isf.spl.christopher.sontag.adventure.inventory;

public class Item {
    
    private String name;
    private int value;
    
    public Item(String name, int value) {
	this.name = name;
	this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
	return this.name + "|" + this.value;
    }
    
}

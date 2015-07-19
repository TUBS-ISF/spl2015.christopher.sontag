package de.isf.spl.christopher.sontag.adventure.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    
    private List<Item> itemList = new ArrayList<>();
    private int gold=0;
    
    public Inventory() {
    }

    public List<Item> getItemList() {
        return itemList;
    }
    
    public int getGold() {
	return gold;
    }

    public void setInventory(List<Item> inventory) {
        this.itemList = inventory;
    }
    
    public void addItem(Item i) {
	this.itemList.add(i);
    }
    
    public void addGold(int i) {
	this.gold += i;
    }
    
    public int size() {
	return itemList.size();
    }
    
    public void remove(Item i) {
	this.itemList.remove(i);
    }
    
    @Override
    public String toString() {
	String ret = "You have the following items in your inventory:\n";
	for(Item i:itemList) {
	    ret += i.toString()+"\n";
	}
	ret += "You have also "+gold+ " Gold.";
	return ret;
    }
    
}

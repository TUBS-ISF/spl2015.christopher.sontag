package de.isf.spl.christopher.sontag.adventure.events.extender;

public abstract class Talking {
    
    protected String name = "Talking";
    protected String description = "";
    
    public Talking(String name, String description) {
	this.name = name;
	this.description = description;
    }
    
    @Override
    public String toString() {
	String ret = "You find a " + this.name + ":\n" + this.description + "\n";
	return ret;
    }
    
    public String talk() {
	return toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}

package dragonball.model.character;

import java.io.Serializable;

abstract public class Character implements Serializable {
	private String name;
	public Character(String n)
	{
		name=n;
	}
	public String getName() {
		return name;
	}
	
	
	
}

package domain.models;

import java.util.ArrayList;

public class Competition {
	private String name;

	/**
	 * 
	 * @param name The name of the competition (Ex. Jupiler Pro League)
	 */
	public Competition(String name) {
		setName(name);
	}
	
	/**
	 * The name of the competition
	 * @return The name of the competition
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name to a given value
	 * @param name
	 * @throws IllegalArgumentException When the name given is either null or empty
	 */
	public void setName(String name) throws IllegalArgumentException {
		if(name == null) {
			throw new IllegalArgumentException("The name cannot be null");
		}
		if(name.trim().isEmpty()) {
			throw new IllegalArgumentException("The name cannot be empty");
		}
		this.name = name;
	}
}

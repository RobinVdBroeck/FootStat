package be.footstat.domain.models;

import java.util.ArrayList;

public class Competition {
	private String name;
	private ArrayList<Team> teams;
	private ArrayList<Match> matches; 
	
	/**
	 * 
	 * @param name The name of the competition (Ex. Jupiler Pro League)
	 */
	public Competition(String name) {
		this.setName(name);
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

	/**
	 * Get a list of all the teams in the competition
	 * @return The list of all the teams in the competition
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	/**
	 * Override all the teams with the given
	 * @param teams
	 * @throws IllegalArguementException When teams is null
	 */
	public void setTeams(ArrayList<Team> teams) throws IllegalArgumentException {
		if(teams == null) {
			throw new IllegalArgumentException();
		}
		this.teams = teams;
	}
	
	/**
	 * Add a team to the competition
	 * @param team
	 * @throws IllegalArguementException When team is null
	 */
	public void addTeam(Team team) {
		if(team == null) {
			throw new IllegalArgumentException();
		}
		this.teams.add(team);
	}

	/**
	 * Get a list of all matches 
	 * @return the matches
	 */
	public ArrayList<Match> getMatches() {
		return matches;
	}

	/**
	 * Override all the matches with the given
	 * @param matches The new matches
	 * @throws IllegalArguementException When matches is null
	 */
	public void setMatches(ArrayList<Match> matches) {
		if(matches == null) {
			throw new IllegalArgumentException();
		}
		this.matches = matches;
	}
	
	/**
	 * Add a match to the competition
	 * @param match The match to add
	 * @throws IllegalArguementException When team is null
	 */
	public void AddMatch(Match match) {
		if(match == null) {
			throw new IllegalArgumentException();
		}
		this.matches.add(match);
	}
}

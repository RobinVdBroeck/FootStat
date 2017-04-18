package be.footstat.domain.models;

public class Team {
	private Competition competition;
	private String name;
	
	public Team(Competition competion, String name) {
		this.setCompetition(competion);
		this.setName(name);
	}
	
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		if(competition == null) throw new IllegalArgumentException();
		this.competition = competition;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null) throw new IllegalArgumentException();
		this.name = name;
	}
	

}

package domain.models;

public class Match {
	private Team homeTeam;
	private Team awayTeam;
	private int homeScore;
	private int outScore;
	
	public Match(Team homeTeam, Team awayTeam, int homeScore, int outScore) {
		this.setHomeTeam(homeTeam);
		this.setAwayTeam(awayTeam);
		this.setHomeScore(homeScore);
		this.setOutScore(outScore);
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		if(homeTeam == null || homeTeam == this.getAwayTeam()) {
			throw new IllegalArgumentException();
		}
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		if(awayTeam == null) {
			throw new IllegalArgumentException();
		}
		this.awayTeam = awayTeam;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getOutScore() {
		return outScore;
	}

	public void setOutScore(int outScore) {
		this.outScore = outScore;
	}
	
	/** 
	 * @return Array with two elements. First element equals the points the home team received for the match.
	 * The second element than equals the away team received for the match.
	 */
	public int[] calculatePoints() {
		if(this.getHomeScore() > this.getOutScore()) {
			return new int[] {3, 0};
		}
		if (this.getHomeScore() == this.getOutScore()) {
			return new int[] {1, 1};
		}
		return new int[] {0, 3};
		
	}
}

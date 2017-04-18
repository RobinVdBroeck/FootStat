package be.footstat.domain.models;

public class Match {
	private Team homeTeam;
	private Team awayTeam;
	private short homeScore;
	private short outScore;
	
	public Match(Team homeTeam, Team awayTeam, short homeScore, short outScore) {
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

	public short getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(short homeScore) {
		this.homeScore = homeScore;
	}

	public short getOutScore() {
		return outScore;
	}

	public void setOutScore(short outScore) {
		this.outScore = outScore;
	}
	
	/** 
	 * @return Array with two elements. First element equals the points the home team received for the match.
	 * The second element than equals the away team received for the match.
	 */
	public short[] calculatePoints() {
		if(this.getHomeScore() > this.getOutScore()) {
			return new short[] {3, 0};
		}
		if (this.getHomeScore() == this.getOutScore()) {
			return new short[] {1, 1};
		}
		return new short[] {0, 3};
		
	}
}

package domain.db;

import domain.models.Competition;
import domain.models.Match;
import domain.models.Team;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InMemoryDatabase {
    private ArrayList<Competition> competitions;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    InMemoryDatabase() {
        competitions = new ArrayList<Competition>();
        teams = new ArrayList<Team>();
        matches = new ArrayList<Match>();
    }

    boolean isCompetitionInDatabase(Competition competition) {
        return getAllCompetitions().contains(competition);
    }

    boolean isTeamInDatabase(Team team) {
        return getAllTeams().contains(team);
    }

    void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    void addTeam(Team team) {
        Competition competition = team.getCompetition();
        if(!isCompetitionInDatabase(competition)) {
            throw new IllegalStateException("The competition is not in the database");
        }
        teams.add(team);
    }

    void addMatch(Match match) {
        Team[] sides = new Team[] {match.getHomeTeam(), match.getAwayTeam()};

        for(Team team: sides) {
            if(!isTeamInDatabase(team)) {
                throw new IllegalStateException("The team is not in the database");
            }
        }

        matches.add(match);
    }

    ArrayList<Competition> getAllCompetitions() {
        return competitions;
    }

    ArrayList<Team> getAllTeams() {
        return teams;
    }

    ArrayList<Match> getAllMatches() {
        return matches;
    }
}

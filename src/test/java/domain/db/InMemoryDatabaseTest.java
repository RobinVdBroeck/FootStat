package domain.db;

import domain.models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryDatabaseTest {
    private InMemoryDatabase instance;

    @Before
    public void setup() {
        instance = new InMemoryDatabase();
    }

    @Test
    public void AddCompetitionShouldAddAnCompetition() {
        Competition jpl = new Competition("Jupiler Pro League");

        instance.addCompetition(jpl);

        assertEquals(instance.getAllCompetitions().size(), 1);
    }

    @Test
    public void AddTeamShouldAddATeam() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl, "Anderlecht");

        instance.addCompetition(jpl);
        instance.addTeam(anderlecht);

        assertEquals(instance.getAllTeams().size(), 1);
    }

    @Test(expected = IllegalStateException.class)
    public void AddTeamShouldThrowAnIllegalStateExceptionWhenTheCompetitionIsNotAdded() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl, "Anderlecht");

        instance.addTeam(anderlecht);
    }

    @Test
    public void AddMatchShouldAddAMatch() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl, "Anderlecht");
        Team brugge = new Team(jpl, "Brugge");
        Match match = new Match(anderlecht, brugge, 0, 0);

        instance.addCompetition(jpl);
        instance.addTeam(anderlecht);
        instance.addTeam(brugge);
        instance.addMatch(match);

        assertEquals(instance.getAllMatches().size(), 1);
    }

    @Test(expected = IllegalStateException.class)
    public void AddMatchShouldThrowAnIllegalStateExceptionWhenAtleastOneOfTheTeamsThatPlayedIsNotInTheDatabase() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl, "Anderlecht");
        Team brugge = new Team(jpl, "Brugge");
        Match match = new Match(anderlecht, brugge, 0, 0);

        instance.addCompetition(jpl);
        instance.addTeam(anderlecht);
        instance.addMatch(match);
    }
}

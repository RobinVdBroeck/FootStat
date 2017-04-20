package domain.db;

import domain.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InMemoryDatabaseTest {
    private InMemoryDatabase instance;

    @Before
    public void setup() {
        // Make a new database every test to start clean
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

        assertEquals(1, instance.getAllTeams().size());
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

        assertEquals(1, instance.getAllMatches().size());
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

    @Test
    public void GetAllTeamsInACompetitionShouldReturnAnEmptyArrayListWhenThereAreNoTeams() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl,"Anderlecht");

        instance.addCompetition(jpl);

        assertEquals(0, instance.getAllTeamsInACompetition(jpl).size());
    }

    @Test
    public void GetAllTeamsInACompetitionShouldReturnTheCorrectTeams() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl,"Anderlecht");
        Team brugge = new Team(jpl, "Brugge");

        instance.addCompetition(jpl);
        instance.addTeam(anderlecht);
        instance.addTeam(brugge);

        ArrayList<Team> expected = new ArrayList<Team>() {{
            add(anderlecht);
            add(brugge);
        }};

        ArrayList<Team> actual = instance.getAllTeamsInACompetition(jpl);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void GetAllMatchesInACompetitionShouldReturnAnEmptyArrayListWhenThereAreNoMatches() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl,"Anderlecht");

        instance.addCompetition(jpl);
        instance.addTeam(anderlecht);

        assertEquals(instance.getAllMatchesInACompetion(jpl).size(), 0);
    }

    @Test
    public void GetAllMatchesInACompetitionShouldReturnTheRightMatchesWhenBothTeamsAreInTheCompetion() {
        Competition jpl = new Competition("Jupiler Pro League");
        Team anderlecht = new Team(jpl,"Anderlecht");
        Team brugge = new Team(jpl, "Brugge");
        Match one = new Match(anderlecht, brugge, 2, 1);
        Match two = new Match(brugge, anderlecht, 1, 4);

        instance.addCompetition(jpl);
        instance.addTeam(anderlecht);
        instance.addTeam(brugge);
        instance.addMatch(one);
        instance.addMatch(two);

        ArrayList<Match> expected = new ArrayList<Match>() {{
            add(one);
            add(two);
        }};

        ArrayList<Match> actual = instance.getAllMatchesInACompetion(jpl);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void GetAllMatchesInACompetitionShouldReturnTheRightMatchesWhenOnlyOneOfTheTeamsIsInTheCompetion() {
        Competition jpl = new Competition("Jupiler Pro League");
        Competition pl = new Competition("Premier League");
        Team anderlecht = new Team(jpl,"Anderlecht");
        Team brugge = new Team(jpl, "Brugge");
        Team arsenal = new Team(pl, "Arsenal");

        Match one = new Match(anderlecht, brugge, 2, 1);
        Match two = new Match(brugge, anderlecht, 1, 4);
        Match three = new Match(arsenal, brugge, 9,0);
        Match four = new Match(anderlecht, arsenal, 2, 2);

        instance.addCompetition(jpl);
        instance.addCompetition(pl);
        instance.addTeam(anderlecht);
        instance.addTeam(brugge);
        instance.addTeam(arsenal);
        instance.addMatch(one);
        instance.addMatch(two);
        instance.addMatch(three);
        instance.addMatch(four);

        ArrayList<Match> expected = new ArrayList<Match>() {{
            add(one);
            add(two);
            add(three);
            add(four);
        }};

        ArrayList<Match> actual = instance.getAllMatchesInACompetion(jpl);

        assertEquals(4, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void GetAllMatchesInACompetitionShouldReturnTheRightMatchesWhenThereIsAMatchThatIsNotInThatCompetition() {
        Competition jpl = new Competition("Jupiler Pro League");
        Competition pl = new Competition("Premier League");
        Team anderlecht = new Team(jpl,"Anderlecht");
        Team brugge = new Team(jpl, "Brugge");
        Team arsenal = new Team(pl, "Arsenal");
        Team mancity = new Team(pl, "Man City");

        Match one = new Match(anderlecht, brugge, 2, 1);
        Match two = new Match(brugge, anderlecht, 1, 4);
        Match three = new Match(arsenal, mancity, 0, 0);

        instance.addCompetition(jpl);
        instance.addCompetition(pl);
        instance.addTeam(anderlecht);
        instance.addTeam(brugge);
        instance.addTeam(arsenal);
        instance.addTeam(mancity);
        instance.addMatch(one);
        instance.addMatch(two);
        instance.addMatch(three);

        ArrayList<Match> expected = new ArrayList<Match>() {{
            add(one);
            add(two);
        }};

        ArrayList<Match> actual = instance.getAllMatchesInACompetion(jpl);

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }
}

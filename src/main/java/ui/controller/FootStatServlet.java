package ui.controller;

import domain.db.InMemoryDatabase;
import domain.models.Competition;
import domain.models.Team;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/FootStat")
public class FootStatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Competition comp;
    private InMemoryDatabase database;


    public FootStatServlet() {
        super();
        
        comp = new Competition("jpl");
        // Init database with data
        database = new InMemoryDatabase() {{
            addCompetition(comp);
        }};
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pagina = req.getParameter("action");
        if(pagina == null) {
            pagina = "klassement";
        }

        switch(pagina) {
            case "klassement":
                klassement(req, resp);
                break;
            case "ploeg-toevoegen":
                toevoegenPloeg(req, resp);
                break;
            case "match-toevoegen":
                toevoegenMatch(req, resp);
                break;
            default:
                klassement(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch(req.getParameter("action")) {
            case "ploeg-toevoegen":
                String name = req.getParameter("naam");
                if(name == null || name.trim().isEmpty()) {
                    break;
                }
                Team team = new Team(comp, name);
                database.addTeam(team);
                break;
            case "match-toevoegen":
                break;
            default:
                break;
        }

        klassement(req, resp);
    }

    private void klassement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Team> teams = database.getAllTeamsInACompetition(comp);

        RequestDispatcher output = req.getRequestDispatcher("klassement.jsp");
        req.setAttribute("teams", teams);
        output.forward(req, resp);
    }

    private void toevoegenPloeg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher output = req.getRequestDispatcher("ploeg-toevoegen.jsp");
        output.forward(req, resp);
    }

    private void toevoegenMatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher output = req.getRequestDispatcher("match-toevoegen.jsp");
        output.forward(req, resp);
    }
}

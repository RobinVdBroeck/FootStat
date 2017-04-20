package ui.controller;

import domain.db.InMemoryDatabase;
import domain.models.Competition;
import domain.models.Team;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Competition comp;
    private InMemoryDatabase database;


    public HomeServlet() {
        super();
        
        comp = new Competition("jpl");
        // Init database with data
        database = new InMemoryDatabase() {{
            addCompetition(comp);
            addTeam(new Team(comp, "Anderlecht"));
            addTeam(new Team(comp, "Brugge"));
        }};
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher output = req.getRequestDispatcher("index.jsp");
        output.forward(req, resp);
    }
}

<%@page
        contentType="text/html;charset=UTF-8"
        language="java"
        import="domain.models.Team"
        import="java.util.ArrayList"
%>
<%
    @SuppressWarnings("unchecked")
    ArrayList<Team> teams = (ArrayList<Team>) request.getAttribute("teams");
%>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Overzicht - FootStat</title>
    <link rel="stylesheet" href="css/stylesheet.css"/>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <main>
        <h3>Stats</h3>
        <ul>
            <li>Aantal ploegen: <%=teams.size()%></li>
            <li>Gemiddeld aantal doelpunten per match: TODO</li>
        </ul>

        <h3>Klassement</h3>
        <table class="klassement" border="1">
            <thead>
            <tr>
                <th>Plaats</th>
                <th>Club</th>
                <th><abbr title="Gespeeld">M</abbr></th>
                <th><abbr title="Gewonnen">M+</abbr></th>
                <th><abbr title="Gelijk">M=</abbr></th>
                <th><abbr title="Verloren">M-</abbr></th>
                <th><abbr title="Doelpunten gescoord">DV</abbr></th>
                <th><abbr title="Doelpunten tegen">DT</abbr></th>
                <th><abbr title="Doelpuntensaldo">DS</abbr></th>
                <th>Punten</th>
            </tr>
            </thead>

            <tbody>
            <%
                for (int i = 0; i < teams.size(); i++) {
            %>
            <tr>
                <td><%= i + 1 %>
                </td>
                <td><a href="#"><%= teams.get(i).getName() %>
                </a></td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Overzicht - FootStat</title>
<link rel="stylesheet" href="stylesheet.css" />
</head>
<body>
	<div class="container">
		<header>
			<div class="lijn">
				<div class="afbeelding">
					<img src="voetbal.png" alt="Voetbal" width="200" height="200" />
				</div>
				<div class="title">
					<h1>FootStats</h1>
					<hr />
					<h2>Jupiler Pro League</h2>
				</div>
			</div>
			<h3>Ploeg toevoegen</h3>
			<nav>
				<ul>
					<li><a href="index.html">Klassement</a></li>
					<li><a href="ploeg-toevoegen.html">Ploeg toevoegen</a></li>
					<li><a href="match-toevoegen.html">Match toevoegen</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<form>
				<p>
					<label for="kortenaam">Korte naam: </label>
					<input type="text" name="kortenaam" id="kortenaam" />
				</p>
				<p>
					<label for="volledigenaam">Volledige naam: </label>
					<input type="text" name="volledigenaam" id="volledigenaam" />
				</p>
				<p>
					<input type="submit" value="verzenden" required />
				</p>
			</form>
		</main>
		<footer>
			Gemaakt door <a href="mailto:robin.vandenbroeck@student.ucll.be">Robin
				Van den Broeck</a>.
		</footer>
	</div>
</body>
</html>
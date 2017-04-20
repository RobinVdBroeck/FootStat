<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Overzicht - FootStat</title>
<link rel="stylesheet" href="css/stylesheet.css" />
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<main>
			<form>
				<select name="thuisploeg" required>
					<option value="rscanderlecht">RSC Anderlecht</option>
					<option value="clubbrugge">Club Brugge</option>
					<option value="zultewaregem">Zulte Waregem</option>
					<option value="kvoostende">KV Oostende</option>				
				</select>
				<input type="number" name="thuisscore" min="0" max="99" required />
				-
				<input type="number" name="uitscore"  min="0" max="99" required />
				<select name="uitploeg" required>
					<option value="rscanderlecht">RSC Anderlecht</option>
					<option value="clubbrugge">Club Brugge</option>
					<option value="zultewaregem">Zulte Waregem</option>
					<option value="kvoostende">KV Oostende</option>				
				</select>
				<br />
				<input type="submit" value="verzenden" required />
			</form>
		</main>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
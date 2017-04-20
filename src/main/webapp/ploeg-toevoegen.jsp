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
			<form method="POST">
				<input type="text" name="action" value="ploeg-toevoegen" hidden />
				<p>
					<label for="naam">Naam: </label>
					<input type="text" name="naam" id="naam" required />
				</p>
				<p>
					<input type="submit" value="verzenden" />
				</p>
			</form>
		</main>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
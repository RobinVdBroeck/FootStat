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
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
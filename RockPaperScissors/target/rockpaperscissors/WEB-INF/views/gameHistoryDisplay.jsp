<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Rock Paper Scissors Game History</title>
</head>

<body>
	<h2>Rock Paper Scissors Game History</h2>
	<table border="1">
		<tr>
			<th>Total Rounds Played</th>
			<th>Total Wins for first players</th>
			<th>Total Wins for second players</th>
			<th>Total Draws</th>
		</tr>
		<tr>
			<td>${totalRoundPlayed}</td>
			<td>${totalWinsPlayerOne}</td>
			<td>${totalWinsPlayerTwo}</td>
			<td>${totalDraws}</td>
		</tr>
	</table>
</body>
</html>
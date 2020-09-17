<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Rock Paper Scissors Game</title>
</head>

<body>
	<h2>Rock Paper Scissors Game</h2>

	<table border="1">
		<tr>
			<th>Choice Player 1</th>
			<th>Choice Player 2</th>
			<th>Result</th>
		</tr>
		<c:forEach items="${roundsPlayed}" var="roundPlayed">
			<tr>
				<td>${roundPlayed.playerOneChoice}</td>
				<td>${roundPlayed.playerTwoChoice}</td>
				<td>${roundPlayed.result}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<form action="./automaticRound">
			<button type="submit">Play Round</button>
		</form>
	</div>
	<div>
		<form action="./restartGame">
			<button type="submit">Restart Game</button>
		</form>
	</div>
	<div>NUMBERS OF ROUNDS: ${numberRoundsPlayed}</div>
	<br>
	<br>
	<div>
		<form action="watchGameHistory">
			<button type="submit">Watch Game History</button>
		</form>
	</div>
</body>
</html>
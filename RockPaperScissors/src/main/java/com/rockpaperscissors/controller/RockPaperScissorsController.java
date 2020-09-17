package com.rockpaperscissors.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rockpaperscissors.model.GameHistory;
import com.rockpaperscissors.model.Round;
import com.rockpaperscissors.model.PlayerGame;
import com.rockpaperscissors.service.GameHistoryService;
import com.rockpaperscissors.service.PlayerGameService;
import com.rockpaperscissors.util.GenerateRandomNumber;

@Controller
@RequestMapping("/game")
@Scope("session")
public class RockPaperScissorsController {
	
	@Autowired
	PlayerGameService playerGameService;

	@Autowired
	GameHistoryService gameHistoryService;
	
	@Autowired
	GenerateRandomNumber generateRandomNumber;

	@RequestMapping(value = "/automaticRound", method = RequestMethod.GET)
	public String getAutomaticRound(HttpServletRequest request) {
		
		
		int randomNumber = generateRandomNumber.generateRandomNumberFrom3();
		
		PlayerGame game = playerGameService.getNewRound(randomNumber);

		//Get the lastRound from the round list
		String lastRoundResult = game.getListRounds().get(game.getListRounds().size() - 1).getResult();
		
		GameHistory gameHistory = gameHistoryService.updateLastRound(lastRoundResult);

		request.getSession().setAttribute("numberRoundsPlayed", game.getNumberRoundsPlayed());
		request.getSession().setAttribute("roundsPlayed", game.getListRounds());
		request.getSession().setAttribute("totalRoundPlayed", gameHistory.getTotalRoundsPlayed());
		request.getSession().setAttribute("totalWinsPlayerOne", gameHistory.getPlayerOneWins());
		request.getSession().setAttribute("totalWinsPlayerTwo", gameHistory.getPlayerTwoWins());
		request.getSession().setAttribute("totalDraws", gameHistory.getTotalDraws());

		return "gameDisplay";
	}

	@RequestMapping(value = "/restartGame", method = RequestMethod.GET)
	public String restartGame(HttpSession session) {
		playerGameService.playerRestartGame();

		session.setAttribute("numberRoundsPlayed", 0);
		session.setAttribute("roundsPlayed", new ArrayList<Round>());
		return "gameDisplay";
	}
	
	@RequestMapping(value = "/watchGameHistory", method = RequestMethod.GET)
	public String watchGameHistory(HttpSession session) {
		return "gameHistoryDisplay";
	}
}
package com.rockpaperscissors.service;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.rockpaperscissors.model.Round;
import com.rockpaperscissors.constants.Constants;
import com.rockpaperscissors.model.PlayerGame;

@Service
@Scope("session")
public class PlayerGameServiceImpl implements PlayerGameService {

	private PlayerGame playerGame;

	private static final Logger log = LoggerFactory.getLogger(GameHistoryServiceImpl.class);

	public PlayerGameServiceImpl() {
		playerGame = new PlayerGame();
	}

	/**
	 * Add a new Round with the result and the choices, and increment the number of
	 * rounds played
	 */
	public PlayerGame getNewRound(int randomNumber) {

		Round round = new Round();

		log.info("Setting the choices for the players.");
		// PlayerOne always choose Rock
		round.setPlayerOneChoice(Constants.ROCK);

		// PlayerTwo choose Randomly
		round.setPlayerTwoChoice(getRandomChoicePlayer(randomNumber));

		setResultRound(round);

		log.info("Adding the round to the Round List.");
		playerGame.addRound(round);
		playerGame.incrementNumberRoundsPlayed();
		return playerGame;
	}

	/**
	 * Set the result attribute depending on the choice of the second player Rock =>
	 * Draw Scissors => Player 1 Paper => Player 2
	 * 
	 * @param round
	 */
	private void setResultRound(Round round) {
		if (StringUtils.equals(round.getPlayerTwoChoice(), Constants.ROCK)) {
			log.info("Last Round result for Round {} is : {}", round, Constants.DRAW);
			round.setResult(Constants.DRAW);
		} else if (StringUtils.equals(round.getPlayerTwoChoice(), Constants.SCISSORS)) {
			log.info("Last Round result for Round {} is : {}", round, Constants.PLAYER_1);
			round.setResult(Constants.PLAYER_1);
		} else if (StringUtils.equals(round.getPlayerTwoChoice(), Constants.PAPER)) {
			log.info("Last Round result for Round {} is : {}", round, Constants.PLAYER_2);
			round.setResult(Constants.PLAYER_2);
		}
	}

	/**
	 * Choose a random option between: Rock, Paper and Scissors
	 * 
	 * @return String with the choice
	 */
	private String getRandomChoicePlayer(int randomNumber) {

		log.info("Getting a random choice.");

		String[] options = { Constants.ROCK, Constants.PAPER, Constants.SCISSORS };

		return options[randomNumber];
	}

	/**
	 * Restart the game for this player
	 */
	public void playerRestartGame() {

		log.info("Restarting Game.");
		playerGame.setNumberRoundsPlayed(0);
		playerGame.setListRounds(new ArrayList<Round>());
	}

}

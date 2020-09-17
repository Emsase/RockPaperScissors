package com.rockpaperscissors.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rockpaperscissors.model.GameHistory;
import com.rockpaperscissors.constants.Constants;

@Service
public class GameHistoryServiceImpl implements GameHistoryService {
	
	private GameHistory gameHistory;

	private static final Logger log = LoggerFactory.getLogger(GameHistoryServiceImpl.class);
	
	public GameHistoryServiceImpl() {
		gameHistory = new GameHistory();
	}
	/**
	 * Update the attributes related with the last Round
	 */
	public GameHistory updateLastRound(String lastRoundResult) {
		
		log.info("Updating the last Round in the history.");
		gameHistory.incrementTotalRoundPlayed();
		incrementLastWinner(lastRoundResult);
		
		return gameHistory;
	}

	/**
	 * Check who won the last round and increment it
	 * @param lastRoundResult
	 */
	private void incrementLastWinner(String lastRoundResult) {
		if (StringUtils.equals(lastRoundResult, Constants.PLAYER_1)) {
			log.info("Incremeting the total Wins for Player One.");
			gameHistory.incrementTotalWinsPlayerOne();
		} else if (StringUtils.equals(lastRoundResult, Constants.PLAYER_2)) {
			log.info("Incremeting the total Wins for Player Two.");
			gameHistory.incrementTotalWinsPlayerTwo();
		} else if (StringUtils.equals(lastRoundResult, Constants.DRAW)) {
			log.info("Incremeting the total draws.");
			gameHistory.incrementTotalDraws();
		}
	}

}

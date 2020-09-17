package com.rockpaperscissors.service;

import com.rockpaperscissors.model.GameHistory;

public interface GameHistoryService {

	/**
	 * {@inheritDoc}
	 */
	GameHistory updateLastRound(String lastRoundResult);
}

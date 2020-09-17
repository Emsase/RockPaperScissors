package com.rockpaperscissors.service;


import com.rockpaperscissors.model.PlayerGame;

public interface PlayerGameService 
{
	/**
	 * {@inheritDoc}
	 */
	PlayerGame getNewRound(int randomNumber);
	
	/**
	 * {@inheritDoc}
	 */
	void playerRestartGame();
	
}

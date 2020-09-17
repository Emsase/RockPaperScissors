package com.rockpaperscissors.model;

public class GameHistory {

	
	private int totalRoundsPlayed;
	private int playerOneWins;
	private int playerTwoWins;
	private int totalDraws;
	
	public int getTotalRoundsPlayed() {
		return totalRoundsPlayed;
	}
	public int getPlayerOneWins() {
		return playerOneWins;
	}
	public int getPlayerTwoWins() {
		return playerTwoWins;
	}
	public int getTotalDraws() {
		return totalDraws;
	}
	
	public void incrementTotalRoundPlayed() {
		totalRoundsPlayed++;
	}
	
	public void incrementTotalWinsPlayerOne() {
		playerOneWins++;
	}
	
	public void incrementTotalWinsPlayerTwo() {
		playerTwoWins++;
	}
	
	public void incrementTotalDraws() {
		totalDraws++;
	}
	
}

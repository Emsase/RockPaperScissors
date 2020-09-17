package com.rockpaperscissors.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PlayerGame implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private List<Round> listRounds;
	private int numberRoundsPlayed;

	public PlayerGame() {
		listRounds = new ArrayList<Round>();
		numberRoundsPlayed = 0;
	}
	
	public List<Round> getListRounds() {
		return listRounds;
	}

	public void setListRounds(List<Round> listRounds) {
		this.listRounds = listRounds;
	}
	
	public void addRound(Round round) {
		listRounds.add(round);
	}

	public int getNumberRoundsPlayed() {
		return numberRoundsPlayed;
	}

	public void setNumberRoundsPlayed(int numberRoundsPlayed) {
		this.numberRoundsPlayed = numberRoundsPlayed;
	}
	
	public void incrementNumberRoundsPlayed() {
		numberRoundsPlayed++;
	}
	
}
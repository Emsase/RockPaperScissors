package com.rockpaperscissor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rockpaperscissors.constants.Constants;
import com.rockpaperscissors.model.GameHistory;
import com.rockpaperscissors.service.GameHistoryService;
import com.rockpaperscissors.service.GameHistoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GameHistoryServiceImpl.class})
public class RockPaperScissorsGameHistoryServiceTest {

	@Autowired
	private GameHistoryService gameHistoryService;
	
	@Before
	public void initGameHistory() {
		gameHistoryService = new GameHistoryServiceImpl();
	}
	
	@Test
	public void updateLastRoundPlayer1ResultTest() {
		
		GameHistory gameHistory = gameHistoryService.updateLastRound(Constants.PLAYER_1);
		
		assertTrue(gameHistory.getTotalRoundsPlayed() == 1);
		assertTrue(gameHistory.getPlayerOneWins() == 1);
		assertTrue(gameHistory.getPlayerTwoWins() == 0);
		assertTrue(gameHistory.getTotalDraws() == 0);
	}
	
	@Test
	public void updateLastRoundPlayer2ResultTest() {
		
		GameHistory gameHistory = gameHistoryService.updateLastRound(Constants.PLAYER_2);
		
		assertTrue(gameHistory.getTotalRoundsPlayed() == 1);
		assertTrue(gameHistory.getPlayerOneWins() == 0);
		assertTrue(gameHistory.getPlayerTwoWins() == 1);
		assertTrue(gameHistory.getTotalDraws() == 0);
	}
	
	@Test
	public void updateLastRoundDrawResultTest() {
		
		GameHistory gameHistory = gameHistoryService.updateLastRound(Constants.DRAW);
		
		assertTrue(gameHistory.getTotalRoundsPlayed() == 1);
		assertTrue(gameHistory.getPlayerOneWins() == 0);
		assertTrue(gameHistory.getPlayerTwoWins() == 0);
		assertTrue(gameHistory.getTotalDraws() == 1);
	}
}

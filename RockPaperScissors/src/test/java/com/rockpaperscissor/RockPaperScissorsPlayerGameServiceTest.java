package com.rockpaperscissor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rockpaperscissors.model.PlayerGame;
import com.rockpaperscissors.service.PlayerGameService;
import com.rockpaperscissors.service.PlayerGameServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PlayerGameServiceImpl.class})
public class RockPaperScissorsPlayerGameServiceTest {
	
	private PlayerGameService playerGameService;
	
	
	@Before
	public void initPlayerGameService() {
		playerGameService = new PlayerGameServiceImpl();
	}
	
	
	@Test
	public void getNewRoundRandomNumber0Test() {
		
		PlayerGame playerGame = playerGameService.getNewRound(0);		
		assertTrue(playerGame.getNumberRoundsPlayed() == 1);
		assertTrue(playerGame.getListRounds().size() > 0);
	}
	
	@Test
	public void getNewRoundRandomNumber1Test() {
		
		PlayerGame playerGame = playerGameService.getNewRound(1);		
		assertTrue(playerGame.getNumberRoundsPlayed() == 1);
		assertTrue(playerGame.getListRounds().size() > 0);
	}
	
	@Test
	public void getNewRoundRandomNumber2Test() {
		
		PlayerGame playerGame = playerGameService.getNewRound(2);		
		assertTrue(playerGame.getNumberRoundsPlayed() == 1);
		assertTrue(playerGame.getListRounds().size() > 0);
	}
	
	@Test
	public void playerRestartGameTest() {
		
		PlayerGame playerGame = playerGameService.getNewRound(0);
		assertTrue(playerGame.getNumberRoundsPlayed() == 1);
		assertTrue(playerGame.getListRounds().size() > 0);
		
		playerGameService.playerRestartGame();		
		assertTrue(playerGame.getNumberRoundsPlayed() == 0);
		assertTrue(playerGame.getListRounds().size() == 0);
	}
	
	

}

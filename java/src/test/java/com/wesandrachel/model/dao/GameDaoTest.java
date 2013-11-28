package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Game;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class GameDaoTest {

	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	@Test
	public void getAllGames_returnsGames() {
		List<Game> allGames = gameDao.getAllGames();
		Assert.assertTrue("allGames.size(): "+allGames.size(), allGames.size() > 0);
	}
	
	@Test
	public void getGame_returnsId() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("id", 1, game.getId());
	}
	
	@Test
	public void getGame_returnsDate() {
		Calendar expectedDate = Calendar.getInstance();
		expectedDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedDate.set(Calendar.MILLISECOND, 0);
		
		Game game = gameDao.getGame(1);
		Assert.assertEquals("date", expectedDate.getTimeInMillis(), game.getDate().getTime());
	}
	
	@Test
	public void getGame_returnsWinner1() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("winner1", 80, (int)game.getWinner1());
	}
	
	@Test
	public void getGame_returnsWinner2() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("winner2", 79, (int)game.getWinner2());
	}
	
	@Test
	public void getGame_returnsLoser1() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("loser1", 84, (int)game.getLoser1());
	}
	
	@Test
	public void getGame_returnsLoser2() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("loser2", 90, (int)game.getLoser2());
	}
	
	@Test
	public void getGame_returnsShutout() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("shutout", true, game.getShutout());
	}
	
	
//	@Test
//	public void getGamesByPlayer_returnsAllGamesForThatPlayerId() {
//		List<Game> gameList = gameDao.getGamesByPlayer("1");
//		Assert.assertEquals("getGamesByPlayer returns games", 10, gameList.size());
//	}
//	
//	@Test
//	public void getGamesByYear_returnsAllGamesForThatYear() {
//		List<Game> gameList = gameDao.getGamesByYear("2006");
//		Assert.assertEquals("getGamesByYear returns games", 10, gameList.size());
//	}
}
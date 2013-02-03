package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Game;

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
	
	@Test
	@Ignore("unit test takes >1min to return all games")
	public void getGames_returnsAllGames() {
		List<Game> allGames = gameDao.getGames();
		Assert.assertTrue("getGames returns games", allGames.size() > 0);
	}
	
//	@Test
//	public void getGamesByPlayer_returnsAllGamesForThatPlayerId() {
//		List<Game> gameList = gameDao.getGamesByPlayer("0");
//		Assert.assertEquals("getGamesByPlayer returns games", 10, gameList.size());
//	}
//	
//	@Test
//	public void getGamesByYear_returnsAllGamesForThatYear() {
//		List<Game> gameList = gameDao.getGamesByYear("2006");
//		Assert.assertEquals("getGamesByYear returns games", 10, gameList.size());
//	}
	
}

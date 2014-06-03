package com.wesandrachel.dao;

import com.wesandrachel.dao.GameDao;
import com.wesandrachel.dao.PlayerDao;
import com.wesandrachel.domain.Game;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
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
	public void getAllGamesDesc_returnsGames() {
		List<Game> allGamesDesc = gameDao.getAllGamesDesc();
		Assert.assertTrue("getAllGamesDesc number of games: "+allGamesDesc.size(), allGamesDesc.size() > 0);
	}
	
	@Test
	public void getGamesPageDesc_returnsCorrectNumberOfGames() {
		List<Game> gameList = gameDao.getGamesPageDesc(0, 10);
		Assert.assertEquals("getGamesPageDesc number of games", 10, gameList.size());
	}
	
	@Test
	public void getGamesPageDesc_returnsCorrectSetOfGames() {
		int numOfGames = 100;
		LocalDate expectedLastGameDate = new LocalDate(2006, 8, 19);
		
		List<Game> allGames = gameDao.getAllGamesDesc();
		int lastIndex = (int) Math.ceil((double) allGames.size() / numOfGames) - 1;
		
		List<Game> gameList = gameDao.getGamesPageDesc(lastIndex, numOfGames);
		Game lastGame = gameList.get(gameList.size() - 1);
		Assert.assertEquals("getGamesPageDesc correct set of games", expectedLastGameDate, lastGame.getDate());
	}
	
	@Test
	public void getGamesByPlayer_returnsAllGamesForPlayerId() {
		List<Game> gameList = gameDao.getGamesByPlayer(1);
		Assert.assertEquals("getGamesByPlayer number of games", 2, gameList.size());
	}
	
	@Test
	public void getGamesByYear_returnsAllGamesForYear() {
		List<Game> gameList = gameDao.getGamesByYear(2006);
		Assert.assertEquals("getGamesByYear number of games", 16, gameList.size());
	}
	
	@Test
	public void getGamesByMonth_returnsAllGamesForMonth() {
		List<Game> gameList = gameDao.getGamesByMonth(2006, 8);
		Assert.assertEquals("getGamesByMonth number of games", 3, gameList.size());
	}
	
	@Test
	public void getGamesByDay_returnsAllGamesForDay() {
		List<Game> gameList = gameDao.getGamesByDay(2006, 8, 19);
		Assert.assertEquals("getGamesByDay number of games", 2, gameList.size());
	}
	
	@Test
	public void getGame_returnsId() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("id", 1, game.getId());
	}
	
	@Test
	public void getGame_returnsDate() {
		LocalDate expectedDate = new LocalDate(2006, 8, 19);
		Game game = gameDao.getGame(1);
		Assert.assertEquals("getGame date", expectedDate, game.getDate());
	}
	
	@Test
	public void getGame_returnsWinner1() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("getGame winner1", 80, (int) game.getWinner1());
	}
	
	@Test
	public void getGame_returnsWinner2() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("getGame winner2", 79, (int) game.getWinner2());
	}
	
	@Test
	public void getGame_returnsLoser1() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("getGame loser1", 84, (int) game.getLoser1());
	}
	
	@Test
	public void getGame_returnsLoser2() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("getGame loser2", 90, (int) game.getLoser2());
	}
	
	@Test
	public void getGame_returnsShutout() {
		Game game = gameDao.getGame(1);
		Assert.assertEquals("getGame shutout", true, game.getShutout());
	}
}
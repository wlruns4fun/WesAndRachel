package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Player;

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
public class PlayerDaoTest {

	@Autowired
	private PlayerDao playerDao;
	
	@Test
	public void getAllPlayers_returnsPlayers() {
		List<Player> allPlayers = playerDao.getAllPlayers();
		Assert.assertTrue("allPlayers.size(): "+allPlayers.size(), allPlayers.size() > 0);
	}
	
	@Test
	public void getPlayer_returnsId() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("id", 1, player.getId());
	}
	
	@Test
	public void getPlayer_returnsLastName() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("lastName", "Abrams", player.getLastName());
	}
	
	@Test
	public void getPlayer_returnsFirstName() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("firstName", "Chad", player.getFirstName());
	}
	
	@Test
	public void getPlayer_returnsEloRating() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("eloRating", 1980, player.getEloRating());
	}
	
	@Test
	public void getPlayer_returnsDoublesWins() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("doublesWins", 0, player.getDoublesWins());
	}
	
	@Test
	public void getPlayer_returnsDoublesLosses() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("doublesLosses", 2, player.getDoublesLosses());
	}
	
	@Test
	public void getPlayer_returnsSinglesWins() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("singlesWins", 0, player.getSinglesWins());
	}
	
	@Test
	public void getPlayer_returnsSinglesLosses() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("singlesLosses", 0, player.getSinglesLosses());
	}
	
	@Test
	public void getPlayer_returnsPrevWins() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("prevWins", 2, player.getPrevWins());
	}
	
	@Test
	public void getPlayer_returnsPrevLosses() {
		Player player = playerDao.getPlayer(1);
		Assert.assertEquals("prevLosses", 4, player.getPrevLosses());
	}
	
	@Test
	public void getPlayer_returnsCategories() {
		Player player = playerDao.getPlayer(14);
		Assert.assertTrue("player should contain a list of categories: "+player.getCategories(),
			player.getCategories().size() > 0);
	}
	
	@Test
	@Ignore("still experiencing performance issues")
	public void clearPlayerCache_evictsPlayerEntitiesFromSessionCache() {
		long start;
		long stop;
		
		playerDao.clearPlayerCache();
		
		start = System.currentTimeMillis();
		playerDao.getPlayer(1);
		stop = System.currentTimeMillis();
		long baseQueryTime = stop-start;
		
		start = System.currentTimeMillis();
		playerDao.getPlayer(1);
		stop = System.currentTimeMillis();
		long cachedQueryTime = stop-start;
		
		Assert.assertTrue("caching should reduce query time: "+cachedQueryTime+" !< "+baseQueryTime, 
			cachedQueryTime < baseQueryTime);
	}
}

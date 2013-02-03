package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Player;

import java.util.List;

import org.junit.Assert;
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
	public void getPlayers_returnsPlayers() {
		List<Player> allPlayers = playerDao.getPlayers();
		Assert.assertTrue("getPlayers returns players", allPlayers.size() > 0);
	}
}

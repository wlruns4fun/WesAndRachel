package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.PlayerDetails;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class PlayerDetailsDaoTest {

	@Autowired
	private PlayerDetailsDao playerDetailsDao;
	
	@Test
	public void getPlayerDetails_returnsPlayerDetails() {
		List<PlayerDetails> allPlayerDetails = playerDetailsDao.getPlayerDetails();
		Assert.assertTrue("getPlayerDetails returns playersDetails", allPlayerDetails.size() > 0);
	}
}

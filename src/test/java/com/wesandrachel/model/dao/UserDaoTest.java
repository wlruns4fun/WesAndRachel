package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.User;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void getAllUsers_returnsUsers() {
		List<User> allUsers = userDao.getAllUsers();
		Assert.assertTrue("allUsers returns users", allUsers.size() > 0);
	}
}

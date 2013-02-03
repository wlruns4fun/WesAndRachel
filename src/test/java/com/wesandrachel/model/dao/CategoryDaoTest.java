package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Category;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void getCategories_returnsAllCategories() {
		List<Category> allCategories = categoryDao.getCategories();
		Assert.assertTrue("getCategories returns categories", allCategories.size() > 0);
	}
}

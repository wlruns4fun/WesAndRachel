package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Category;
import com.wesandrachel.model.domain.Player;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	@Test
	public void getAllCategories_returnsCategories() {
		List<Category> allCategories = categoryDao.getAllCategories();
		Assert.assertTrue("allCategories.size(): "+allCategories.size(), allCategories.size() > 0);
	}
	
	@Test
	public void getCategory_returnsId() {
		Category category = categoryDao.getCategory(1);
		Assert.assertEquals("id", 1, category.getId());
	}
	
	@Test
	public void getCategory_returnsName() {
		Category category = categoryDao.getCategory(1);
		Assert.assertEquals("name", "Cardinal Solutions", category.getName());
	}
	
	@Test
	@Ignore("still experiencing performance issues")
	public void clearCategoryCache_evictsCategoryEntitiesFromSessionCache() {
		long start;
		long stop;
		
		categoryDao.clearCategoryCache();
		
		start = System.currentTimeMillis();
		categoryDao.getCategory(1);
		stop = System.currentTimeMillis();
		long baseQueryTime = stop-start;
		
		start = System.currentTimeMillis();
		categoryDao.getCategory(1);
		stop = System.currentTimeMillis();
		long cachedQueryTime = stop-start;
		
		Assert.assertTrue("caching should reduce query time: "+cachedQueryTime+" !< "+baseQueryTime, 
			cachedQueryTime < baseQueryTime);
	}
}

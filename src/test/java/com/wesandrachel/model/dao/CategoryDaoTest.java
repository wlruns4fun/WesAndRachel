package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Category;

import java.util.List;

import org.junit.Assert;
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
	
	@Test
	public void getAllCategories_returnsCategories() {
		List<Category> allCategories = categoryDao.getAllCategories();
		Assert.assertTrue("allCategories", allCategories.size() > 0);
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
}

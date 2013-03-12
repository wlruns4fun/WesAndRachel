package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Category;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		criteria.setCacheable(true);
		return (List<Category>) criteria.list();
	}
	
	public Category getCategory(int id) {
		Object category = sessionFactory.getCurrentSession().get(Category.class, id);
		return (Category) category;
	}
	
	public void clearCategoryCache() {
		sessionFactory.getCache().evictEntityRegion(Category.class);
	}
}

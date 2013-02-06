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
	public List<Category> getCategories() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		return (List<Category>) criteria.list();
	}
}
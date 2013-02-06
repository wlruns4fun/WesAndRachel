package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.PlayerDetails;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PlayerDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<PlayerDetails> getPlayerDetails() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PlayerDetails.class);
		return (List<PlayerDetails>) criteria.list();
	}
}

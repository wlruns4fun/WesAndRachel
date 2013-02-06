package com.wesandrachel.model.dao;

import com.wesandrachel.model.domain.Game;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GameDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getGames() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Game.class);
		return (List<Game>) criteria.list();
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Game> getGamesByPlayer(String playerId) {
//		String hqlQuery = "";
//		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
//		return (List<Game>) query.list();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Game> getGamesByYear(String year) {
//		String hqlQuery = "";
//		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
//		return (List<Game>) query.list();
//	}
}
package com.wesandrachel.dao;

import com.wesandrachel.domain.Game;

import java.util.List;

import org.hibernate.Criteria;
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
	public List<Game> getAllGames() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Game.class);
		criteria.setCacheable(true);
		return (List<Game>) criteria.list();
	}
	
	public Game getGame(int id) {
		Object game = sessionFactory.getCurrentSession().get(Game.class, id);
		return (Game) game;
	}
	
	public void clearGameCache() {
		sessionFactory.getCache().evictEntityRegion(Game.class);
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

package com.wesandrachel.foosball.dao;

import com.wesandrachel.foosball.domain.Game;

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
	
	public void clearGameCache() {
		sessionFactory.getCache().evictEntityRegion(Game.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getAllGamesDesc() {
		String hqlQuery = "FROM Game ORDER BY game_date DESC, game_id DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
		query.setCacheable(true);
		return (List<Game>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getGamesPageDesc(int numGames, int pageIndex) {
		String hqlQuery = "FROM Game ORDER BY game_date DESC, game_id DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
		query.setFirstResult(numGames * (pageIndex-1));
		query.setMaxResults(numGames);
		query.setCacheable(true);
		return (List<Game>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getGamesByPlayer(int playerId) {
		String hqlQuery = "FROM Game WHERE winner_1=:playerId OR winner_2=:playerId OR loser_1=:playerId OR loser_2=:playerId";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("playerId", playerId);
		query.setCacheable(true);
		return (List<Game>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getGamesByYear(int year) {
		String hqlQuery = "FROM Game WHERE year(game_date)=:year";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("year", year);
		query.setCacheable(true);
		return (List<Game>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getGamesByMonth(int year, int month) {
		String hqlQuery = "FROM Game WHERE year(game_date)=:year AND month(game_date)=:month";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("year", year);
		query.setParameter("month", month);
		query.setCacheable(true);
		return (List<Game>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getGamesByDay(int year, int month, int day) {
		String hqlQuery = "FROM Game WHERE year(game_date)=:year AND month(game_date)=:month AND day(game_date)=:day";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("year", year);
		query.setParameter("month", month);
		query.setParameter("day", day);
		query.setCacheable(true);
		return (List<Game>) query.list();
	}
	
	public Game getGame(int id) {
		Object game = sessionFactory.getCurrentSession().get(Game.class, id);
		return (Game) game;
	}
}

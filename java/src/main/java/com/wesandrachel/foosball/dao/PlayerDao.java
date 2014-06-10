package com.wesandrachel.foosball.dao;

import com.wesandrachel.foosball.domain.Player;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Player.class);
		criteria.setCacheable(true);
		return (List<Player>) criteria.list();
	}
	
	public Player getPlayer(int id) {
		Object player = sessionFactory.getCurrentSession().get(Player.class, id);
		return (Player) player;
	}
	
	public void clearPlayerCache() {
		sessionFactory.getCache().evictEntityRegion(Player.class);
	}
}

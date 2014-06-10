package com.wesandrachel.foosball.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wesandrachel.foosball.domain.LossRecord;
import com.wesandrachel.foosball.domain.WinRecord;

@Repository
@Transactional
public class WinRecordDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<WinRecord> getAllWinRecords() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WinRecord.class);
		criteria.setCacheable(true);
		return (List<WinRecord>) criteria.list();
	}
	
	public WinRecord getWinRecord(int id) {
		Object winRecord = sessionFactory.getCurrentSession().get(WinRecord.class, id);
		return (WinRecord) winRecord;
	}
	
	public void clearWinRecordCache() {
		sessionFactory.getCache().evictEntityRegion(WinRecord.class);
	}
}

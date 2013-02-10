package com.wesandrachel.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wesandrachel.model.domain.LossRecord;
import com.wesandrachel.model.domain.WinRecord;

@Repository
@Transactional
public class RecordDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<LossRecord> getAllLossRecords() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LossRecord.class);
		return (List<LossRecord>) criteria.list();
	}
	
	public LossRecord getLossRecord(int id) {
		Object lossRecord = sessionFactory.getCurrentSession().get(LossRecord.class, id);
		return (LossRecord) lossRecord;
	}
	
	public void clearLossRecordCache() {
		sessionFactory.getCache().evictEntityRegion(LossRecord.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<WinRecord> getAllWinRecords() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WinRecord.class);
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

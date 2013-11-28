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
public class LossRecordDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<LossRecord> getAllLossRecords() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LossRecord.class);
		criteria.setCacheable(true);
		return (List<LossRecord>) criteria.list();
	}
	
	public LossRecord getLossRecord(int id) {
		Object lossRecord = sessionFactory.getCurrentSession().get(LossRecord.class, id);
		return (LossRecord) lossRecord;
	}
	
	public void clearLossRecordCache() {
		sessionFactory.getCache().evictEntityRegion(LossRecord.class);
	}
}

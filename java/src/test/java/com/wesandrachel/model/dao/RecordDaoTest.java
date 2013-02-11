package com.wesandrachel.model.dao;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wesandrachel.model.domain.LossRecord;
import com.wesandrachel.model.domain.WinRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class RecordDaoTest {

	@Autowired
	private RecordDao recordDao;
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getAllLossRecords_returnsLossRecords() {
		List<LossRecord> allLossRecords = recordDao.getAllLossRecords();
		Assert.assertTrue("allLossRecords.size(): "+allLossRecords.size(), allLossRecords.size() > 0);
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsId() {
		LossRecord lossRecord = recordDao.getLossRecord(1);
		Assert.assertEquals("id", 1, lossRecord.getId());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsCount() {
		LossRecord winRecord = recordDao.getLossRecord(1);
		Assert.assertEquals("count", 1, winRecord.getCount());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsLoser1() {
		LossRecord winRecord = recordDao.getLossRecord(1);
		Assert.assertEquals("winner1", 1, winRecord.getLoser1().getId());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsLoser2() {
		LossRecord winRecord = recordDao.getLossRecord(1);
		Assert.assertEquals("winner2", 1, winRecord.getLoser2().getId());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsStartDate() {
		Calendar expectedStartDate = Calendar.getInstance();
		expectedStartDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedStartDate.set(Calendar.MILLISECOND, 0);
		
		LossRecord winRecord = recordDao.getLossRecord(1);
		Assert.assertEquals("startDate", expectedStartDate, winRecord.getStartDate());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsEndDate() {
		Calendar expectedEndDate = Calendar.getInstance();
		expectedEndDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedEndDate.set(Calendar.MILLISECOND, 0);
		
		LossRecord winRecord = recordDao.getLossRecord(1);
		Assert.assertEquals("endDate", expectedEndDate, winRecord.getEndDate());
	}
	
	@Test
	@Ignore("still experiencing performance issues")
	public void clearLossRecordCache_evictsLossRecordEntitiesFromSessionCache() {
		long start;
		long stop;
		
		recordDao.clearLossRecordCache();
		
		start = System.currentTimeMillis();
		recordDao.getLossRecord(1);
		stop = System.currentTimeMillis();
		long baseQueryTime = stop-start;
		
		start = System.currentTimeMillis();
		recordDao.getLossRecord(1);
		stop = System.currentTimeMillis();
		long cachedQueryTime = stop-start;
		
		Assert.assertTrue("caching should reduce query time: "+cachedQueryTime+" !< "+baseQueryTime, 
			cachedQueryTime < baseQueryTime);
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getAllWinRecords_returnsWinRecords() {
		List<WinRecord> allWinRecords = recordDao.getAllWinRecords();
		Assert.assertTrue("allWinRecords.size(): "+allWinRecords.size(), allWinRecords.size() > 0);
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsId() {
		WinRecord winRecord = recordDao.getWinRecord(1);
		Assert.assertEquals("id", 1, winRecord.getId());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsCount() {
		WinRecord winRecord = recordDao.getWinRecord(1);
		Assert.assertEquals("count", 1, winRecord.getCount());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsWinner1() {
		WinRecord winRecord = recordDao.getWinRecord(1);
		Assert.assertEquals("winner1", 1, winRecord.getWinner1().getId());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsWinner2() {
		WinRecord winRecord = recordDao.getWinRecord(1);
		Assert.assertEquals("winner2", 1, winRecord.getWinner2().getId());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsStartDate() {
		Calendar expectedStartDate = Calendar.getInstance();
		expectedStartDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedStartDate.set(Calendar.MILLISECOND, 0);
		
		WinRecord winRecord = recordDao.getWinRecord(1);
		Assert.assertEquals("startDate", expectedStartDate, winRecord.getStartDate());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsEndDate() {
		Calendar expectedEndDate = Calendar.getInstance();
		expectedEndDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedEndDate.set(Calendar.MILLISECOND, 0);
		
		WinRecord winRecord = recordDao.getWinRecord(1);
		Assert.assertEquals("endDate", expectedEndDate, winRecord.getEndDate());
	}
	
	@Test
	@Ignore("still experiencing performance issues")
	public void clearWinRecordCache_evictsWinRecordEntitiesFromSessionCache() {
		long start;
		long stop;
		
		recordDao.clearWinRecordCache();
		
		start = System.currentTimeMillis();
		recordDao.getWinRecord(1);
		stop = System.currentTimeMillis();
		long baseQueryTime = stop-start;
		
		start = System.currentTimeMillis();
		recordDao.getWinRecord(1);
		stop = System.currentTimeMillis();
		long cachedQueryTime = stop-start;
		
		Assert.assertTrue("caching should reduce query time: "+cachedQueryTime+" !< "+baseQueryTime, 
			cachedQueryTime < baseQueryTime);
	}
}

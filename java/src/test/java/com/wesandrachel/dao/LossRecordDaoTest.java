package com.wesandrachel.dao;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wesandrachel.dao.LossRecordDao;
import com.wesandrachel.domain.LossRecord;
import com.wesandrachel.domain.WinRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class LossRecordDaoTest {

	@Autowired
	private LossRecordDao lossRecordDao;
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getAllLossRecords_returnsLossRecords() {
		List<LossRecord> allLossRecords = lossRecordDao.getAllLossRecords();
		Assert.assertTrue("allLossRecords.size(): "+allLossRecords.size(), allLossRecords.size() > 0);
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsId() {
		LossRecord lossRecord = lossRecordDao.getLossRecord(1);
		Assert.assertEquals("id", 1, lossRecord.getId());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsCount() {
		LossRecord winRecord = lossRecordDao.getLossRecord(1);
		Assert.assertEquals("count", 1, winRecord.getCount());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsLoser1() {
		LossRecord winRecord = lossRecordDao.getLossRecord(1);
		Assert.assertEquals("winner1", 1, winRecord.getPlayer1().getId());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsLoser2() {
		LossRecord winRecord = lossRecordDao.getLossRecord(1);
		Assert.assertEquals("winner2", 1, winRecord.getPlayer2().getId());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsStartDate() {
		Calendar expectedStartDate = Calendar.getInstance();
		expectedStartDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedStartDate.set(Calendar.MILLISECOND, 0);
		
		LossRecord winRecord = lossRecordDao.getLossRecord(1);
		Assert.assertEquals("startDate", expectedStartDate, winRecord.getStartDate());
	}
	
	@Test
	@Ignore("haven't enabled LossRecords yet (empty table in db)")
	public void getLossRecord_returnsEndDate() {
		Calendar expectedEndDate = Calendar.getInstance();
		expectedEndDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedEndDate.set(Calendar.MILLISECOND, 0);
		
		LossRecord winRecord = lossRecordDao.getLossRecord(1);
		Assert.assertEquals("endDate", expectedEndDate, winRecord.getEndDate());
	}
}
package com.wesandrachel.foosball.dao;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wesandrachel.foosball.dao.WinRecordDao;
import com.wesandrachel.foosball.domain.LossRecord;
import com.wesandrachel.foosball.domain.WinRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class WinRecordDaoTest {

	@Autowired
	private WinRecordDao winRecordDao;
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getAllWinRecords_returnsWinRecords() {
		List<WinRecord> allWinRecords = winRecordDao.getAllWinRecords();
		Assert.assertTrue("allWinRecords.size(): "+allWinRecords.size(), allWinRecords.size() > 0);
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsId() {
		WinRecord winRecord = winRecordDao.getWinRecord(1);
		Assert.assertEquals("id", 1, winRecord.getId());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsCount() {
		WinRecord winRecord = winRecordDao.getWinRecord(1);
		Assert.assertEquals("count", 1, winRecord.getCount());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsWinner1() {
		WinRecord winRecord = winRecordDao.getWinRecord(1);
		Assert.assertEquals("winner1", 1, winRecord.getPlayer1().getId());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsWinner2() {
		WinRecord winRecord = winRecordDao.getWinRecord(1);
		Assert.assertEquals("winner2", 1, winRecord.getPlayer2().getId());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsStartDate() {
		Calendar expectedStartDate = Calendar.getInstance();
		expectedStartDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedStartDate.set(Calendar.MILLISECOND, 0);
		
		WinRecord winRecord = winRecordDao.getWinRecord(1);
		Assert.assertEquals("startDate", expectedStartDate, winRecord.getStartDate());
	}
	
	@Test
	@Ignore("haven't enabled WinRecords yet (empty table in db)")
	public void getWinRecord_returnsEndDate() {
		Calendar expectedEndDate = Calendar.getInstance();
		expectedEndDate.set(2006, 8-1, 19, 0, 0, 0);
		expectedEndDate.set(Calendar.MILLISECOND, 0);
		
		WinRecord winRecord = winRecordDao.getWinRecord(1);
		Assert.assertEquals("endDate", expectedEndDate, winRecord.getEndDate());
	}
}
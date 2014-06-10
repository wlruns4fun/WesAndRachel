package com.wesandrachel.foosball.controller;

import com.wesandrachel.foosball.dao.CategoryDao;
import com.wesandrachel.foosball.dao.GameDao;
import com.wesandrachel.foosball.dao.LossRecordDao;
import com.wesandrachel.foosball.dao.PlayerDao;
import com.wesandrachel.foosball.dao.WinRecordDao;
import com.wesandrachel.foosball.domain.Category;
import com.wesandrachel.foosball.domain.Game;
import com.wesandrachel.foosball.domain.LossRecord;
import com.wesandrachel.foosball.domain.Player;
import com.wesandrachel.foosball.domain.WinRecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private LossRecordDao lossRecordDao;
	
	@Autowired
	private WinRecordDao winRecordDao;

	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/categories"})
	public @ResponseBody List<Category> getCategories() {
		List<Category> allCategories = categoryDao.getAllCategories();
		return allCategories;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/games"})
	public @ResponseBody List<Game> getAllGamesDesc() {
		List<Game> allGamesDesc = gameDao.getAllGamesDesc();
		return allGamesDesc;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/games/{numGames}/page/{pageIndex}"})
	public @ResponseBody List<Game> getGamesPageDesc(@PathVariable int numGames, @PathVariable int pageIndex) {
		List<Game> gamesPageDesc = gameDao.getGamesPageDesc(numGames, pageIndex);
		return gamesPageDesc;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/players"})
	public @ResponseBody List<Player> getPlayers() {
		List<Player> allPlayers = playerDao.getAllPlayers();
		return allPlayers;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/records/losses"})
	public @ResponseBody List<LossRecord> getAllLossRecords() {
		List<LossRecord> allLossRecords = lossRecordDao.getAllLossRecords();
		return allLossRecords;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/records/wins"})
	public @ResponseBody List<WinRecord> getAllWinRecords() {
		List<WinRecord> allWinRecords = winRecordDao.getAllWinRecords();
		return allWinRecords;
	}
}

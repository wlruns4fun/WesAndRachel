package com.wesandrachel.controller;

import com.wesandrachel.model.dao.CategoryDao;
import com.wesandrachel.model.dao.GameDao;
import com.wesandrachel.model.dao.LossRecordDao;
import com.wesandrachel.model.dao.PlayerDao;
import com.wesandrachel.model.dao.WinRecordDao;
import com.wesandrachel.model.domain.Category;
import com.wesandrachel.model.domain.Game;
import com.wesandrachel.model.domain.LossRecord;
import com.wesandrachel.model.domain.Player;
import com.wesandrachel.model.domain.WinRecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	private LossRecordDao lossRecordDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private WinRecordDao winRecordDao;

	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/categories"})
	public @ResponseBody List<Category> getCategories() {
		List<Category> allCategories = categoryDao.getAllCategories();
		return allCategories;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/games"})
	public @ResponseBody List<Game> getGames() {
		List<Game> allGames = gameDao.getAllGames();
		return allGames;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/records/losses"})
	public @ResponseBody List<LossRecord> getAllLossRecords() {
		List<LossRecord> allLossRecords = lossRecordDao.getAllLossRecords();
		return allLossRecords;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/players"})
	public @ResponseBody List<Player> getPlayers() {
		List<Player> allPlayers = playerDao.getAllPlayers();
		return allPlayers;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/records/wins"})
	public @ResponseBody List<WinRecord> getAllWinRecords() {
		List<WinRecord> allWinRecords = winRecordDao.getAllWinRecords();
		return allWinRecords;
	}
}

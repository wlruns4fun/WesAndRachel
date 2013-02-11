package com.wesandrachel.controller;

import com.wesandrachel.model.dao.CategoryDao;
import com.wesandrachel.model.dao.GameDao;
import com.wesandrachel.model.dao.PlayerDao;
import com.wesandrachel.model.dao.RecordDao;
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
	private PlayerDao playerDao;
	
	@Autowired
	private RecordDao recordDao;

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
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/lossRecords"})
	public @ResponseBody List<LossRecord> getAllLossRecords() {
		List<LossRecord> allLossRecords = recordDao.getAllLossRecords();
		return allLossRecords;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/players"})
	public @ResponseBody List<Player> getPlayers() {
		List<Player> allPlayers = playerDao.getAllPlayers();
		return allPlayers;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/services/winRecords"})
	public @ResponseBody List<WinRecord> getAllWinRecords() {
		List<WinRecord> allWinRecords = recordDao.getAllWinRecords();
		return allWinRecords;
	}
}

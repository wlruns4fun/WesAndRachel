package com.wesandrachel.controller;

import com.wesandrachel.model.dao.GameDao;
import com.wesandrachel.model.dao.PlayerDao;
import com.wesandrachel.model.domain.Game;
import com.wesandrachel.model.domain.Player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {
	
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private PlayerDao playerDao;

	@RequestMapping(method=RequestMethod.GET, value={"/services/games"})
	public @ResponseBody List<Game> getGames() {
		List<Game> allGames = gameDao.getGames();
		return allGames;
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/services/players"})
	public @ResponseBody List<Player> getPlayers() {
		List<Player> allPlayers = playerDao.getPlayers();
		return allPlayers;
	}
}

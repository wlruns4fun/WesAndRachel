package com.wesandrachel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping(method=RequestMethod.GET, value={"/"})
	public ModelAndView getWelcomeView() {
		return new ModelAndView("HomeView");
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball", "/foosball/players"})
	public ModelAndView getPlayersView() {
		return new ModelAndView("PlayersView");
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/games"})
	public ModelAndView getGamesView() {
		return new ModelAndView("GamesView");
	}
}

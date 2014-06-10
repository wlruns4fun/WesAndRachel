package com.wesandrachel.foosball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping(method=RequestMethod.GET, value={"/"})
	public ModelAndView getWelcomeView() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball", "/foosball/players"})
	public ModelAndView getPlayersView() {
		return new ModelAndView("players");
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/games"})
	public ModelAndView getGamesView() {
		return new ModelAndView("games");
	}
}

package com.wesandrachel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping(method=RequestMethod.GET, value={"/", "/test"})
	public ModelAndView getWelcomeView() {
		return new ModelAndView("WelcomeView");
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/foosball/", "/foosball/players"})
	public ModelAndView getPlayerView() {
		return new ModelAndView("PlayerView");
	}
}

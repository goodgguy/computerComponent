package com.computer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.computer.service.*;

@Controller
@RequestMapping("/homepage")
public class HomePageController {
	@Autowired
	private HinhanhtrangService hinhanhtrangService;
	
	 @RequestMapping(value = "/showHomepage", method = RequestMethod.GET)
	 public String homepage()
	 {
		 return "test";
	 }
}

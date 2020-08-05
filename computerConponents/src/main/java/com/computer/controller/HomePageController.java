package com.computer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.computer.service.*;
import com.computer.model.*;

@Controller
@RequestMapping("/homepage")
public class HomePageController {
	@Autowired
	private HinhanhtrangService hinhanhtrangService;
	
	@Autowired
	private DanhmucsanphamService danhmucsanphamService;
	
	 @RequestMapping(value = "/showHomepage", method = RequestMethod.GET)
	 public String homepage(ModelMap map)
	 {
		 //Hinhanhtrang
		 List<HinhanhtrangDTO>listHinhanhtrang=new ArrayList<HinhanhtrangDTO>();
		 listHinhanhtrang=hinhanhtrangService.getAllHinhanhtrang();
		 map.addAttribute("hinhanhtrang", listHinhanhtrang.get(listHinhanhtrang.size()-1));
		 //danhmucsanpham
		 List<DanhmucsanphamDTO>listDanhmucsanpham=new ArrayList<DanhmucsanphamDTO>();
		 listDanhmucsanpham=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsanpham", listDanhmucsanpham);
		 //
		 return "guest/index";
	 }
}

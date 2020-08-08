package com.computer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.computer.service.*;
import com.computer.model.*;

@Controller
public class HomePageController {
	@Autowired
	private HinhanhtrangService hinhanhtrangService;
	
	@Autowired
	private DanhmucsanphamService danhmucsanphamService;
	
	@Autowired
	private SanphamService sanphamService;
	
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
		 //sanphammoinhat
		 ArrayList<SanphamDTO>listSanpham=new ArrayList<SanphamDTO>();
		 listSanpham=sanphamService.getListSanpham(1, 20);
		 map.addAttribute("sanpham", listSanpham);
		 return "guest/index";
	 }
	 
	 @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	 public String getDetailProduct(@PathVariable("id")int id,ModelMap map)
	 {
		//Hinhanhtrang
		 List<HinhanhtrangDTO>listHinhanhtrang=new ArrayList<HinhanhtrangDTO>();
		 listHinhanhtrang=hinhanhtrangService.getAllHinhanhtrang();
		 map.addAttribute("hinhanhtrang", listHinhanhtrang.get(listHinhanhtrang.size()-1));
		 //danhmucsanpham
		 List<DanhmucsanphamDTO>listDanhmucsanpham=new ArrayList<DanhmucsanphamDTO>();
		 listDanhmucsanpham=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsanpham", listDanhmucsanpham);
		 
		 //=========
		 System.out.print("PRODUCTID PRODUCTID PRODUCTID "+id);
		 SanphamDTO sp=sanphamService.getById(id);
		 map.addAttribute("sanpham", sp);
		 return "guest/chitiethang";
	 }
}

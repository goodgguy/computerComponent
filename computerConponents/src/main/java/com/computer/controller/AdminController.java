package com.computer.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.computer.model.HoadonDTO;
import com.computer.service.HoadonService;
import com.computer.utils.Common;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	HoadonService hoadonService;

	@Autowired
	CthoadonService cthoadonService;
	
	@RequestMapping(value = "/duyetdonhang", method = RequestMethod.GET)
	public String duyedonhang(ModelMap map) {
		//GET HOADON
		List<HoadonDTO> dtos=hoadonService.getCtPending(Long.parseLong("-1"));
		map.addAttribute("dtos", dtos);
		return "admin/duyetdonhang";
	}
	
	@RequestMapping(value = "/donhangdaduyet", method = RequestMethod.GET)
	public String donhangdaduyet(ModelMap map) {
		List<HoadonDTO> dtos=hoadonService.getCtConfirmed(Long.parseLong("-1"));
		map.addAttribute("dtos", dtos);
		return "admin/donhangdaduyet";
	}
	
	@RequestMapping(value = "/huydonhang", method = RequestMethod.GET)
	public String huydonhang(ModelMap map) {
		List<HoadonDTO> dtos=hoadonService.getCtDeleted(Long.parseLong("-1"));
		map.addAttribute("dtos", dtos);
		return "admin/huydonhang";
	}
	
	 @RequestMapping(value = "/xacnhanhd/{id}", method = RequestMethod.GET)
	 public RedirectView xacnhanhd(ModelMap map,@PathVariable("id")int idhd, 
			 HttpSession session,
			 Principal principal)
	 {
		 hoadonService.setState(idhd,Common.STATE_HOADON_CONFIRMED);
		 return new RedirectView("/admin/donhangdaduyet"); 
	 }
	 
	 @RequestMapping(value = "/huyhd/{id}", method = RequestMethod.GET)
	 public RedirectView huyhd(ModelMap map,@PathVariable("id")int idhd, 
			 HttpSession session,
			 Principal principal)
	 {
		 hoadonService.setState(idhd,Common.STATE_HOADON_HUY);
		 return new RedirectView("/admin/huydonhang"); 
	 }
}

package com.computer.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.computer.model.AppUserDTO;
import com.computer.model.CthoadonDTO;
import com.computer.model.HoadonDTO;
import com.computer.model.SanphamDTO;
import com.computer.service.AppUserService;
import com.computer.service.CthoadonService;
import com.computer.service.HoadonService;
import com.computer.service.SanphamService;
import com.computer.utils.Common;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	HoadonService hoadonService;

	@Autowired
	CthoadonService cthoadonService;
	
	@Autowired
	SanphamService sanphamService;
	
	@Autowired
	AppUserService appuserService;
	
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
			 Principal principal,
			 RedirectAttributes redirectAttributes)
	 {
		 List<CthoadonDTO>listcthd= cthoadonService.getCtbyIdHoadon(idhd);
		 for(CthoadonDTO e:listcthd)
		 {
			 boolean check= cthoadonService.checkQuantity(e.getSanpham().getIdsp(), e.getSoluong());
			 System.out.print("TEST TEST"+String.valueOf(check));
			 if(!check)
			 {
				 redirectAttributes.addAttribute("message", "Số lượng chưa đủ");
				 return new RedirectView("/admin/duyetdonhang");
			 }
		 }
		 //HANDLE SOULUONG
		 for(CthoadonDTO e:listcthd)
		 {
			 SanphamDTO spdto=sanphamService.getById(e.getSanpham().getIdsp());
			 sanphamService.truSoluong(spdto, e.getSoluong());
		 }
		 //SET STATE
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
	 @RequestMapping(value = "/huyhddaxacnhan/{id}", method = RequestMethod.GET)
	 public RedirectView huyhddaxacnhan(ModelMap map,@PathVariable("id")int idhd, 
			 HttpSession session,
			 Principal principal)
	 {
		 //HANDLE SOLUONG
		 List<CthoadonDTO>listcthd= cthoadonService.getCtbyIdHoadon(idhd);
		 for(CthoadonDTO e:listcthd)
		 {
			 SanphamDTO spdto=sanphamService.getById(e.getSanpham().getIdsp());
			 sanphamService.congSoluong(spdto, e.getSoluong());
		 }
		 //SET STATE
		 hoadonService.setState(idhd,Common.STATE_HOADON_HUY);
		 return new RedirectView("/admin/huydonhang"); 
	 }
	 @RequestMapping(value = "/infodonhang/{idhd}/{username}", method = RequestMethod.GET)
	 public String infodonhang(ModelMap map,
			 @PathVariable("idhd")int idhd,
			 @PathVariable("username")String username)
	 {
		 List<CthoadonDTO> cthds=cthoadonService.getCtbyIdHoadon(idhd);
		 map.addAttribute("cthd",cthds);
		 double tonggiahd=0;
		 for(int i=0;i<cthds.size();i++)
		 {
			 tonggiahd+=cthds.get(i).getTonggia();
		 }
		 map.addAttribute("tonggiahd", tonggiahd);
		 AppUserDTO appuser=appuserService.getUser(username);
		 map.addAttribute("user", appuser);
		 return "admin/infodonhang";
	 }
	 //QUAN LY SAN PHAM
	 @RequestMapping(value = "/infodonhang/danhsachsanpham", method = RequestMethod.GET)
	 public String danhsachsanpham()
	 {
		 ArrayList<SanphamDTO>listSanpham=new ArrayList<SanphamDTO>();
		 listSanpham=sanphamService.getListSanpham(1, 20);
		 map.addAttribute("sanpham", listSanpham);
		 return "admin/danhsachsanpham";
	 }
}

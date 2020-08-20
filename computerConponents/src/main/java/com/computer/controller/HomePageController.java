package com.computer.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.computer.service.*;
import com.computer.utils.Common;
import com.computer.utils.EncrytedPasswordUtils;
import com.computer.utils.WebUtils;
import com.computer.entity.AppUser;
import com.computer.entity.Loaithanhtoan;
import com.computer.entity.Sanpham;
import com.computer.model.*;

@Controller
public class HomePageController {
	@Autowired
	private HinhanhtrangService hinhanhtrangService;
	
	@Autowired
	private DanhmucsanphamService danhmucsanphamService;
	
	@Autowired
	private SanphamService sanphamService;
	
	@Autowired
	private LoaithanhtoanService loaithanhtoanService;
	
	@Autowired
	private AppUserService appuserService;
	
	@Autowired
	private HoadonService hoadonService;
	
	@Autowired
	private CthoadonService cthoadonService;
	
	@Autowired
	private UserRoleService userroleService;
	
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
		 
		 //Sanpham
		 System.out.print("PRODUCTID PRODUCTID PRODUCTID "+id);
		 SanphamDTO sp=sanphamService.getById(id);
		 map.addAttribute("sanpham", sp);
		 
		 
		 return "guest/chitiethang";
		 
	 }
	 @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	 public String getSpByCategory(@PathVariable("id")int id,ModelMap map)
	 {
		//Hinhanhtrang
		 List<HinhanhtrangDTO>listHinhanhtrang=new ArrayList<HinhanhtrangDTO>();
		 listHinhanhtrang=hinhanhtrangService.getAllHinhanhtrang();
		 map.addAttribute("hinhanhtrang", listHinhanhtrang.get(listHinhanhtrang.size()-1));
		 //danhmucsanpham
		 List<DanhmucsanphamDTO>listDanhmucsanpham=new ArrayList<DanhmucsanphamDTO>();
		 listDanhmucsanpham=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsanpham", listDanhmucsanpham);
		 //Load sp theo loai
		 ArrayList<SanphamDTO>listSanpham=new ArrayList<SanphamDTO>();
		 listSanpham=sanphamService.getListSanphamtheoCate(id,1,20);
		 if(listSanpham.size()!=0)
		 {
			 map.addAttribute("cate",listSanpham.get(0).getDanhmucsp().getTendanhmucsp());
		 }
		 else
		 {
			 map.addAttribute("cate"," ");
		 }
		 map.addAttribute("sanpham", listSanpham);
		 
		 return "guest/sanphamtheocate";
	 }
	 @RequestMapping(value = "/addCart/{id}", method = RequestMethod.POST)
	 public RedirectView addCart(@RequestParam(value = "soluong",required = false,defaultValue="0")int soluong,
			 @PathVariable("id")int id,
			 HttpSession session,
			 Principal principal)
	 {
		 ArrayList<CthoadonDTO> cthds;
		 SanphamDTO spdto=sanphamService.getById(id);
		 //CREATE SESSION
		 if(session.getAttribute(Common.USER_SESSION)==null)
		 {
			 User loginedUser = (User) ((Authentication) principal).getPrincipal();
		     String userInfo = loginedUser.getUsername();
		     session.setAttribute(Common.USER_SESSION, userInfo);
		     cthds=new ArrayList<CthoadonDTO>();
		     session.setAttribute(Common.Cart_SESSION, cthds);
		 }
		 //GET SESSION
		 cthds=(ArrayList<CthoadonDTO>) session.getAttribute(Common.Cart_SESSION);
		 //CHECK MATCHES ID
		 for(int i=0;i<cthds.size();i++)
		 {
			 
			 if(cthds.get(i).getSanpham().getIdsp()==id)
			 {
				 int slbd=cthds.get(i).getSoluong();
				 double tgbd=cthds.get(i).getTonggia();
				 cthds.get(i).setSoluong(slbd+soluong);
				 cthds.get(i).setTonggia(tgbd+(soluong*spdto.getGiasp()));
				 return new RedirectView("/showHomepage");
			 }
		 }
		 //HANDLE SESSION
		 CthoadonDTO cthd=new CthoadonDTO();
		 cthd.setSoluong(soluong);
		 cthd.setTonggia(soluong*spdto.getGiasp());
		 //CONVERT DTO to ENTITY
		 Sanpham sp=new Sanpham();
		 sp.setIdsp(spdto.getIdsp());
		 sp.setTensp(spdto.getTensp());
		 sp.setGiasp(spdto.getGiasp());
		 sp.setAnhchinh(spdto.getAnhchinh());
		 //===
		 cthd.setSanpham(sp);
		 cthds.add(cthd);
		 
		 //SET BACK SESSION
		 session.setAttribute(Common.Cart_SESSION, cthds);
		 
//		 if(session.getAttribute(Common.USER_SESSION)!=null)
//		 {
//			 for(int i=0;i<cthds.size();i++)
//			 {
//				 System.out.print("CTHD thu"+i+cthds.get(i).getSoluong()+cthds.get(i).getSanpham().getIdsp());
//			 }
//		 }
		 
		 return new RedirectView("/showHomepage");
	 }
	 @RequestMapping(value = "/showCart", method = RequestMethod.GET)
	 public String showCart(ModelMap map, 
			 HttpSession session,
			 Principal principal)
	 {
		//Hinhanhtrang
		 List<HinhanhtrangDTO>listHinhanhtrang=new ArrayList<HinhanhtrangDTO>();
		 listHinhanhtrang=hinhanhtrangService.getAllHinhanhtrang();
		 map.addAttribute("hinhanhtrang", listHinhanhtrang.get(listHinhanhtrang.size()-1));
		 //danhmucsanpham
		 List<DanhmucsanphamDTO>listDanhmucsanpham=new ArrayList<DanhmucsanphamDTO>();
		 listDanhmucsanpham=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsanpham", listDanhmucsanpham);
		 //HANDLE SESSION
		 ArrayList<CthoadonDTO> cthds;
		 double tonggiahd=0;
		 if(session.getAttribute(Common.USER_SESSION)==null)
		 {
			 User loginedUser = (User) ((Authentication) principal).getPrincipal();
		     String userInfo = loginedUser.getUsername();
		     session.setAttribute(Common.USER_SESSION, userInfo);
		     cthds=new ArrayList<CthoadonDTO>();
		     session.setAttribute(Common.Cart_SESSION, cthds);
		 }
		 cthds=(ArrayList<CthoadonDTO>) session.getAttribute(Common.Cart_SESSION);
		 for(int i=0;i<cthds.size();i++)
		 {
			 tonggiahd+=cthds.get(i).getTonggia();
		 }
		 map.addAttribute("tonggiahd", tonggiahd);
		 //Loaithanhtoan
		 List<LoaithanhtoanDTO> loaithanhtoan=new ArrayList<LoaithanhtoanDTO>();
		 loaithanhtoan=loaithanhtoanService.getList();
		 map.addAttribute("loaithanhtoan", loaithanhtoan);
		 return "guest/giohang";
	 }
	 @RequestMapping(value = "/delete_sphd/{id}", method = RequestMethod.GET)
	 public RedirectView delete_sphd(@PathVariable("id")int id,HttpSession session,
			 ModelMap map, 
			 Principal principal)
	 {
		 if(session.getAttribute(Common.USER_SESSION)==null)
		 {
			 return new RedirectView("/showHomepage");
		 }
		 ArrayList<CthoadonDTO> cthds;
		 cthds=(ArrayList<CthoadonDTO>) session.getAttribute(Common.Cart_SESSION);
		 for(int i=0;i<cthds.size();i++)
		 {
			 if(cthds.get(i).getSanpham().getIdsp()==id)
			 {
				 cthds.remove(i);
				 break;
			 }
		 }
		 
		 return new RedirectView("/showCart");
	 }
	 @RequestMapping(value = "/oderBill", method = RequestMethod.POST)
	 public RedirectView oderBill(@RequestParam(value = "ttoan",required = false,defaultValue="0")String ttoan,
			 HttpSession session,
			 ModelMap map, 
			 Principal principal)
	 {
		 if(session.getAttribute(Common.USER_SESSION)==null)
		 {
			 return new RedirectView("/showHomepage");
		 }
		 if(session.getAttribute(Common.Cart_SESSION)==null)
		 {
			 return new RedirectView("/showHomepage");
		 }
		 User loginedUser = (User) ((Authentication) principal).getPrincipal();
		 AppUserDTO userDTO=appuserService.getUser(loginedUser.getUsername());
		 //Tao HOADON
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date();  
		 HoadonDTO hd=new HoadonDTO();
		 hd.setTinhtrang(0); 
		 hd.setNgaymua(date);
		 Loaithanhtoan ltt=new Loaithanhtoan();
		 ltt.setIdthanhtoan(Integer.parseInt(ttoan));
		 hd.setLoaithanhtoan(ltt);
		 AppUser user=new AppUser(); 
		 user.setUserId(userDTO.getUserId());
		 hd.setUser(user);
		 //ADD HOADON
		 hoadonService.addHoadon(hd);
		 //GET HOADON VUA TAO
		 HoadonDTO dto=hoadonService.getNewestHoadon();
		 //TAO CTHOADON
		 ArrayList<CthoadonDTO> cthds;
		 cthds=(ArrayList<CthoadonDTO>) session.getAttribute(Common.Cart_SESSION);
		 //ADD CTHD
		 cthoadonService.addCt(dto, cthds);
		 //XOA SESSION
		 cthds.clear();
		 session.setAttribute(Common.Cart_SESSION,cthds);
		 return new RedirectView("/showHomepage"); 
	 }
	 @RequestMapping(value = "/showhoadon", method = RequestMethod.GET)
	 public String showhoadon(ModelMap map, 
			 HttpSession session,
			 Principal principal)
	 {
		 //Hinhanhtrang
		 List<HinhanhtrangDTO>listHinhanhtrang=new ArrayList<HinhanhtrangDTO>();
		 listHinhanhtrang=hinhanhtrangService.getAllHinhanhtrang();
		 map.addAttribute("hinhanhtrang", listHinhanhtrang.get(listHinhanhtrang.size()-1));
		 
		 //danhmucsanpham
		 List<DanhmucsanphamDTO>listDanhmucsanpham=new ArrayList<DanhmucsanphamDTO>();
		 listDanhmucsanpham=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsanpham", listDanhmucsanpham);
		 
		 //GET USER
		 User loginedUser = (User) ((Authentication) principal).getPrincipal();
		 AppUserDTO userDTO=appuserService.getUser(loginedUser.getUsername());
		 //GET HOADON USER
		 List<HoadonDTO> pendingHoadon=hoadonService.getCtPending(userDTO.getUserId());
		 List<HoadonDTO> confirmedHoadon=hoadonService.getCtConfirmed(userDTO.getUserId());
		 List<HoadonDTO> deletedHoadon=hoadonService.getCtDeleted(userDTO.getUserId());
		 map.addAttribute("pending", pendingHoadon);
		 map.addAttribute("confirmed",confirmedHoadon);
		 map.addAttribute("deleted",deletedHoadon);
		 return "guest/tinhtrangdonhanguser";
	 }
	 
	 @RequestMapping(value = "/showCthoadon/{id}", method = RequestMethod.GET)
	 public String showCthoadon(ModelMap map,@PathVariable("id")int idhd, 
			 HttpSession session,
			 Principal principal)
	 {
		//Hinhanhtrang
		 List<HinhanhtrangDTO>listHinhanhtrang=new ArrayList<HinhanhtrangDTO>();
		 listHinhanhtrang=hinhanhtrangService.getAllHinhanhtrang();
		 map.addAttribute("hinhanhtrang", listHinhanhtrang.get(listHinhanhtrang.size()-1));
		 //danhmucsanpham
		 List<DanhmucsanphamDTO>listDanhmucsanpham=new ArrayList<DanhmucsanphamDTO>();
		 listDanhmucsanpham=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsanpham", listDanhmucsanpham);
		 //ADD LIST CTHD
		 List<CthoadonDTO> cthds=cthoadonService.getCtbyIdHoadon(idhd);
		 map.addAttribute("cthd",cthds);
		 //TONG GIA
		 double tonggiahd=0;
		 for(int i=0;i<cthds.size();i++)
		 {
			 tonggiahd+=cthds.get(i).getTonggia();
		 }
		 map.addAttribute("tonggiahd", tonggiahd);
		 
		 return "guest/cthoadon";
	 }
	 
	 @RequestMapping(value = "/huyhoadon/{id}", method = RequestMethod.GET)
	 public RedirectView deleteHoadon(ModelMap map,@PathVariable("id")int idhd, 
			 HttpSession session,
			 Principal principal)
	 {
		 hoadonService.setState(idhd,Common.STATE_HOADON_HUY);
		 return new RedirectView("/showhoadon"); 
	 }
	 
	 
	 @RequestMapping(value = "/signup", method = RequestMethod.POST)
	 public RedirectView signup(
			 @RequestParam(value = "username", required = false) String username,
             @RequestParam(value = "password", required = false) String password,
             @RequestParam(value = "phone", required = false) String phone,
             @RequestParam(value = "identityCard", required = false) String identityCard,
	         @RequestParam(value = "address", required = false) String address)
	 {
		 AppUserDTO appuserDTO=new AppUserDTO();
		 appuserDTO.setUserName(username);
		 appuserDTO.setSdt_user(phone);
		 appuserDTO.setCmnd_user(identityCard);
		 appuserDTO.setDiachi(address);
		 String passenryted=EncrytedPasswordUtils.encrytePassword(password);
		 appuserDTO.setEncrytedPassword(passenryted);
		 appuserDTO.setEnabled(true);
		 appuserService.addUser(appuserDTO);
		 //ADD ROLE
		 AppUserDTO appuserDTObefore=appuserService.getUser(username);
		 userroleService.addRole(appuserDTObefore.getUserId(), Common.ROLE_USER);
		 return new RedirectView("/login");
	 }
	 
	 @RequestMapping(value = "/test", method = RequestMethod.GET)
	 public RedirectView test(
			 HttpSession session,
			 ModelMap map, 
			 Principal principal)
	 {
		List<CthoadonDTO> list=cthoadonService.getCtPending();
		System.out.print("TEST TEST "+String.valueOf(list.get(0).getTonggia()));
		return new RedirectView("/showHomepage");
	 }
}

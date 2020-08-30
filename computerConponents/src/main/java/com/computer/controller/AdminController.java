package com.computer.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.computer.entity.Chitietkythuat;
import com.computer.entity.Danhmucsanpham;
import com.computer.entity.Hangsanxuat;
import com.computer.entity.Hinhsanpham;
import com.computer.entity.Sanpham;
import com.computer.model.AppUserDTO;
import com.computer.model.ChitietkythuatDTO;
import com.computer.model.CthoadonDTO;
import com.computer.model.DanhmucsanphamDTO;
import com.computer.model.HangsanxuatDTO;
import com.computer.model.HinhsanphamDTO;
import com.computer.model.HoadonDTO;
import com.computer.model.SanphamDTO;
import com.computer.service.AppUserService;
import com.computer.service.ChitietkythuatService;
import com.computer.service.CthoadonService;
import com.computer.service.DanhmucsanphamService;
import com.computer.service.HoadonService;
import com.computer.service.SanphamService;
import com.computer.service.UserRoleService;
import com.computer.service.HangsanxuatService;
import com.computer.service.HinhsanphamService;
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
	
	@Autowired
	DanhmucsanphamService danhmucsanphamService;
	
	@Autowired
	HangsanxuatService hangsanxuatService;
	
	@Autowired
	ChitietkythuatService chitietkythuatService;
	
	@Autowired
	HinhsanphamService hinhsanphamService;
	
	@Autowired
	UserRoleService userroleService;
	
	//DUYET DON HANG
	@RequestMapping(value = "/duyetdonhang", method = RequestMethod.GET)
	public String duyedonhang(ModelMap map) {
		//GET HOADON
		List<HoadonDTO> dtos=hoadonService.getCtPending(Long.parseLong("-1"));
		map.addAttribute("dtos", dtos);
		return "admin/duyetdonhang";
	}
	
	//DON HANG DA DUYET
	@RequestMapping(value = "/donhangdaduyet", method = RequestMethod.GET)
	public String donhangdaduyet(ModelMap map) {
		List<HoadonDTO> dtos=hoadonService.getCtConfirmed(Long.parseLong("-1"));
		map.addAttribute("dtos", dtos);
		return "admin/donhangdaduyet";
	}
	
	//HUY DON HANG
	@RequestMapping(value = "/huydonhang", method = RequestMethod.GET)
	public String huydonhang(ModelMap map) {
		List<HoadonDTO> dtos=hoadonService.getCtDeleted(Long.parseLong("-1"));
		map.addAttribute("dtos", dtos);
		return "admin/huydonhang";
	}
	
	//XU LY DON HANG
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
	 @RequestMapping(value = "/danhsachsanpham", method = RequestMethod.GET)
	 public String danhsachsanpham(ModelMap map)
	 {
		 ArrayList<SanphamDTO>listSanpham=new ArrayList<SanphamDTO>();
		 listSanpham=sanphamService.getListSanpham(1, 20);
		 map.addAttribute("sanpham", listSanpham);
		 return "admin/danhsachsanpham";
	 }
	 @RequestMapping(value = "/addsanpham", method = RequestMethod.GET)
	 public String addsanpham(ModelMap map)
	 {
		 //NEW SP, NEW CATEGROY, NEWHANGSANXUAT
		 SanphamDTO sanphamDTO=new SanphamDTO();
		 Hangsanxuat hsx=new Hangsanxuat();
		 Danhmucsanpham dmsp=new Danhmucsanpham();
		 sanphamDTO.setIdhsx(hsx);
		 sanphamDTO.setDanhmucsp(dmsp);
		 map.addAttribute("sanpham",sanphamDTO);
		 //GET CATEGORY
		 List<DanhmucsanphamDTO> listdmsp=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsp", listdmsp);
		 //GET HSX
		 List<HangsanxuatDTO> listhsx=hangsanxuatService.getAll();
		 map.addAttribute("hangsanxuat", listhsx);
		 return "admin/themmoisanpham";
	 }
	 
	 @RequestMapping(value = "/addsanpham", method = RequestMethod.POST)
	 public RedirectView addsanpham(@ModelAttribute("sanpham")SanphamDTO sanphamDTO)
	 {
		 sanphamDTO.setSoluongsp(100);
		 sanphamService.addSp(sanphamDTO);
		 return new RedirectView("/admin/danhsachsanpham");
	 }
	 
	 @RequestMapping(value = "/editsanpham/{id}", method = RequestMethod.GET)
	 public String editsanpham(ModelMap map,@PathVariable("id")int idsp)
	 {
		//GET CATEGORY
		 List<DanhmucsanphamDTO> listdmsp=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsp", listdmsp);
		 //GET HSX
		 List<HangsanxuatDTO> listhsx=hangsanxuatService.getAll();
		 map.addAttribute("hangsanxuat", listhsx);
		 //GET SP
		 SanphamDTO sp=sanphamService.getById(idsp);
		 map.addAttribute("sanpham",sp);
		 //GET CHI TIET
		 List<Chitietkythuat> ctkt=sp.getChitietkythuat();
		 map.addAttribute("ctkt",ctkt);
		 //GET HINH ANH
		 List<Hinhsanpham> hinhsp=sp.getHinhsanpham();
		 map.addAttribute("hinhsp",hinhsp);
		 //GET ID
		 map.addAttribute("idsp", idsp);
		 return "admin/chitietsanpham";
	 }
	 @RequestMapping(value = "/addCtsp/{idsp}", method = RequestMethod.GET)
	 public RedirectView addCtsp(@RequestParam(value = "chitiet",required = false,defaultValue="")String chitiet,
			 @RequestParam(value = "mota",required = false,defaultValue="")String mota,
			 @PathVariable("idsp")int idsp)
	 {
		 ChitietkythuatDTO ctkt=new ChitietkythuatDTO();
		 ctkt.setTenkt(chitiet);
		 ctkt.setChitietkt(mota);
		 Sanpham sp=new Sanpham();
		 sp.setIdsp(idsp);
		 ctkt.setChitietkythuatsp(sp);
		 chitietkythuatService.addCtkt(ctkt);
		 return new RedirectView("/admin/editsanpham/"+idsp);
	 }
	 @RequestMapping(value = "/addhinh/{idsp}", method = RequestMethod.GET)
	 public RedirectView addhinh(@RequestParam(value = "urlhinh",required = false,defaultValue="")String url,
			 @PathVariable("idsp")int idsp)
	 {
		 HinhsanphamDTO hinh=new HinhsanphamDTO();
		 hinh.setUrlHinhsp(url);
		 Sanpham sp=new Sanpham();
		 sp.setIdsp(idsp);
		 hinh.setHinhsp(sp);
		 hinhsanphamService.addHinh(hinh);
		 return new RedirectView("/admin/editsanpham/"+idsp);
	 }
	 @RequestMapping(value = "/deletehsp/{idhsp}/{idsp}", method = RequestMethod.GET)
	 public RedirectView deletehsp(@PathVariable("idhsp")int idhsp,@PathVariable("idsp")int idsp)
	 {
		 hinhsanphamService.deleteHinh(idhsp);
		 return new RedirectView("/admin/editsanpham/"+idsp);
	 }
	 @RequestMapping(value = "/deletectsp/{idctsp}/{idsp}", method = RequestMethod.GET)
	 public RedirectView deletectsp(@PathVariable("idctsp")Long idctsp,@PathVariable("idsp")int idsp)
	 {
		 chitietkythuatService.deleteCtkt(idctsp);
		 return new RedirectView("/admin/editsanpham/"+idsp);
	 }
	 @RequestMapping(value = "/deletesanpham/{idsp}", method = RequestMethod.GET)
	 public RedirectView deletesp(@PathVariable("idsp")int idsp)
	 {
		 sanphamService.deleteSp(idsp);
		 return new RedirectView("/admin/danhsachsanpham");
	 }
	 //DANH MUC SAN PHAM
	 @RequestMapping(value = "/danhmucsanpham", method = RequestMethod.GET)
	 public String danhmucsp(ModelMap map)
	 {
		 List<DanhmucsanphamDTO> dmsp=danhmucsanphamService.getAllDanhmucsanpham();
		 map.addAttribute("danhmucsp", dmsp);
		 return "admin/danhmucsanpham";
	 }
	 @RequestMapping("/adddanhmuc")
	 public RedirectView adddanhmuc(@RequestParam(value = "tendm", required = false) String tendm)
	 {
		 if(tendm.isEmpty())
		 {
			 return new RedirectView("/admin/danhmucsanpham/");
		 }
		 danhmucsanphamService.addDanhmuc(tendm);
		 return new RedirectView("/admin/danhmucsanpham/");
	 }
	 //HANG SAN XUAT
	 @RequestMapping(value = "/hangsanxuat", method = RequestMethod.GET)
	 public String hangsanxuat(ModelMap map)
	 {
		 List<HangsanxuatDTO>hsx=hangsanxuatService.getAll();
		 map.addAttribute("hangsx", hsx);
		 return "admin/hangsanxuat";
	 }
	 @RequestMapping("/addhangsanxuat")
	 public RedirectView addhangsanxuat(@RequestParam(value = "tenhsx", required = false) String tenhsx)
	 {
		 if(tenhsx.isEmpty())
		 {
			 return new RedirectView("/admin/hangsanxuat/");
		 }
		 hangsanxuatService.addHangsanxuat(tenhsx);
		 return new RedirectView("/admin/hangsanxuat/");
	 }
	 
	 //NGUOI DUNG
	 @RequestMapping(value = "/danhsachnguoidung", method = RequestMethod.GET)
	 public String danhsachnguoidung(ModelMap map)
	 {
		 List<AppUserDTO> listUser=appuserService.getListUser();
		 map.addAttribute("listUser", listUser);
		 return "admin/danhsachnguoidung";
	 }
	 @RequestMapping("/deactiveUser/{idUser}")
	 public RedirectView deactiveUser(@PathVariable("idUser")Long idUser)
	 {
		 appuserService.deactiveUser(idUser);
		 return new RedirectView("/admin/danhsachnguoidung");
	 }
	 @RequestMapping("/activeUser/{idUser}")
	 public RedirectView activeUser(@PathVariable("idUser")Long idUser)
	 {
		 appuserService.activeUser(idUser);
		 return new RedirectView("/admin/danhsachnguoidung");
	 }
	 @RequestMapping("/infoUser/{idUser}")
	 public String infoUser(ModelMap map,@PathVariable("idUser")Long idUser)
	 {
		 AppUserDTO user=appuserService.getUser(idUser);
		 List<HoadonDTO>hoadon=hoadonService.getHDUser(user.getUserId());
		 map.addAttribute("user", user);
		 map.addAttribute("listhd", hoadon);
		 return "admin/infoUser";
	 }
	 @RequestMapping("/addAdmin/{idUser}")
	 public RedirectView addAdmin(@PathVariable("idUser")Long idUser)
	 {
		 userroleService.addRole(idUser, Common.ROLE_ADMIN);
		 return new RedirectView("/admin/danhsachnguoidung");
	 }
}

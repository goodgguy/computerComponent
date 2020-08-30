package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.HoadonDAO;
import com.computer.entity.Hoadon;
import com.computer.model.HoadonDTO;
import com.computer.service.HoadonService;

@Service
@org.springframework.transaction.annotation.Transactional
public class HoadonServiceImpl implements HoadonService{
	@Autowired
	private HoadonDAO hoadonDAO;

	@Override
	public void addHoadon(HoadonDTO hoadon) {
		Hoadon hd=new Hoadon();
		hd.setLoaithanhtoan(hoadon.getLoaithanhtoan());
		hd.setTinhtrang(hoadon.getTinhtrang());
		hd.setNgaymua(hoadon.getNgaymua());
		hd.setUser(hoadon.getUser());
		hoadonDAO.addHoadon(hd);
	}

	@Override
	public HoadonDTO getNewestHoadon() {
		Hoadon hd=hoadonDAO.getNewestHoadon();
		HoadonDTO dto=new HoadonDTO();
		dto.setIdhd(hd.getIdhd());
		dto.setLoaithanhtoan(hd.getLoaithanhtoan());
		dto.setTinhtrang(hd.getTinhtrang());
		dto.setNgaymua(hd.getNgaymua());
		dto.setUser(hd.getUser());
		return dto;
	}

	@Override
	public List<HoadonDTO> getCtPending(Long iduser) {
		List<Hoadon> listhoadon=hoadonDAO.getCtPending(iduser);
		List<HoadonDTO> dtos=new ArrayList<HoadonDTO>();
		for(Hoadon hd:listhoadon)
		{
			HoadonDTO dto=new HoadonDTO();
			dto.setIdhd(hd.getIdhd());
			dto.setTinhtrang(hd.getTinhtrang());
			dto.setNgaymua(hd.getNgaymua());
			dto.setLoaithanhtoan(hd.getLoaithanhtoan());
			dto.setUser(hd.getUser());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<HoadonDTO> getCtConfirmed(Long iduser) {
		List<Hoadon> listhoadon=hoadonDAO.getCtConfirmed(iduser);
		List<HoadonDTO> dtos=new ArrayList<HoadonDTO>();
		for(Hoadon hd:listhoadon)
		{
			HoadonDTO dto=new HoadonDTO();
			dto.setIdhd(hd.getIdhd());
			dto.setTinhtrang(hd.getTinhtrang());
			dto.setNgaymua(hd.getNgaymua());
			dto.setLoaithanhtoan(hd.getLoaithanhtoan());
			dto.setUser(hd.getUser());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void setState(int idhd, int state) {
		hoadonDAO.setState(idhd, state);
	}

	@Override
	public List<HoadonDTO> getCtDeleted(Long iduser) {
		List<Hoadon> listhoadon=hoadonDAO.getCtDeleted(iduser);
		List<HoadonDTO> dtos=new ArrayList<HoadonDTO>();
		for(Hoadon hd:listhoadon)
		{
			HoadonDTO dto=new HoadonDTO();
			dto.setIdhd(hd.getIdhd());
			dto.setTinhtrang(hd.getTinhtrang());
			dto.setNgaymua(hd.getNgaymua());
			dto.setLoaithanhtoan(hd.getLoaithanhtoan());
			dto.setUser(hd.getUser());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public HoadonDTO getById(int idhd) {
		Hoadon hd=hoadonDAO.getById(idhd);
		HoadonDTO dto=new HoadonDTO();
		dto.setIdhd(hd.getIdhd());
		dto.setTinhtrang(hd.getTinhtrang());
		dto.setNgaymua(hd.getNgaymua());
		dto.setLoaithanhtoan(hd.getLoaithanhtoan());
		dto.setUser(hd.getUser());
		return dto;
	}

	@Override
	public List<HoadonDTO> getHDUser(Long iduser) {
		List<Hoadon> listhoadon=hoadonDAO.getHDUser(iduser);
		List<HoadonDTO> dtos=new ArrayList<HoadonDTO>();
		for(Hoadon hd:listhoadon)
		{
			HoadonDTO dto=new HoadonDTO();
			dto.setIdhd(hd.getIdhd());
			dto.setTinhtrang(hd.getTinhtrang());
			dto.setNgaymua(hd.getNgaymua());
			dto.setLoaithanhtoan(hd.getLoaithanhtoan());
			dto.setUser(hd.getUser());
			dtos.add(dto);
		}
		return dtos;
	}

}

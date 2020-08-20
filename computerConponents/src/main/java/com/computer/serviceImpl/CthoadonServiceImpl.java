package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.CthoadonDAO;
import com.computer.entity.Cthoadon;
import com.computer.entity.Hoadon;
import com.computer.model.CthoadonDTO;
import com.computer.model.HoadonDTO;
import com.computer.service.CthoadonService;

@Service
@org.springframework.transaction.annotation.Transactional
public class CthoadonServiceImpl implements CthoadonService{
	
	@Autowired
	private CthoadonDAO cthoadonDAO;
	@Override
	public void addCt(HoadonDTO dto, ArrayList<CthoadonDTO> listcthoadondto) {
		Hoadon hd=new Hoadon();
		hd.setIdhd(dto.getIdhd());
		ArrayList<Cthoadon>listhoadon=new ArrayList<Cthoadon>();
		for(int i=0;i<listcthoadondto.size();i++)
		{
			CthoadonDTO cthoadondto=listcthoadondto.get(i);
			Cthoadon cthoadon=new Cthoadon();
			cthoadon.setSoluong(cthoadondto.getSoluong());
			cthoadon.setTonggia(cthoadondto.getTonggia());
			cthoadon.setHoadon(hd);
			cthoadon.setSanpham(cthoadondto.getSanpham());
			listhoadon.add(cthoadon);
		}
		cthoadonDAO.addCt(listhoadon);
	}
	@Override
	public List<CthoadonDTO> getCtPending() {
		List<Cthoadon>listcthoadon=cthoadonDAO.getCtPending();
		List<CthoadonDTO> dtos=new ArrayList<CthoadonDTO>();
		for(int i=0;i<listcthoadon.size();i++)
		{
			Cthoadon cthoadon=listcthoadon.get(i);
			CthoadonDTO dto=new CthoadonDTO();
			dto.setSoluong(cthoadon.getSoluong());
			dto.setTonggia(cthoadon.getTonggia());
			dto.setHoadon(cthoadon.getHoadon());
			dto.setSanpham(cthoadon.getSanpham());
			dto.setId(cthoadon.getId());
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public List<CthoadonDTO> getCtConfirmed() {
		List<Cthoadon>listcthoadon=cthoadonDAO.getCtConfirmed();
		List<CthoadonDTO> dtos=new ArrayList<CthoadonDTO>();
		for(int i=0;i<listcthoadon.size();i++)
		{
			Cthoadon cthoadon=listcthoadon.get(i);
			CthoadonDTO dto=new CthoadonDTO();
			dto.setSoluong(cthoadon.getSoluong());
			dto.setTonggia(cthoadon.getTonggia());
			dto.setHoadon(cthoadon.getHoadon());
			dto.setSanpham(cthoadon.getSanpham());
			dto.setId(cthoadon.getId());
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public List<CthoadonDTO> getCtbyIdHoadon(int idhd) {
		List<Cthoadon>listcthoadon=cthoadonDAO.getCtbyIdHoadon(idhd);
		List<CthoadonDTO> dtos=new ArrayList<CthoadonDTO>();
		for(int i=0;i<listcthoadon.size();i++)
		{
			Cthoadon cthoadon=listcthoadon.get(i);
			CthoadonDTO dto=new CthoadonDTO();
			dto.setSoluong(cthoadon.getSoluong());
			dto.setTonggia(cthoadon.getTonggia());
			dto.setHoadon(cthoadon.getHoadon());
			dto.setSanpham(cthoadon.getSanpham());
			dto.setId(cthoadon.getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public boolean checkQuantity(int idsp,int soluong)
	{
		return cthoadonDAO.checkQuantity(idsp,soluong);
	}
}

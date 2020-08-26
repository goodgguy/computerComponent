package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.SanphamDAO;
import com.computer.entity.Sanpham;
import com.computer.model.SanphamDTO;
import com.computer.service.CtkhuyenmaiService;
import com.computer.service.SanphamService;

@Service
@org.springframework.transaction.annotation.Transactional
public class SanphamServiceImpl implements SanphamService{
	@Autowired
	SanphamDAO sanphamDAO;
	
	@Autowired
	CtkhuyenmaiService ctkhuyenmaiService;
	
	@Override
	public ArrayList<SanphamDTO> getListSanpham(int pageNumber, int pageSize) {
		ArrayList<Sanpham> listSanpham=sanphamDAO.getListSanpham(pageNumber, pageSize);
		ArrayList<SanphamDTO> dtos=new ArrayList<SanphamDTO>();
		for(Sanpham sp:listSanpham)
		{
			SanphamDTO dto=new SanphamDTO();
			dto.setIdsp(sp.getIdsp());
			dto.setTensp(sp.getTensp());
			dto.setMotasp(sp.getMotasp());
			dto.setSoluongsp(sp.getSoluongsp());
			dto.setAnhchinh(sp.getAnhchinh());
			dto.setIdhsx(sp.getIdhsx());
			dto.setDanhmucsp(sp.getDanhmucsp());
			dto.setChitietkythuat(sp.getChitietkythuat());
			dto.setHinhsanpham(sp.getHinhsanpham());
			//Xu Lý DISCOUNT
			int discount=ctkhuyenmaiService.getDiscountProduct(sp.getIdsp());
			if(discount==0)
			{
				dto.setGiagoc(0);
				dto.setGiasp(sp.getGiasp());
			}else
			{
				double gia=sp.getGiasp();
				dto.setGiagoc(gia);
				dto.setGiasp(gia-(gia*discount)/100);
			}
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public SanphamDTO getById(int id) {
		Sanpham sp=sanphamDAO.getById(id);
		SanphamDTO dto=new SanphamDTO();
		dto.setIdsp(sp.getIdsp());
		dto.setTensp(sp.getTensp());
		dto.setMotasp(sp.getMotasp());
		dto.setSoluongsp(sp.getSoluongsp());
		dto.setAnhchinh(sp.getAnhchinh());
		dto.setIdhsx(sp.getIdhsx());
		dto.setDanhmucsp(sp.getDanhmucsp());
		dto.setChitietkythuat(sp.getChitietkythuat());
		dto.setHinhsanpham(sp.getHinhsanpham());
		//Xu Lý DISCOUNT
		int discount=ctkhuyenmaiService.getDiscountProduct(sp.getIdsp());
		if(discount==0)
		{
			dto.setGiagoc(0);
			dto.setGiasp(sp.getGiasp());
		}else
		{
			double gia=sp.getGiasp();
			dto.setGiagoc(gia);
			dto.setGiasp(gia-(gia*discount)/100);
		}
		return dto;
	}

	@Override
	public ArrayList<SanphamDTO> getListSanphamtheoCate(int id, int pageNumber, int pageSize) {
		ArrayList<Sanpham> listSanpham=sanphamDAO.getListSanphamtheoCate(id, pageNumber, pageSize);
		ArrayList<SanphamDTO> dtos=new ArrayList<SanphamDTO>();
		for(Sanpham sp:listSanpham)
		{
			SanphamDTO dto=new SanphamDTO();
			dto.setIdsp(sp.getIdsp());
			dto.setTensp(sp.getTensp());
			dto.setMotasp(sp.getMotasp());
			dto.setSoluongsp(sp.getSoluongsp());
			dto.setAnhchinh(sp.getAnhchinh());
			dto.setIdhsx(sp.getIdhsx());
			dto.setDanhmucsp(sp.getDanhmucsp());
			dto.setChitietkythuat(sp.getChitietkythuat());
			dto.setHinhsanpham(sp.getHinhsanpham());
			//Xu Lý DISCOUNT
			int discount=ctkhuyenmaiService.getDiscountProduct(sp.getIdsp());
			if(discount==0)
			{
				dto.setGiagoc(0);
				dto.setGiasp(sp.getGiasp());
			}else
			{
				double gia=sp.getGiasp();
				dto.setGiagoc(gia);
				dto.setGiasp(gia-(gia*discount)/100);
			}
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public boolean truSoluong(SanphamDTO spdto, int soluong) {
		Sanpham sp=new Sanpham();
		sp.setIdsp(spdto.getIdsp());
		sp.setTensp(spdto.getTensp());
		sp.setMotasp(spdto.getMotasp());
		sp.setSoluongsp(spdto.getSoluongsp());
		sp.setAnhchinh(spdto.getAnhchinh());
		sp.setIdhsx(spdto.getIdhsx());
		sp.setDanhmucsp(spdto.getDanhmucsp());
		sp.setChitietkythuat(spdto.getChitietkythuat());
		sp.setHinhsanpham(spdto.getHinhsanpham());
		sanphamDAO.truSoluong(sp, soluong);
		return true;
	}

	@Override
	public boolean congSoluong(SanphamDTO spdto, int soluong) {
		Sanpham sp=new Sanpham();
		sp.setIdsp(spdto.getIdsp());
		sp.setTensp(spdto.getTensp());
		sp.setMotasp(spdto.getMotasp());
		sp.setSoluongsp(spdto.getSoluongsp());
		sp.setAnhchinh(spdto.getAnhchinh());
		sp.setIdhsx(spdto.getIdhsx());
		sp.setDanhmucsp(spdto.getDanhmucsp());
		sp.setChitietkythuat(spdto.getChitietkythuat());
		sp.setHinhsanpham(spdto.getHinhsanpham());
		sanphamDAO.congSoluong(sp, soluong);
		return true;
	}

	@Override
	public boolean addSp(SanphamDTO spdto) {
		Sanpham sp=new Sanpham();
		sp.setIdsp(spdto.getIdsp());
		sp.setTensp(spdto.getTensp());
		sp.setMotasp(spdto.getMotasp());
		sp.setSoluongsp(spdto.getSoluongsp());
		sp.setAnhchinh(spdto.getAnhchinh());
		sp.setIdhsx(spdto.getIdhsx());
		sp.setDanhmucsp(spdto.getDanhmucsp());
		sp.setChitietkythuat(spdto.getChitietkythuat());
		sp.setHinhsanpham(spdto.getHinhsanpham());
		sp.setGiasp(spdto.getGiasp());
		sanphamDAO.addSp(sp);
		return true;
	}

}

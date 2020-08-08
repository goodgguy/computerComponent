package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.SanphamDAO;
import com.computer.entity.Sanpham;
import com.computer.model.SanphamDTO;
import com.computer.service.SanphamService;

@Service
@org.springframework.transaction.annotation.Transactional
public class SanphamServiceImpl implements SanphamService{
	@Autowired
	SanphamDAO sanphamDAO;
	
	@Override
	public ArrayList<SanphamDTO> getListSanpham(int pageNumber, int pageSize) {
		ArrayList<Sanpham> listSanpham=sanphamDAO.getListSanpham(pageNumber, pageSize);
		ArrayList<SanphamDTO> dtos=new ArrayList<SanphamDTO>();
		for(Sanpham sp:listSanpham)
		{
			SanphamDTO dto=new SanphamDTO();
			dto.setIdsp(sp.getIdsp());
			dto.setTensp(sp.getTensp());
			dto.setGiasp(sp.getGiasp());
			dto.setMotasp(sp.getMotasp());
			dto.setSoluongsp(sp.getSoluongsp());
			dto.setAnhchinh(sp.getAnhchinh());
			dto.setIdhsx(sp.getIdhsx());
			dto.setDanhmucsp(sp.getDanhmucsp());
			dto.setChitietkythuat(sp.getChitietkythuat());
			dto.setHinhsanpham(sp.getHinhsanpham());
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
		dto.setGiasp(sp.getGiasp());
		dto.setMotasp(sp.getMotasp());
		dto.setSoluongsp(sp.getSoluongsp());
		dto.setAnhchinh(sp.getAnhchinh());
		dto.setIdhsx(sp.getIdhsx());
		dto.setDanhmucsp(sp.getDanhmucsp());
		dto.setChitietkythuat(sp.getChitietkythuat());
		dto.setHinhsanpham(sp.getHinhsanpham());
		return dto;
	}

}

package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.DanhmucsanphamDAO;
import com.computer.entity.Danhmucsanpham;
import com.computer.model.DanhmucsanphamDTO;
import com.computer.service.DanhmucsanphamService;

@Service
@org.springframework.transaction.annotation.Transactional
public class DanhmucsanphamServiceImpl implements DanhmucsanphamService{
	
	@Autowired 
	private DanhmucsanphamDAO danhmucsanphamDAO;
	
	@Override
	public List<DanhmucsanphamDTO> getAllDanhmucsanpham() {
		List<Danhmucsanpham> danhmucsanpham=danhmucsanphamDAO.getAllDanhmucsanpham();
		List<DanhmucsanphamDTO> dtos=new ArrayList<DanhmucsanphamDTO>();
		for(Danhmucsanpham e:danhmucsanpham)
		{
			DanhmucsanphamDTO dto=new DanhmucsanphamDTO();
			dto.setIddanhmucsp(e.getIddanhmucsp());
			dto.setTendanhmucsp(e.getTendanhmucsp());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public boolean addDanhmuc(String tendm) {
		Danhmucsanpham dmsp=new Danhmucsanpham();
		dmsp.setTendanhmucsp(tendm);
		danhmucsanphamDAO.addDanhmuc(dmsp);
		return false;
	}

}

package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.HangsanxuatDAO;
import com.computer.entity.Hangsanxuat;
import com.computer.model.HangsanxuatDTO;
import com.computer.service.HangsanxuatService;

@Service
@org.springframework.transaction.annotation.Transactional
public class HangsanxuatServiceImpl implements HangsanxuatService{
	@Autowired
	HangsanxuatDAO hangsanxuatDAO;
	@Override
	public List<HangsanxuatDTO> getAll() {
		List<Hangsanxuat> hangsanxuat=hangsanxuatDAO.getAll();
		List<HangsanxuatDTO> dtos=new ArrayList<HangsanxuatDTO>();
		for(Hangsanxuat e:hangsanxuat)
		{
			HangsanxuatDTO dto=new HangsanxuatDTO();
			dto.setIdhsx(e.getIdhsx());
			dto.setTenhsx(e.getTenhsx());
			dto.setSanpham(e.getSanpham());
			dtos.add(dto);
		}
		return dtos;
	}
	
}

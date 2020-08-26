package com.computer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.HinhsanphamDAO;
import com.computer.entity.Hinhsanpham;
import com.computer.model.HinhsanphamDTO;
import com.computer.service.HinhsanphamService;

@Service
@org.springframework.transaction.annotation.Transactional
public class HinhsanphamServiceImpl implements HinhsanphamService{
	@Autowired
	HinhsanphamDAO hinhsanphamDAO;
	
	@Override
	public boolean addHinh(HinhsanphamDTO dto) {
		Hinhsanpham hinh=new Hinhsanpham();
		hinh.setHinhsp(dto.getHinhsp());
		hinh.setUrlHinhsp(dto.getUrlHinhsp());
		hinhsanphamDAO.addHinh(hinh);
		return false;
	}

}

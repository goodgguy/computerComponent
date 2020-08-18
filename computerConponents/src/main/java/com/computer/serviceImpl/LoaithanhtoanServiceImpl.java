package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.LoaithanhtoanDAO;
import com.computer.entity.Loaithanhtoan;
import com.computer.model.LoaithanhtoanDTO;
import com.computer.service.LoaithanhtoanService;

@Service
@org.springframework.transaction.annotation.Transactional
public class LoaithanhtoanServiceImpl implements LoaithanhtoanService{
	@Autowired 
	private LoaithanhtoanDAO loaithanhtoanDAO;
	
	
	@Override
	public List<LoaithanhtoanDTO> getList() {
		List<Loaithanhtoan> loaithanhtoan=loaithanhtoanDAO.getList();
		List<LoaithanhtoanDTO> dtos=new ArrayList<LoaithanhtoanDTO>();
		for(Loaithanhtoan e:loaithanhtoan)
		{
			LoaithanhtoanDTO dto=new LoaithanhtoanDTO();
			dto.setIdthanhtoan(e.getIdthanhtoan());
			dto.setHoadon(e.getHoadon());
			dto.setTenloaithanhtoan(e.getLoaithanhtoan());
			dtos.add(dto);
		}
		return dtos;
	}

}

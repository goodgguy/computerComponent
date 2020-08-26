package com.computer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.ChitietkythuatDAO;
import com.computer.entity.Chitietkythuat;
import com.computer.model.ChitietkythuatDTO;
import com.computer.service.ChitietkythuatService;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChitietkythuatServiceImpl implements ChitietkythuatService{
	
	@Autowired
	ChitietkythuatDAO chitietkythuatDAO;
	
	@Override
	public boolean addCtkt(ChitietkythuatDTO dto) {
		Chitietkythuat ctkt=new Chitietkythuat();
		ctkt.setTenkt(dto.getTenkt());
		ctkt.setChitietkt(dto.getChitietkt());
		ctkt.setChitietkythuatsp(dto.getChitietkythuatsp());
		chitietkythuatDAO.addCtkt(ctkt);
		return true;
	}

}

package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.HinhanhtrangDAO;
import com.computer.entity.Hinhanhtrang;
import com.computer.model.HinhanhtrangDTO;
import com.computer.service.HinhanhtrangService;

@Service
@org.springframework.transaction.annotation.Transactional
public class HinhanhtrangServiceImpl implements HinhanhtrangService{
	@Autowired 
	private HinhanhtrangDAO hinhanhtrangDAO;

	@Override
	public List<HinhanhtrangDTO> getAllHinhanhtrang() {
		// TODO Auto-generated method stub
		List<Hinhanhtrang> hinhanhtrang=hinhanhtrangDAO.getAllHinhanhtrang();
		List<HinhanhtrangDTO> dtos=new ArrayList<HinhanhtrangDTO>();
		for(Hinhanhtrang e:hinhanhtrang)
		{
			HinhanhtrangDTO dto=new HinhanhtrangDTO();
			dto.setIdHinh(e.getIdhinh());
			dto.setFooter1(e.getHinhfooter1());
			dto.setFooter2(e.getHinhfooter2());
			dto.setFooter3(e.getHinhfooter3());
			dto.setHeader1(e.getHinhheader1());
			dto.setHeader2(e.getHinhheader2());
			dto.setHinhslideshow1(e.getHinhslideshow1());
			dto.setHinhslideshow2(e.getHinhslideshow2());
			dto.setHinhslideshow3(e.getHinhslideshow3());
			dto.setHinhslideshow4(e.getHinhslideshow4());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void addHinhanhtrang(HinhanhtrangDTO hinhanh) {
		// TODO Auto-generated method stub
		Hinhanhtrang hh=new Hinhanhtrang();
		hh.setHinhfooter1(hinhanh.getFooter1());
		hh.setHinhfooter2(hinhanh.getFooter2());
		hh.setHinhfooter3(hinhanh.getFooter3());
		hh.setHinhheader1(hinhanh.getHeader1());
		hh.setHinhheader1(hinhanh.getHeader2());
		hh.setHinhslideshow1(hinhanh.getHinhslideshow1());
		hh.setHinhslideshow2(hinhanh.getHinhslideshow2());
		hh.setHinhslideshow3(hinhanh.getHinhslideshow3());
		hh.setHinhslideshow4(hinhanh.getHinhslideshow4());
		hinhanhtrangDAO.addHinhanhtrang(hh);
		
	}

	@Override
	public void deleteHinhanhtrang(int id) {
		// TODO Auto-generated method stub
		Hinhanhtrang hh=hinhanhtrangDAO.getHinhanhtrang(id);
		if(hh!=null)
		{
			hinhanhtrangDAO.deleteHinhanhtrang(hh);
		}
	}

	@Override
	public void updateHinhanhtrang(HinhanhtrangDTO hinhanh) {
		// TODO Auto-generated method stub
		Hinhanhtrang hh=hinhanhtrangDAO.getHinhanhtrang(hinhanh.getIdHinh());
		if(hh!=null)
		{
			hh.setHinhfooter1(hinhanh.getFooter1());
			hh.setHinhfooter2(hinhanh.getFooter2());
			hh.setHinhfooter3(hinhanh.getFooter3());
			hh.setHinhheader1(hinhanh.getHeader1());
			hh.setHinhheader1(hinhanh.getHeader2());
			hh.setHinhslideshow1(hinhanh.getHinhslideshow1());
			hh.setHinhslideshow2(hinhanh.getHinhslideshow2());
			hh.setHinhslideshow3(hinhanh.getHinhslideshow3());
			hh.setHinhslideshow4(hinhanh.getHinhslideshow4());
			hinhanhtrangDAO.updatehinhanhtrang(hh);
		}
	}
}

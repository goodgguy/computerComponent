package com.computer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.daoImpl.AppUserDAO;
import com.computer.entity.AppUser;
import com.computer.model.AppUserDTO;
import com.computer.service.AppUserService;

@Service
@org.springframework.transaction.annotation.Transactional
public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserDAO appuserDAO;
	@Override
	public AppUserDTO getUser(String username) {
		AppUser user=appuserDAO.getUser(username);
		AppUserDTO dto=new AppUserDTO();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setEncrytedPassword(user.getEncrytedPassword());
		dto.setEnabled(user.isEnabled());
		dto.setSdt_user(user.getSdt_user());
		dto.setCmnd_user(user.getCmnd_user());
		dto.setDiachi(user.getDiachi());
		dto.setHoadon(user.getHoadon());
		return dto;
	}
	@Override
	public boolean addUser(AppUserDTO dto) {
		AppUser user=new AppUser();
		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setEncrytedPassword(dto.getEncrytedPassword());
		user.setEnabled(dto.isEnabled());
		user.setSdt_user(dto.getSdt_user());
		user.setCmnd_user(dto.getCmnd_user());
		user.setDiachi(dto.getDiachi());
		user.setHoadon(dto.getHoadon());
		appuserDAO.addUser(user);
		return true;
	}

}

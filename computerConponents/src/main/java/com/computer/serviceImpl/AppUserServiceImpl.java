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

}

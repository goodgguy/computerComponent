package com.computer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.UserRoleDAO;
import com.computer.entity.AppRole;
import com.computer.entity.AppUser;
import com.computer.entity.UserRole;
import com.computer.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	UserRoleDAO userroleDAO;
	
	@Override
	public boolean addRole(Long userId, Long roleId) {
		UserRole userrole=new UserRole();
		AppUser appuser=new AppUser();
		AppRole approle=new AppRole();
		appuser.setUserId(userId);
		approle.setRoleId(roleId);
		userrole.setAppRole(approle);
		userrole.setAppUser(appuser);
		userroleDAO.addRole(userrole);
		return true;
	}

}

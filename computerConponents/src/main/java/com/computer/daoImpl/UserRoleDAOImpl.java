package com.computer.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.UserRoleDAO;
import com.computer.entity.UserRole;

@Transactional
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean addRole(UserRole userrole) {
		entityManager.persist(userrole);
		return false;
	}
	
}

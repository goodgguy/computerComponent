package com.computer.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.ChitietkythuatDAO;
import com.computer.entity.Chitietkythuat;

@Transactional
@Repository
public class ChitietkythuatDAOImpl implements ChitietkythuatDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean addCtkt(Chitietkythuat ctkt) {
		entityManager.persist(ctkt);
		return true;
	}

	@Override
	public boolean deleteCtkt(Chitietkythuat ctkt) {
		entityManager.remove(entityManager.contains(ctkt) ? ctkt : entityManager.merge(ctkt));
		return false;
	}

}

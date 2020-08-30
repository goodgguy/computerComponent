package com.computer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.HangsanxuatDAO;
import com.computer.entity.Hangsanxuat;

@Transactional
@Repository
public class HangsanxuatDAOImpl implements HangsanxuatDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Hangsanxuat> getAll() {
		String jql="SELECT e FROM Hangsanxuat e";
		return entityManager.createQuery(jql,Hangsanxuat.class).getResultList();
	}

	@Override
	public boolean addHangsanxuat(Hangsanxuat hsx) {
		entityManager.persist(hsx);
		return false;
	}

}

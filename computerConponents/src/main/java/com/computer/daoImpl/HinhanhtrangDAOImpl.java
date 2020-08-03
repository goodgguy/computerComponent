package com.computer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.HinhanhtrangDAO;
import com.computer.entity.Hinhanhtrang;

@Transactional
@Repository
public class HinhanhtrangDAOImpl implements HinhanhtrangDAO{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Hinhanhtrang> getAllHinhanhtrang() {
		String jql="SELECT e FROM Hinhanhtrang e";
		return entityManager.createQuery(jql,Hinhanhtrang.class).getResultList();
	}

	@Override
	public void addHinhanhtrang(Hinhanhtrang hinhanh) {
		// TODO Auto-generated method stub
		entityManager.persist(hinhanh);		
	}

	@Override
	public void deleteHinhanhtrang(Hinhanhtrang hinhanh) {
		// TODO Auto-generated method stub
		entityManager.remove(hinhanh);
	}

	@Override
	public void updatehinhanhtrang(Hinhanhtrang hinhanh) {
		// TODO Auto-generated method stub
		entityManager.merge(hinhanh);
		
	}

	@Override
	public Hinhanhtrang getHinhanhtrang(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Hinhanhtrang.class,id);
	}
	
}

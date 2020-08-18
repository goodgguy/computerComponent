package com.computer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.LoaithanhtoanDAO;
import com.computer.entity.Loaithanhtoan;

@Transactional
@Repository
public class LoaithanhtoanDAOImpl implements LoaithanhtoanDAO{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Loaithanhtoan> getList() {
		String jql="SELECT e FROM Loaithanhtoan e";
		return entityManager.createQuery(jql,Loaithanhtoan.class).getResultList();
	}

}

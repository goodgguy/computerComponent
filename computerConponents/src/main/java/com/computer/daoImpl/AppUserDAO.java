package com.computer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.computer.entity.AppUser;
@Repository
@Transactional
public class AppUserDAO {
	 
    @Autowired
    private EntityManager entityManager;
 
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
 
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public AppUser getUser(String username)
    {
    	Query query = entityManager.createQuery("Select e from AppUser e Where e.userName= :name",AppUser.class);
    	query.setParameter("name",username);
    	AppUser appuser=(AppUser) query.getSingleResult();
    	return appuser;
    }
    public AppUser getUser(Long id)
    {
    	Query query = entityManager.createQuery("Select e from AppUser e Where e.userId= :id",AppUser.class);
    	query.setParameter("id",id);
    	AppUser appuser=(AppUser) query.getSingleResult();
    	return appuser;
    }
    
    public boolean addUser(AppUser user)
    {
    	entityManager.persist(user);
    	return true;
    }
    public List<AppUser> getlistUser()
    {
    	String jql="SELECT e FROM AppUser e";
    	return entityManager.createQuery(jql,AppUser.class).getResultList();
    }
    public boolean deactiveUser(Long idUser)
    {
    	String jql="UPDATE AppUser e SET e.enabled= false WHERE e.userId="+idUser;
    	Query query = entityManager.createQuery(jql);
		query.executeUpdate();
    	return true;
    }
    public boolean activeUser(Long idUser)
    {
    	String jql="UPDATE AppUser e SET e.enabled= true WHERE e.userId="+idUser;
    	Query query = entityManager.createQuery(jql);
		query.executeUpdate();
    	return true;
    }
}


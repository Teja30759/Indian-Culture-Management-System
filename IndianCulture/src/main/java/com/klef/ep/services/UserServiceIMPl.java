package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.User;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserServiceIMPl implements UserService{

	@Override
	public int adduser(User user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return 1;
		
	}

	@Override
	public User checkuserlogin(String email, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select u from User u where u.email=? and u.password=?");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		
		User use = null;
		if(qry.getResultList().size()>0)
		{
			use = (User) qry.getSingleResult();
		}
		em.close();
		emf.close();
		
		return use;
	}

	@Override
	public void changepass(String email, String password) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    // Begin transaction
	    em.getTransaction().begin();

	    // Create update query
	    Query qry = em.createQuery("update User u set u.password=:password where u.email=:email");
	    qry.setParameter("password", password);
	    qry.setParameter("email", email);

	    // Execute update query
	    int updatedCount = qry.executeUpdate();

	    // Commit transaction
	    em.getTransaction().commit();

	    // Check if any rows were updated
	    if (updatedCount > 0) {
	        System.out.println("Password updated successfully.");
	    } else {
	        System.out.println("No user found with the given email.");
	    }

	    em.close();
	    emf.close();
	}


}

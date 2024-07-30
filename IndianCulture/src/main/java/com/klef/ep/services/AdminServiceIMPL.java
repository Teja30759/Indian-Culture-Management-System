package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.User;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceIMPL  implements AdminService{

	@Override
	public Admin checkadminlogin(String username, String password) {
        
		   EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		    EntityManager em = emf.createEntityManager();
		    
		    // a is an alias of Admin Class
		    Query qry = em.createQuery("select a from Admin a where a.username=? and a.password=?  ");
		    qry.setParameter(1, username);
		    qry.setParameter(2, password);
		    
		        Admin admin = null;
		        
		        if(qry.getResultList().size()>0)
		        {
		          admin = (Admin) qry.getSingleResult();
		        }
		    em.close();
		    emf.close();
		    
		    return admin;
		
		
	}

	@Override
	public List<User> viewallusers() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select u from  User u");
	    // e is an alias of Employee Class
	    List<User> userlist = qry.getResultList();
	    
	      em.close();
	      emf.close();
	      
	      return userlist;
	}

	@Override
	public void changepass(String username, String password) {
		// TODO Auto-generated method stub
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();

	    // Begin transaction
	    em.getTransaction().begin();

	    // Create update query
	    Query qry = em.createQuery("update Admin u set u.password=:password where u.username=:username");
	    qry.setParameter("password", password);
	    qry.setParameter("username", username);

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

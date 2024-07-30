package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Places;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PlacesServiceIMPL implements PlacesService {

	@Override
	public int addplace(Places place) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(place);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return 1;
		
	}

	@Override
	public List<Places> viewallplaces() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();

		Query qry = em.createQuery("select p from Places p");
		

		List<Places> plclist = qry.getResultList();
		
		em.close();
		emf.close();
		
		
		return plclist;
	}

	@Override
	public String deleteplace(String pname) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Places p = em.find(Places.class, pname);
		em.remove(p);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Place Deleted SuccessFully";
	}

	@Override
	public Places viewplacebyname(String pname) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		

		Places p = em.find(Places.class, pname);
		
		if(p == null)
		{
			em.close();
			emf.close();
			return null;
		}
		
		em.close();
		emf.close();
		return p;
	}

	@Override
	public String updateplace(Places place) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Places p = em.find(Places.class, place.getName());
		p.setState(place.getState());
		p.setDes(place.getDes());
		p.setHistoricalsig(place.getHistoricalsig());
		p.setBesttimetovisit(place.getBesttimetovisit());
		
		em.getTransaction().commit();
		em.close();
		emf.close();

		
		return "places Updated";
	}

}

package com.jsp.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Hospital;

public class HospitalDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void createHospital(Hospital hospital)
	{
		
		transaction.begin();
		manager.persist(hospital);
		transaction.commit();
	}
	
	public void updateHospitalName(int id, String name)
	{
		
		Hospital hospital = manager.find(Hospital.class, id);
		if (hospital != null) {
			transaction.begin();
			hospital.setHName(name);
			manager.merge(hospital);
			transaction.commit();
		}
		
	}
	
	public void removeHospital(int id)
	{
		    
		    Hospital hospital = manager.find(Hospital.class, id);
		    if (hospital != null) {
		    	
		    	transaction.begin();
				manager.remove(hospital);
				transaction.commit();
			}
	        
	}
	
	public void displayHospitalDetailsByName(String name)
	{
		Query q = manager.createQuery("select h from Hospital h where h.HName = ?1");
		q.setParameter(1, name);
		List<Hospital> hospital = q.getResultList();
		
		for (Hospital h: hospital)
		{
			System.out.println(h.getHos_id());
			System.out.println(h.getHName());
			System.out.println(h.getHCity());
			System.out.println(h.getHAdress());	
		}
		
	}
	
	public void displayAllHospitalDetails()
	{
		Query q = manager.createQuery("select h from Hospital h");
		List<Hospital> hospital = q.getResultList();
		
		for (Hospital h: hospital)
		{
			System.out.println(h.getHos_id());
			System.out.println(h.getHName());
			System.out.println(h.getHCity());
			System.out.println(h.getHAdress());	
		}
	}
	
}

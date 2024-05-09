package com.jsp.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Doctor;
import com.jsp.DTO.Hospital;
import com.jsp.DTO.Patient;

public class PatientDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void createPatient(int hospitalId, Patient patient)
	{
		Hospital hospital = manager.find(Hospital.class, hospitalId);
		if (hospital != null) {
			List<Patient> patientList = new ArrayList<Patient>();
			patientList.add(patient);
			
			transaction.begin();
			hospital.setPatient(patientList);
			patient.setHospital(hospital);
			manager.persist(patient);
			System.out.println("Welcome Name: "+patient.getPName()+" to "+hospitalId);
			transaction.commit();
		}
		else
		{
			System.out.println("Hospital with ID " + hospitalId + " not found.");
		}
	
	}
	
	public void removePatientById(int id)
	{
		Patient patient = manager.find(Patient.class, id);
		if (patient != null)
		{
			transaction.begin();
			manager.remove(patient);
			System.out.println("Patient with Id: " +id+ " removed successfully");
			
		}
		else
		{
			System.out.println("Patient with Id: "+id+" not found ");
		}
	}
	
	public void displayPatientIdByName(String name)
	{
		Query q = manager.createQuery("select p from Patient p where p.PName = ?1");
		q.setParameter(1, name);
		List<Patient> patient = q.getResultList();
		
		for(Patient p: patient)
		{
			System.out.println(p.getP_id());
			System.out.println(p.getPName());
			System.out.println(p.getPDiagnosis());
			System.out.println(p.getPAddress());
		}
	}
	
	public void displayAllPatientDetails()
	{
		Query q = manager.createQuery("select p from Patient p");
		List<Patient> patient = q.getResultList();
		
		 for (Patient p: patient)
		 {
			    System.out.println(p.getP_id());
				System.out.println(p.getPName());
				System.out.println(p.getPDiagnosis());
				System.out.println(p.getPAddress());
		 }
	}
}

package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Doctor;
import com.jsp.DTO.Hospital;

public class DoctorDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	public void createDoctor(int hospitalId, Doctor doctor)
	{
		Hospital hospital = manager.find(Hospital.class, hospitalId);
		if (hospital != null) {
			List<Doctor> doctorList = new ArrayList<Doctor>();
			doctorList.add(doctor);
			
			transaction.begin();
			hospital.setDoctor(doctorList);
			doctor.setHospital(hospital);
			manager.persist(doctor);
			System.out.println("Welcome Dr."+doctor.getDName()+" to "+hospitalId);
			transaction.commit();
		}
		else
		{
			System.out.println("Hospital with ID " + hospitalId + " not found.");
		}
		
	}
	
	public void updateDoctorSalaryById(int id, double salary)
	{
		Doctor doctor = manager.find(Doctor.class, id);
		if (doctor != null) {
			transaction.begin();
			doctor.setDSalary(salary);
			manager.merge(doctor);
			System.out.println("Doctor with Salary" +doctor.getDSalary()+ " to "+id );
			transaction.commit();
			
		}
		else
		{
			System.out.println("Doctor with ID " + id + " not found.");
		}
	}
	public void removeDoctor(int id)
	{
		Doctor doctor = manager.find(Doctor.class, id);
		if (doctor != null) {
			
			transaction.begin();
			manager.remove(doctor);
			System.out.println("Doctor with Id "+id+ " removed Successfully");
			transaction.commit();
		}
		else
		{
			System.out.println("Doctor with Id "+id+ " not found ");
		}
	}
	
	public void displayDoctorDetailsByName(String name)
	{
		Query q = manager.createQuery("select d from Doctor d where d.DName = ?1");
		q.setParameter(1, name);
		List<Doctor> doctor = q.getResultList();
		
		for (Doctor d: doctor)
		{
			System.out.println(d.getDoc_id());
			System.out.println(d.getDName());
			System.out.println(d.getDQualification());
			System.out.println(d.getDSalary());
		}
		
				
	}
	
	public void displayAllDoctorDetailsBySpecificHospital(int hospitalId)
	{
		transaction.begin();
		Query q = manager.createQuery("select d from Doctor d, Hospital h where h.Hos_id = ?1 ");
		q.setParameter(1, hospitalId);
		List<Doctor> doctor = q.getResultList();
		transaction.commit();
		
		if (!doctor.isEmpty()) {
			for (Doctor d: doctor)
			{
				System.out.println("Doctor Id: " + d.getDoc_id());
				System.out.println("Doctor Name: " + d.getDName());
				System.out.println("Doctor Qualification: " + d.getDQualification());
				System.out.println("Doctor Salary: " + d.getDSalary());
			}
		}
		else
		{
			System.out.println("No doctors found for the specified hospital ID: " + hospitalId);
		}
	}
}

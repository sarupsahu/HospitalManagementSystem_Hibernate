package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.MedicalRecord;
import com.jsp.DTO.Patient;

public class MedicalRecordDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void addMedicalRecord(int patientId, MedicalRecord medicalrecord)
	{
		Patient patient = manager.find(Patient.class, patientId);
		if (patient != null)
		{
			List<MedicalRecord> medicalrecordList = new ArrayList<MedicalRecord>();
			medicalrecordList.add(medicalrecord);
			
			transaction.begin();
			patient.setMedicalrecord(medicalrecordList);
			medicalrecord.setPatient(patient);
			manager.persist(medicalrecord);
			System.out.println("Record Name: "+patient.getPName()+" Added successfully ");
			transaction.commit();
		}
		else
		{
			System.out.println("Patient with name "+patientId+"not found");
		}		
		
	}
	
	public void updateDOE(int id, String DOE)
	{
		Query q = manager.createQuery("update medicalrecord m set m.Date_of_examination=:DOE where m.id =: id");
		q.setParameter(1, DOE);
		q.setParameter(1, id);
		
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}
	
	public void removeMedicalRecord(int id)
	{
		MedicalRecord medicalrecord = manager.find(MedicalRecord.class, id);
		
		if (medicalrecord != null)
		{
			transaction.begin();
			manager.remove(medicalrecord);
			transaction.commit();
			
		}
	}
	
	public void displayMedicalRecordByPatient(int patientId)
	{
		 transaction.begin();
	        Query query = manager.createQuery("select m from MedicalRecord m where m.patient.id = :patientId");
	        query.setParameter("patientId", patientId);
	        List<MedicalRecord> medicalRecords = query.getResultList();
	        transaction.commit();

	        if (!medicalRecords.isEmpty()) {
	            for (MedicalRecord medicalRecord : medicalRecords) {
	                System.out.println("Medical Record ID: " + medicalRecord.getRecord_id());
	                System.out.println("Medical Problem of Patient: " + medicalRecord.getProblem());
	                System.out.println("Medical Date of Examination: " + medicalRecord.getDate_of_examination());
	                
	            }
	        } 
	        else
	        {
	            System.out.println("No medical records found for the specified patient ID: " + patientId);
	        }
	}
	
}

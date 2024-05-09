package com.jsp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MedicalRecord {
		
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Record_id;
	private String Problem;
	private String Date_of_examination;
	
	
	@ManyToOne
	Patient patient;


	public int getRecord_id() {
		return Record_id;
	}


	public void setRecord_id(int record_id) {
		Record_id = record_id;
	}


	public String getProblem() {
		return Problem;
	}


	public void setProblem(String problem) {
		Problem = problem;
	}


	public String getDate_of_examination() {
		return Date_of_examination;
	}


	public void setDate_of_examination(String date_of_examination) {
		Date_of_examination = date_of_examination;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}

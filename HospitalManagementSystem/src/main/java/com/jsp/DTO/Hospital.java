package com.jsp.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int Hos_id;
		private String HName;
		private String HAdress;
		private String HCity;
		
		
		@OneToMany
		List<Doctor> doctor;
		
		@OneToMany
		List<Patient> patient;

		public int getHos_id() {
			return Hos_id;
		}

		public void setHos_id(int hos_id) {
			Hos_id = hos_id;
		}

		public String getHName() {
			return HName;
		}

		public void setHName(String hName) {
			HName = hName;
		}

		public String getHAdress() {
			return HAdress;
		}

		public void setHAdress(String hAdress) {
			HAdress = hAdress;
		}

		public String getHCity() {
			return HCity;
		}

		public void setHCity(String hCity) {
			HCity = hCity;
		}

		public List<Doctor> getDoctor() {
			return doctor;
		}

		public void setDoctor(List<Doctor> doctor) {
			this.doctor = doctor;
		}

		public List<Patient> getPatient() {
			return patient;
		}

		public void setPatient(List<Patient> patient) {
			this.patient = patient;
		}
}

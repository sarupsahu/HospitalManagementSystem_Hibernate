package com.jsp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Doctor {
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int Doc_id;
		private String DName;
		private String DQualification;
		private double DSalary;
		
		
		@ManyToOne
		Hospital hospital;


		public int getDoc_id() {
			return Doc_id;
		}


		public void setDoc_id(int doc_id) {
			Doc_id = doc_id;
		}


		public String getDName() {
			return DName;
		}


		public void setDName(String dName) {
			DName = dName;
		}


		public String getDQualification() {
			return DQualification;
		}


		public void setDQualification(String dQualification) {
			DQualification = dQualification;
		}


		public double getDSalary() {
			return DSalary;
		}


		public void setDSalary(double dSalary) {
			DSalary = dSalary;
		}


		public Hospital getHospital() {
			return hospital;
		}


		public void setHospital(Hospital hospital) {
			this.hospital = hospital;
		}
		
		
}

package com.jsp.DTO;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int P_id;
		private String PName;
		private String PDiagnosis;
		private String PAddress;
		
		@ManyToOne
		Hospital hospital;
		
		@OneToMany
		List<MedicalRecord> medicalrecord;

		public int getP_id() {
			return P_id;
		}

		public void setP_id(int p_id) {
			P_id = p_id;
		}

		public String getPName() {
			return PName;
		}

		public void setPName(String pName) {
			PName = pName;
		}

		public String getPDiagnosis() {
			return PDiagnosis;
		}

		public void setPDiagnosis(String pDiagnosis) {
			PDiagnosis = pDiagnosis;
		}

		public String getPAddress() {
			return PAddress;
		}

		public void setPAddress(String pAddress) {
			PAddress = pAddress;
		}

		public Hospital getHospital() {
			return hospital;
		}

		public void setHospital(Hospital hospital) {
			this.hospital = hospital;
		}

		public List<MedicalRecord> getMedicalrecord() {
			return medicalrecord;
		}

		public void setMedicalrecord(List<MedicalRecord> medicalrecord) {
			this.medicalrecord = medicalrecord;
		}
		
}

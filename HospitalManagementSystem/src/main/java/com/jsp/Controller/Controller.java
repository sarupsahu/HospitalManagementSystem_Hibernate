package com.jsp.Controller;

import java.util.Scanner;

import com.jsp.DAO.DoctorDAO;
import com.jsp.DAO.HospitalDAO;
import com.jsp.DAO.MedicalRecordDAO;
import com.jsp.DAO.PatientDAO;
import com.jsp.DTO.Doctor;
import com.jsp.DTO.Hospital;
import com.jsp.DTO.MedicalRecord;
import com.jsp.DTO.Patient;

public class Controller {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HospitalDAO hospitalDAO = new HospitalDAO();
		DoctorDAO doctorDAO = new DoctorDAO();
		PatientDAO patientDAO = new PatientDAO();
		MedicalRecordDAO medicalrecordDAO = new MedicalRecordDAO();
		
		
		int choice;
		do
		{
				System.out.println("=================WELCOME=================");
				System.out.println("1. Hospital");
	            System.out.println("2. Doctor");
	            System.out.println("3. Patient");
	            System.out.println("4. MedicalRecord");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            
	            
	            switch(choice)
				{
				case 1:
						hospitalMenu(sc, hospitalDAO);
					break;
				case 2:
						doctorMenu(sc, doctorDAO);
					break;
				case 3:
						patientMenu(sc, patientDAO);
					break;
				case 4:
						medicalrecordMenu(sc, medicalrecordDAO);
					break;
				case 5:
					System.out.println("Exiting...");
	            	break;
	            default :
	            	System.out.println("Invalid choice. Please enter a number between 1 and 5");
					
		}
		
	}
		while(choice != 5);
		{
			sc.close();
		}
	}

	private static void medicalrecordMenu(Scanner sc, MedicalRecordDAO medicalrecordDAO) {
		// TODO Auto-generated method stub
		int medical;
		do
		{
			System.out.println("=================WELCOME=================");
			System.out.println("1. Add Medical Record");
            System.out.println("2. Update Date Of Examination");
            System.out.println("3. Remove Medical Record");
            System.out.println("4. Display Medical Record By Patient");
            System.out.println("5. Exist");
            System.out.print("Enter your choice: ");
            medical = sc.nextInt();
            
            switch(medical)
            {
            case 1:
            	
            
            	 System.out.println("--------Add Medical Record for Patient-------------");
                    System.out.print("Enter the Patient ID: ");
                    int patientId = sc.nextInt();
                    System.out.print("Enter the Patient Problem: ");
                    String patientProblem = sc.next();
                    System.out.print("Enter the Patient Date of Examination: ");
                    String patientDateOfExamination= sc.next();
                    
                    MedicalRecord medicalrecord = new MedicalRecord();
                    medicalrecord.setProblem(patientProblem);
                    medicalrecord.setDate_of_examination(patientDateOfExamination);
                    
                    medicalrecordDAO.addMedicalRecord(patientId, medicalrecord);
        		
        		break;
        		
            case 2:
            	
            	 System.out.println("--------Update Date Of Examination-------------");
            	 System.out.print("Enter the Medical Record ID to update: ");
                    int recordIdToUpdate = sc.nextInt(); 
            	 System.out.print("Enter the new Date Of Examination (YYYY-MM-DD): ");
                    String newDOE = sc.next();
                    
                    medicalrecordDAO.updateDOE(recordIdToUpdate, newDOE);
                   
                    break;
                    
            case 3:
            	
            	  System.out.println("--------Remove Medical Record-------------");
                    System.out.print("Enter the Medical Record ID to remove: ");
                    int recordIdToRemove = sc.nextInt();
                    
                    medicalrecordDAO.removeMedicalRecord(recordIdToRemove);
                    
                    break;
                    
            case 4:
            	
            	  System.out.println("--------Display Medical Record by Patient-------------");
                    System.out.print("Enter the Patient ID to display medical records: ");
                    int patientIdToDisplay = sc.nextInt();
                    
                    medicalrecordDAO.displayMedicalRecordByPatient(patientIdToDisplay);
                    break;
            	
            	
            case 5:
                System.out.println("Exiting Medical Record Menu...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5");
            }
            
		}
		
		while(medical != 5);
		
	}

	private static void patientMenu(Scanner sc, PatientDAO patientDAO) {
		// TODO Auto-generated method stub
		int patient;
		do
		{
			System.out.println("=================WELCOME=================");
			System.out.println("1. Create Patient");
            System.out.println("2. Remove Patient By Id");
            System.out.println("3. Display Patient Id By Name");
            System.out.println("4. Display All Patient Details");
            System.out.println("5. Exist");
            System.out.print("Enter your choice: ");
            patient = sc.nextInt();
            
            switch(patient)
            {
            case 1:
            	
            
            	 System.out.println("--------Enter The Patient Details-------------");
                    System.out.print("Enter the Hospital ID: ");
                    int hospitalId = sc.nextInt();
                    System.out.print("Enter the Patient Name: ");
                    String patientName = sc.next();
                    System.out.print("Enter the Patient Diagnosis: ");
                    String patientDiagnosis = sc.next();
                    System.out.println("Enter the Patient Address");
                    String patientAddress = sc.next();
                    
                    Patient patient1 = new Patient();
                    patient1.setPName(patientName);
                    patient1.setPDiagnosis(patientDiagnosis);
                    patient1.setPAddress(patientAddress);
                    
                    patientDAO.createPatient(hospitalId, patient1);
        		
        		break;
        		
            case 2:
            	
            	  System.out.println("--------Remove Patient-------------");
                    System.out.print("Enter the Patient ID to remove: ");
                    int patientId = sc.nextInt();

                    patientDAO.removePatientById(patientId);
                    break;
                    
            case 3:
            	
            	 System.out.println("--------Display Patient ID by Name-------------");
                    System.out.print("Enter the Patient name to display ID: ");
                    String patientName1 = sc.next();
                    
                    patientDAO.displayPatientIdByName(patientName1);
                    
                    break;
                    
            case 4:
            	
            	 System.out.println("--------Display All Patient Details-------------");
            	 
            	 patientDAO.displayAllPatientDetails();
                    break;
            	
            	
            case 5:
                System.out.println("Exiting Patient Menu...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5");
            }
            
		}
		
		while(patient != 5);
		
	}

	private static void doctorMenu(Scanner sc, DoctorDAO doctorDAO) {
		// TODO Auto-generated method stub
		int doctor;
		do
		{
			System.out.println("=================WELCOME=================");
			System.out.println("1. Create Doctor");
            System.out.println("2. Update Doctor Salary By Id");
            System.out.println("3. Remove Doctor");
            System.out.println("4. Display Doctor Details By Name");
            System.out.println("5. Display All Doctor Details By Specific Hospital");
            System.out.println("6. Exist");
            System.out.print("Enter your choice: ");
            doctor = sc.nextInt();
            
            switch(doctor)
            {
            case 1:
            	
            	
            	
            	System.out.println("--------Enter The Doctor Details-------------");
                System.out.print("Enter the Hospital ID: ");
                int hospitalId = sc.nextInt();
        		System.out.println("Enter the Doctor Name: ");
        		String doctorName = sc.next();
        		System.out.println("Enter the Doctor Qualification: ");
        		String doctorQualification = sc.next();
        		System.out.println("Enter the Doctor Salary: ");
        		double doctorSalary = sc.nextDouble();
        		
        		Doctor d = new Doctor();
        		
        		d.setDName(doctorName);;
        		d.setDQualification(doctorQualification);;
        		d.setDSalary(doctorSalary);
        		
        		doctorDAO.createDoctor(hospitalId, d);
        		
        		
        		break;
        		
            case 2:
            	
            	 System.out.println("--------Update Doctor Salary-------------");
                 System.out.print("Enter the Doctor ID: ");
                 int doctorIdToUpdate = sc.nextInt();
                 System.out.print("Enter the new Salary: ");
                 double newSalary = sc.nextDouble();
                 
                 doctorDAO.updateDoctorSalaryById(doctorIdToUpdate, newSalary);
                    break;
                    
            case 3:
            	
            	 System.out.println("--------Remove Doctor-------------");
                 System.out.print("Enter the Doctor ID to remove: ");
                 int doctorIdToRemove = sc.nextInt();
                   
                 doctorDAO.removeDoctor(doctorIdToRemove);
                 break;
                    
            case 4:
            	System.out.println("--------Display Doctor Details By Name-------------");
                System.out.print("Enter the Doctor Name: ");
                String doctorName1 = sc.next();
                
                doctorDAO.displayDoctorDetailsByName(doctorName1);    
                
                    break;
            	
            case 5:
            	System.out.println("--------Display All Doctor Details By Specific Hospital-------------");
                System.out.print("Enter the Hospital ID: ");
                int hospitalId1 = sc.nextInt();
                
                doctorDAO.displayAllDoctorDetailsBySpecificHospital(hospitalId1);
                    break;
            	
            case 6:
                System.out.println("Exiting Doctor Menu...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6");
            }
            
		}
		
		while(doctor != 6);
		
		
	}

	private static void hospitalMenu(Scanner sc, HospitalDAO hospitalDAO) {
		// TODO Auto-generated method stub
		int hospital;
		do
		{
			System.out.println("=================WELCOME=================");
			System.out.println("1. Create Hospital");
            System.out.println("2. Update Hospital Name");
            System.out.println("3. Remove Hospital");
            System.out.println("4. Display HospitalName By Name");
            System.out.println("5. Display All Hospital Details");
            System.out.println("6. Exist");
            System.out.print("Enter your choice: ");
            hospital = sc.nextInt();
            
            switch(hospital)
            {
            case 1:
            	
            	
            	
            	System.out.println("--------Enter The Hospital Details-------------");
        		
        		System.out.println("Enter the Hospital Name: ");
        		String hospitalName = sc.next();
        		System.out.println("Enter the Hospital Address: ");
        		String hospitalAddress = sc.next();
        		System.out.println("Enter the Hospital City: ");
        		String hospitalCity = sc.next();
        		
        		Hospital h = new Hospital();
        		
        		h.setHName(hospitalName);
        		h.setHAdress(hospitalAddress);
        		h.setHCity(hospitalCity);
        		
        		hospitalDAO.createHospital(h);
        		
        		break;
        		
            case 2:
            	
            	 System.out.println("--------Update Hospital Name-------------");
                    System.out.print("Enter the Hospital id: ");
                    int hospitalIdToUpdate = sc.nextInt();
                    System.out.print("Enter the new Hospital Name: ");
                    String newHospitalName = sc.next();
                    
                    hospitalDAO.updateHospitalName(hospitalIdToUpdate, newHospitalName);
                    break;
                    
            case 3:
            	
            		System.out.println("--------Remove Hospital-------------");
                    System.out.print("Enter the Hospital id to remove: ");
                    int hospitalIdToRemove = sc.nextInt();
                    
                    hospitalDAO.removeHospital(hospitalIdToRemove);
                    
                    break;
                    
            case 4:
            	
            	 System.out.println("--------Display Hospital Details By Name-------------");
                    System.out.print("Enter the Hospital name to display details: ");
                    String hospitalNameToDisplay = sc.next();
                    
                    hospitalDAO.displayHospitalDetailsByName(hospitalNameToDisplay);
                    break;
            	
            case 5:
            	  System.out.println("--------Display All Hospital Details-------------");
                    hospitalDAO.displayAllHospitalDetails();
                    break;
            	
            case 6:
                System.out.println("Exiting Hospital Menu...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6");
            }
            
		}
		
		while(hospital != 6);
		
	
	}
}

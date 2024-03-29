package org.doctorapp.service;

import org.doctorapp.exception.DoctorNotFoundException;
import org.doctorapp.exception.IdNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.repository.DoctorRepositoryImpl;
import org.doctorapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorRepository doctorRepository;
   
    @Override
    public void addDoctor(Doctor doctor) {
      doctorRepository.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
    	 doctorRepository.updateDoctor(doctorId,fees);
    }

    @Override
    public void deleteDoctor(int doctorId) {
    	 doctorRepository.deleteDoctor(doctorId);
    }

    @Override
    public Doctor getById(int doctorId) throws IdNotFoundException {
        Doctor doctor=doctorRepository.findById(doctorId);
        if (doctor == null)
            throw new IdNotFoundException("INVALID ID");
        return doctor;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctorList =doctorRepository.findAll();
        if(doctorList.isEmpty()) {
        	
        }
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {

         List<Doctor> doctorList =doctorRepository.findBySpeciality(speciality, Integer.parseInt(speciality));
         if (doctorList.isEmpty())
             throw  new DoctorNotFoundException("doctor with this speciality not found");
         

        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> doctorList =doctorRepository.findBySpeciality(speciality,experience);
        if (doctorList.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality and exp not found");
           
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndLeesFees(String speciality, double fess) throws DoctorNotFoundException {
        List<Doctor> doctorList =doctorRepository.findBySpeciality(speciality, (int) fess);
        if (doctorList.isEmpty()){
            throw new DoctorNotFoundException("doctor with this speciality and fees not found");

        }
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) {
        List<Doctor> doctorList =doctorRepository.findBySpeciality(speciality, (int) ratings);
        if (doctorList.isEmpty()){
       
        }
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) {
    	  List<Doctor> doctorList =doctorRepository.findBySpecialityAndNameContains(speciality,doctorName);
          if (doctorList.isEmpty()){
            

          }
        return doctorList;
    }
}

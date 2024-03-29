package org.doctorapp.repository;

import org.doctorapp.model.Doctor;

import java.util.List;

public interface IDoctorRepository {
    void addDoctor(Doctor doctor);
    void  updateDoctor(int doctorId, double fees);
    void deleteDoctor(int doctorId);
    Doctor findById(int doctorId);
    List<Doctor> findAll();
    List<Doctor> findBySpeciality(String speciality, int experience);
    List<Doctor> findBySpecialityAndLeesFees(String speciality ,double fess);
    List<Doctor> findBySpecialityAndRatings(String speciality, int ratings);
    List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName);

}

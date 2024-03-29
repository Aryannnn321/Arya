package org.doctorapp.repository;

import org.doctorapp.model.Doctor;
import org.doctorapp.util.DoctorDb;
import org.doctorapp.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public void addDoctor(Doctor doctor) {
		Object[] bookArr= {doctor.getDoctorId(), doctor.getDoctorName(),doctor.getSpeciality(),doctor.getExperience(),doctor.getRatings(),doctor.getFees()};
		jdbcTemplate.update(Queries.InsertQuery,bookArr);
		
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		jdbcTemplate.update(Queries.UpdateQuery,doctorId,fees);
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		jdbcTemplate.update(Queries.DELETEQUERY,doctorId);
		
		
	}

	@Override
	public Doctor findById(int doctorId) {
		Doctor doctor=	jdbcTemplate.queryForObject(Queries.FINDALLQUERY,new DoctorMapper(), doctorId);
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
	RowMapper<Doctor> mapper= new DoctorMapper();
	List<Doctor> doctor=jdbcTemplate.query(Queries.FINDALLQUERY,mapper);
		return doctor;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality, int experience) {
		return jdbcTemplate.query(Queries.
    		FINDBYSPECIALITY,(rs,rowNum)->{
    		Doctor doctor=new  Doctor();
    		doctor.setDoctorId(rs.getInt("doctorId"));
    		doctor.setDoctorName(rs.getString("doctorName"));
    		doctor.setSpeciality(rs.getString("speciality"));
    		doctor.setRatings(rs.getInt("ratings"));
    		doctor.setFees(rs.getDouble("fees"));
    		doctor.setExperience(rs.getInt("experience"));
    		return doctor;
    	},speciality);
    	
		
	}

	@Override
	public List<Doctor> findBySpecialityAndLeesFees(String speciality, double fess) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECANDFEES, new DoctorMapper(),fess);
		return doctor;
	}

	@Override
	public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECANDRATINGS, new DoctorMapper(),ratings);
		return doctor;
	
	}

	@Override
	public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECANDNAME, new DoctorMapper(), doctorName);
		return doctor;
	}
   
    }


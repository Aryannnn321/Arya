//package org.doctorapp;
//
//import org.doctorapp.service.IDoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringDoctorJdbcApplication implements CommandLineRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringDoctorJdbcApplication.class, args);
//	}
//	@Autowired
//	IDoctorService doctorService;
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(doctorService.getBySpeciality("GYNAEC"));
//		doctorService.updateDoctor(7, 7890);
//	}
//
//}

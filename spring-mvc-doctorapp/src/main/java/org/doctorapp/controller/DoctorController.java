package org.doctorapp.controller;

import java.util.List;

import org.doctorapp.exception.DoctorNotFoundException;
import org.doctorapp.exception.IdNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {
	@Autowired
	private IDoctorService doctorService;
	@RequestMapping("/")
	public String home(Model model) {
		List<Doctor> doctors=doctorService.getAll();
		model.addAttribute("doctors", doctors);
		return "home";
	}
	@RequestMapping("/addDoctor")
	public String addDoctor(Doctor doctor) {
		System.out.println(doctor);
		
		return "admindashboard";
	}
	@RequestMapping("/editDoctor")
	public String editDoctor(@RequestParam("doctorId")int doctorId, Model model) throws IdNotFoundException {
		Doctor doctor=doctorService.getById(doctorId);
		model.addAttribute( doctor);
		return "updatedoctor";
	}
	@RequestMapping("/updatedoctor")
	public String updatedoctor(@RequestParam("doctorId")int doctorId, 
	 @RequestParam("fees")double fees, Model model) {
		doctorService.updateDoctor(doctorId, fees);
		model.addAttribute("message", "doctor updated successfully");
		return "admindashboard";
	}
	@RequestMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam("doctorId")int doctorId, Model model) {
		doctorService.deleteDoctor(doctorId);
		model.addAttribute("message", "doctor deleted succesfully");
		return "admindashboard";
	}
	@RequestMapping("/search")
	public String search(@RequestParam("choice")String choice) throws DoctorNotFoundException {
		List<Doctor> doctor=doctorService.getBySpeciality(choice);
		return "home";
	}
}

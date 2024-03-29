package com.insuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.service.IInsuranceService;

@RestController
@RequestMapping("/insurance-api/v1")
public class InsuranceController {
@Autowired
IInsuranceService iInsuranceService;

@PostMapping("/insurances")
ResponseEntity<Void> addInsurance(@RequestBody Insurance insurance) {
	iInsuranceService.addInsurance(insurance);
	return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
}

@PutMapping("/insurances")
ResponseEntity<Void> updateInsurance(@RequestBody Insurance insurance) {
	iInsuranceService.updateInsurance(insurance.getInsuranceId(),insurance.getPremium());
	return ResponseEntity.accepted().build();
}
@DeleteMapping("/insurances/insurance_id/{insuranceId}")
ResponseEntity<Void> deleteInsurance( @PathVariable("insuranceId")int insuranceId) {
	iInsuranceService.deleteInsurance(insuranceId);
	return ResponseEntity.ok().build();
}
@GetMapping("/insurances")
ResponseEntity<List<Insurance>> getAll(){
	HttpHeaders headers=new HttpHeaders();
	headers.add("info","returing list of insurances");
	headers.add("desc", "all insurances from db");
	List<Insurance> insurances=iInsuranceService.getAll();
	ResponseEntity<List<Insurance>> entity=new ResponseEntity<>(insurances,headers,HttpStatus.OK);
	return entity;
}
@GetMapping("/insurance/brand/{brand}")
ResponseEntity<List<Insurance>>  getByBrand(@PathVariable("brand")String brand) throws InsuranceNotFoundException{
	List<Insurance> insurances= iInsuranceService.getByBrand(brand);
	HttpHeaders headers= new HttpHeaders();
	headers.add("info", "returing list of insurances by brand"+brand);
	return ResponseEntity.status(200).headers(headers).body(insurances);
}
@GetMapping("/insurance/brand/{brand}/type/{type}")
ResponseEntity<List<Insurance>>  getByBrandType(@PathVariable("brand")String brand ,@PathVariable
		("type")String type) throws InsuranceNotFoundException{
		List<Insurance> insurances=iInsuranceService.getByBrandAndType(brand, type);
	
	return ResponseEntity.ok(insurances);
}
@GetMapping("/insurance/type-premium")
ResponseEntity<List<Insurance>> getByTypeAndLesserPremium(
		@RequestParam("type")String type,@RequestParam("premium")double premium) throws InsuranceNotFoundException {
	List<Insurance> insurances= iInsuranceService.getByTypeAndLesserPremium(type, premium);
	HttpHeaders headers =new HttpHeaders();
	headers.add("info", "returing list of insurances by type premium"+type);
	return ResponseEntity.accepted().headers(headers).body(insurances) ;
}
@GetMapping("/insurances/insurance-id/{insuranceId}")
ResponseEntity<Insurance> getById(@PathVariable("instanceId") int insuranceId) throws InsuranceNotFoundException{
Insurance	insurances= iInsuranceService.getById(insuranceId);
return ResponseEntity.ok().body(insurances);
}
}

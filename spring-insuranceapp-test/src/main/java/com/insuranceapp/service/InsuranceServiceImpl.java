package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insuranceapp.model.Insurance;
@Service
public class InsuranceServiceImpl implements IInsuranceService {

	@Override
	public List<Insurance> getAll() {
		List<Insurance> insurances =getAllInsurances();
		return insurances ;
	}

	@Override
	public Insurance getById(int insuranceId) {
		List<Insurance> insurances =getAllInsurances();
		for(Insurance insurance : insurances) {
			if(insurance.getInsuranceId()==insuranceId)
				return insurance;
		}
		return null;
	}
	private List<Insurance> getAllInsurances(){
		return Arrays.asList(
			new Insurance(101,"VH-123","voya","health",10,1000),
			new Insurance(102,"VH-124","slk","motor",11,2000),
			new Insurance(103,"VH-125","tcs","life",12,3000),
			new Insurance(104,"VH-125","tata","sports",13,4000),
			new Insurance(105,"VH-126","jsw","merit",14,5000)
				);
	}

}

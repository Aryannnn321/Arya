package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.repository.IInsuranceRepository;
@Service
public class InsuranceServiceImpl implements IInsuranceService {
@Autowired
IInsuranceRepository iInsuranceRepository;
	@Override
	public void addInsurance(Insurance insurance) {
		iInsuranceRepository.addInsurance(insurance);
	}

	@Override
	public void updateInsurance(int insuranceId, double premium) {
		iInsuranceRepository.updateInsurance(insuranceId,premium);
		
	}

	@Override
	public void deleteInsurance(int insuranceId) {

		iInsuranceRepository.deleteInsurance(insuranceId);
		
	}

	@Override
	public List<Insurance> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Insurance> getByBrand(String brand) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Insurance> getByBrandAndType(String brand, String type) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Insurance> getByTypeAndLesserPremium(String type, double premium) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insurance getById(int insuranceId) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

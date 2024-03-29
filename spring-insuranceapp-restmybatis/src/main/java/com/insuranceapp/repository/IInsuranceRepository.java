package com.insuranceapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
@Mapper
public interface IInsuranceRepository {
	@Insert("insert into insurance(insurance_id,policy_name,brand,type,duration,premium)values(#{insuranceId},(#{PolicyName},(#{brand}, (#{type}, (#{duration},(#{premium}")
	void addInsurance(Insurance insurance);
	@Update("update insurance set premium=#{premium} where insurance_id=#{insuranceId}")
	void updateInsurance(int insuranceId, double premium);
	@Delete("delete from insurance where insurance_id=#{insuranceId}")
	void deleteInsurance(int insuranceId);
	@Select("select *from insurance where insurance_id=#{insuranceId}")
	List<Insurance> findAll();
	@Select("select *from insurance")
	@Results({
			@Result(property ="insuranceId", column="insurance_id"),
			 @Result(property ="policyName", column="policy_name")})
	
	List<Insurance> findByBrand(String brand) throws InsuranceNotFoundException;
	@Select("select * from insurance where brand=#{brand}")
	List<Insurance> findByBrandAndType(String brand, String type)throws InsuranceNotFoundException;
	@Select("select * from insurance where price=#{price}")
	List<Insurance> findByTypeAndLesserPremium(String type, double premium)throws InsuranceNotFoundException;
	@Select("select * from insurance where brand=#{brand} and price=#{price}")
	Insurance findById(int insuranceId)throws InsuranceNotFoundException;

}

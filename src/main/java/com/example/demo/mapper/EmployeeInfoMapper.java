package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.form.EmployeeForm;

@Mapper
public interface EmployeeInfoMapper {
	//従業員データを取得する
	List<EmployeeInfo> findBySearchForm(EmployeeForm employeeForm);
	
	//従業員データを追加する
	List<EmployeeInfo> createRegisterForm(EmployeeInfo employeeInfo);
	
	//最大値IDを取得する
	String findMaxId();
	
}
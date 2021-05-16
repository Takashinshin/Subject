package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.form.EmployeeForm;
import com.example.demo.mapper.EmployeeInfoMapper;

@Service
public class DemoServiceImpl implements DemoService {
	
	//従業員情報テーブルへアクセスするマッパー
	@Autowired
	private EmployeeInfoMapper mapper;
	
	@Override
	public List<EmployeeForm> demoFormList(EmployeeForm employeeForm){
		List<EmployeeForm> demoFormList = new ArrayList<>();
		//従業員情報テーブルから検索条件にあうデータを取得する
		List<EmployeeInfo> employeeInfoList = mapper.findBySearchForm(employeeForm);
		for(EmployeeInfo employeeInfo : employeeInfoList) {
			demoFormList.add(getDemoForm(employeeInfo));
		}
		return demoFormList;
	}
	
	private EmployeeForm getDemoForm(EmployeeInfo employeeInfo) {
		if(employeeInfo == null) {
			return null;
		}
		EmployeeForm demoForm = new EmployeeForm();
		demoForm.setId(String.valueOf(employeeInfo.getId()));
		demoForm.setName(employeeInfo.getName());
		demoForm.setAge(employeeInfo.getAge());
		demoForm.setGender(employeeInfo.getGender());
		demoForm.setDob(employeeInfo.getDob());
		return demoForm;
	}
	
	@Override
	public void create(EmployeeForm employeeForm) {
		//追加処理を行うエンティティを作成
		EmployeeInfo employeeInfo = getEmployeeData(employeeForm);
		//追加処理
		employeeForm.setId(String.valueOf(Integer.parseInt(mapper.findMaxId()) + 1));
		mapper.createRegisterForm(employeeInfo);
	}
	
	//EmployeeInfoオブジェクトに引数のフォームの各値を設定する
	private EmployeeInfo getEmployeeData(EmployeeForm employeeForm) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setId(employeeForm.getId());
		employeeInfo.setName(employeeForm.getName());
		employeeInfo.setAge(employeeForm.getAge());
		employeeInfo.setGender(employeeForm.getGender());
		employeeInfo.setDob(employeeForm.getDob());
		return employeeInfo;
	}
//	
	
	
	
}

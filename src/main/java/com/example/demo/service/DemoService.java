package com.example.demo.service;

import java.util.List;

import com.example.demo.form.EmployeeForm;

public interface DemoService {
	
	//従業員データリストを取得
	//@param searchForm 検索用Formオブジェクト
	
	
	List<EmployeeForm> demoFormList(EmployeeForm employeeForm);
	
	//引数の従業員データ追加
	void create(EmployeeForm employeeForm);

}

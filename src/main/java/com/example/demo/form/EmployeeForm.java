package com.example.demo.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeForm {
	//ID
	private String id;
	
	//名前
	@NotEmpty(message = "名前を入力してください")
	private String name;
	
	//年齢
	private int age;
	
	//性別
	@NotEmpty(message = "性別を洗濯してください")
	private String gender;
	
	//生年月日
	@NotEmpty(message = "生年月日を入力してください")
	@Size(min = 8, max = 8,message = "生年月日は8文字です")
	@Pattern(regexp = "[0-9]*", message = "生年月日は半角数字です")
	private String dob;
	
	//性別Mapオブジェクト
	public Map<String, String> getGenderItems(){
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("M", "M");
		genderMap.put("F", "F");
		return genderMap;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
}

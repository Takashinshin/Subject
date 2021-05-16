
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.form.EmployeeForm;
import com.example.demo.service.DemoService;

@Controller
@SessionAttributes(types = EmployeeForm.class)
public class DemoController {
	
	//Demoサービスクラスのアクセス
	
	@Autowired
	private DemoService demoService;
	
	//従業員情報テーブルのデータを取得して返却する
	@ModelAttribute("demoFormList")
	public List<EmployeeInfo> employeeDataList(){
		return new ArrayList<>();
	}
	
	
	//Formオブジェクトを初期化して返却する。
	@ModelAttribute("employeeForm")
	public EmployeeForm clearEmployeeForm() {
		return new EmployeeForm();
	}
	
	//初期表示画面に遷移する
	@RequestMapping("/")
	public String index(Model model) {
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setId(null);
		employeeForm.setName(null);
		employeeForm.setAge(0);
		employeeForm.setGender(null);
		model.addAttribute("employeeForm", employeeForm);
		return "top";
	}
	
	//検索画面に遷移
	@RequestMapping("/search")
	public String search() {
		return "search";
	}
	
	//登録画面に遷移
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	//登録確認画面に遷移
	@RequestMapping("/confirm")
	public String confirm() {
		return "confirm";
	}
	//更新画面に遷移
	@RequestMapping("/updata")
	public String updata() {
		return "updata";
	}
	
	//消去画面に遷移
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	
	
	
	
	//検索処理を行い、一覧画面に遷移する
	@RequestMapping("/search_result")
	public String searchResult(EmployeeForm employeeForm, Model model, BindingResult result) {
		//検索用Formオブジェクトのチェック処理
		//従業員情報リストを取得
		List<EmployeeForm> demoFormList = demoService.demoFormList(employeeForm);
		//従業員情報リスト更新
		model.addAttribute("demoFormList", demoFormList);
		return "search_result";
	}
	
	//確認画面に遷移
	@PostMapping(value = "/confirm", params = "next")
	public String confirm(@Validated EmployeeForm employeeForm, BindingResult result) {
		//追加処理
			if(result.hasErrors()) {
				return "register";
			}
		return "confirm";
	}
	//完了画面に遷移する
	@PostMapping(value = "/complete", params = "next")
	public String send(EmployeeForm employeeForm, BindingResult result){
		//追加処理を行う
		demoService.create(employeeForm);
		return "complete";
	}
	
}

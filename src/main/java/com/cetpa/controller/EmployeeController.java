package com.cetpa.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

@Controller
@RequestMapping("employee-dashboard")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	
	@GetMapping("")
	public String getEmployeeDashboard(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "list";
	}
	@GetMapping("add-employee")
	public String getAddEmployeeView()
	{
		return "add";
	}
	@PostMapping("add-record")
	public String addEmployeeRecord(Employee employee,Model model)
	{
		
		Employee emp = employeeService.getRecord(employee.getEid());
		if(emp!=null) {
			model.addAttribute("msg","Employee Id "+employee.getEid()+"already exist");
			return "add";
		}
	
		employeeService.saveRecord(employee);
		employee.getEid();
		return "redirect:/employee-dashboard";
	}
	@GetMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid);
		return "redirect:/employee-dashboard";
	}
	
	@GetMapping("edit-record")
	public String editEmployeeRecord( int eid, Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		model.addAttribute("emp",employee);
		return "edit";
	}
	@RequestMapping("update-record")
	public String updaetEmployeeRecord(Employee employeen)
	{
	
		employeeService.updateRecord(employeen);;
		return "redirect:/employee-dashboard";
	}
	
}

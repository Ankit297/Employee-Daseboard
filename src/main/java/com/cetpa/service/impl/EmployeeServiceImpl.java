package com.cetpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;
import com.cetpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}
	public void saveRecord(Employee employee) 
	{
		employeeRepository.saveEmployee(employee);
	}
	public void deleteRecord(int eid) 
	{
		employeeRepository.deleteEmployee(eid);
	}
	@Override
	public Employee getRecord(int eid) {
		
		return employeeRepository.getEmployee(eid);
	}
	@Override
	public void updateRecord(Employee employeen) {
	
		Employee employeeo=employeeRepository.getEmployee(employeen.getEid());
		employeeRepository.updateEmployee(employeeo, employeen);
	}
	
	}

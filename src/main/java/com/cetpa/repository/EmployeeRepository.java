package com.cetpa.repository;

import java.util.List;

import com.cetpa.entity.Employee;

public interface EmployeeRepository 
{
	List<Employee> getEmployeeList();
	void saveEmployee(Employee employee);
	void deleteEmployee(int eid);
	Employee getEmployee(int eid);
	void updateEmployee(Employee employeeo, Employee employeen);
}

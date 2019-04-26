package com.ERS.dao;


import java.util.List;

import com.ERS.bean.Employee;

public interface EmpDao {
	public List<Employee> getAllEmps();
	public Employee getEmpById(int id);
	public void insertEmp(Employee e);
	public void deleteEmp(Employee e);
	public void updateEmp(Employee e);
}

package com.ERS.dao;


import java.util.List;

import com.ERS.bean.Employee;

public class EmpService {
	public List<Employee> getAllEmps(){
		return new EmpDaoImp().getAllEmps();
	}
	
	public Employee getEmpById(int id) {
		return new EmpDaoImp().getEmpById(id);
	}
	
	public void insertEmp(Employee e) {
		new EmpDaoImp().insertEmp(e);
	}
	
	public void deleteEmp(Employee e) {
		new EmpDaoImp().deleteEmp(e);
	}
	
	public void updateEmp(Employee e) {
		new EmpDaoImp().updateEmp(e);
	}
}


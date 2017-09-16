package com.dengshaolin.db;

import java.util.List;

import com.dengshaolin.db.model.Employee;

public interface EmployeeDao {
	public void save(Employee emp);
	public Employee get(int empId);
	public void delete(int empId);
	public List<Employee> list();
}

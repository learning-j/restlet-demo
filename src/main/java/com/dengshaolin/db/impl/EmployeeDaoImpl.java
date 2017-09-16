package com.dengshaolin.db.impl;

import java.util.List;

import com.dengshaolin.db.EmployeeDao;
import com.dengshaolin.db.model.Employee;
import com.dengshaolin.db.utils.HibernateUtil;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
	public EmployeeDaoImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void save(Employee emp) {
		super.save(emp);
	}

	@Override
	public Employee get(int empId) {
		return super.get(Employee.class, empId);
	}

	@Override
	public void delete(int empId) {
		super.remove(Employee.class, empId);
	}

	@Override
	public List<Employee> list() {
		return super.list(Employee.class);
	}

}

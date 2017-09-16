package com.dengshaolin.db.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dengshaolin.db.impl.EmployeeDaoImpl;
import com.dengshaolin.db.model.Certificate;
import com.dengshaolin.db.model.Employee;

public class EmployeeTest {

	@Test
	public void testAddEmployee() {
		Employee emp = new Employee("l", "d", 15);
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.save(emp);
		System.out.println(emp);
		List<Certificate> cers = new ArrayList<Certificate>();
		cers.add(new Certificate("math"));
		emp.setCertificates(cers);
		employeeDaoImpl.save(emp);
		System.out.println(emp);
		cers.add(new Certificate("sicense"));
		System.out.println(emp);
		employeeDaoImpl.save(emp);
		System.out.println(emp);
	}

}

package com.dengshaolin.db.model;

import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private List<Certificate> certificates;
    
    public Employee(){}
    public Employee(String fName, String lName, int salary){
        this.firstName = fName;
        this.lastName = lName;
        this.salary = salary;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public List<Certificate> getCertificates() {
        return certificates;
    }
    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
    	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
    			+ ", salary=" + salary + ", certificate=" + certificates + "]";
    }
}

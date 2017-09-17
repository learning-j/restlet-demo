package com.dengshaolin.db;

import java.util.List;

import com.dengshaolin.db.model.Person;

public interface PersonDao {
	public void save(Person person);
	public Person get(int personId);
	public List<Person> list();
	public void delete(int personId);
}

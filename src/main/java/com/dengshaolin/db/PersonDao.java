package com.dengshaolin.db;

import com.dengshaolin.db.model.Person;

public interface PersonDao {
	public void save(Person person);
	public Person get(int personId);
	public void delete(int personId);
}

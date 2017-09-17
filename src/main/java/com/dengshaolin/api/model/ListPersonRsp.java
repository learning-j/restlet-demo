package com.dengshaolin.api.model;

import java.util.List;

import com.dengshaolin.db.model.Person;

public class ListPersonRsp {
	private List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}

package com.dengshaolin.db.impl;

import java.util.List;

import com.dengshaolin.db.PersonDao;
import com.dengshaolin.db.model.Person;
import com.dengshaolin.db.utils.HibernateUtil;

public class PersonDaoImpl extends BaseDao<Person> implements PersonDao{
	public PersonDaoImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void save(Person p) {
		super.save(p);
	}

	@Override
	public Person get(int personId) {
		// TODO Auto-generated method stub
		return (Person)super.get(Person.class, personId);
	}

	@Override
	public void delete(int personId) {
		// TODO Auto-generated method stub
		super.remove(Person.class, personId);
	}

	@Override
	public List<Person> list() {
		return super.list(Person.class);
	}
}

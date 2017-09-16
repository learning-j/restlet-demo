package com.dengshaolin.db.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.dengshaolin.db.impl.PersonDaoImpl;
import com.dengshaolin.db.model.Person;

public class PersonTest {
    /**
     * ≤‚ ‘∑Ω∑®
     */
    @Test
    public void testSaveStudent()
    {
        Person person = new Person();
        person.setName("drgnsl");
        Set<String> addr = new HashSet<String>();
        addr.add("addr1");
        person.setAddress(addr);
        PersonDaoImpl personDaoImpl = new PersonDaoImpl();
        // Insert
        personDaoImpl.save(person);
        System.out.println(personDaoImpl.get(person.getId()));
        personDaoImpl.delete(person.getId());
    }
    @Test
    public void testGetPerson()
    {
		System.out.println(new PersonDaoImpl().get(19));
    }
}

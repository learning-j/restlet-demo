package com.dengshaolin.db.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.dengshaolin.db.PrimaryUUid;

public class PrimaryUuidTest {
	public static void main(String[] argrs) {

        PrimaryUUid t= new PrimaryUUid();
        t.setName("s1");

        Configuration cfg= new Configuration();
        SessionFactory sf=cfg.configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();    
    }
}

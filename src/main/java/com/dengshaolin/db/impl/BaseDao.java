package com.dengshaolin.db.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDao<T> {
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		// return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}

	protected String createQuerySql(Class<?> clazz) {
		return "FROM " + clazz.getName();
	}
	
	public void save(T rec) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(rec);
		transaction.commit();
		// session.close();
	}

	@SuppressWarnings("unchecked")
	public T get(Class<?> clazz, int id){
		Session session = getSession();
		Transaction transation = session.beginTransaction();
		Object obj = session.get(clazz, id);
		transation.commit();
		if (obj != null) {
			return (T) obj;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> list(Class<?> clazz) {
		Session session = getSession();
		Transaction transation = session.beginTransaction();
		String sql = this.createQuerySql(clazz);
		List<T> recs = session.createQuery(sql).list();
		transation.commit();
		return recs;
	}
	
	@SuppressWarnings("unchecked")
	public void remove(Class<?> clazz, int id) {
		Session session = getSession();
		Transaction transation = session.beginTransaction();
		T t = (T) session.load(clazz, id);
		session.delete(t);
		transation.commit();
	}
}

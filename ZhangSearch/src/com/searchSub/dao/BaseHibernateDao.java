package com.searchSub.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseHibernateDao {

	private SessionFactory sessionFactory;


	public Session getSession() {
		return sessionFactory.openSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
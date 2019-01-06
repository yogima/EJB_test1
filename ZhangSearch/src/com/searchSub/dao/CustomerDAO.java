package com.searchSub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.searchSub.po.Customer;


public class CustomerDAO extends BaseHibernateDao implements ICustomerDAO {

	public void save(Customer transientInstance) {
		System.out.println("execute --save()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.save(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}

	

	public void delete(Customer transientInstance) {
		System.out.println("execute --delete()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.delete(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}

	public void update(Customer transientInstance) {
		System.out.println("execute --update()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.merge(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}

	public List findByHQL(String hql) {
		System.out.println("execute --findByHQL()-- method.");
		Transaction tran = null;
		Session session = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			tran.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			if (tran != null)
				tran.rollback();
			throw re;
		} finally {
			session.close();
		}
	}
}

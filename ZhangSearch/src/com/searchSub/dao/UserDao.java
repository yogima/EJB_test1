package com.searchSub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.searchSub.po.Users;

public class UserDao extends BaseHibernateDao implements IUserDao{

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public List findByHql(String hql) { 
			
			Session session=getSession(); 
			try {
				String queryString = hql;
				Query queryObject = session.createQuery(queryString); 
				return queryObject.list();
			}catch (RuntimeException re) {
				//log.error("find by hql failed", re); 
				throw re;
				}finally{
					session.close();
				}
		}
	

	public void save(Users user) {
		// TODO Auto-generated method stub
		Transaction tran = null; 
		Session session = null; 
		try { 
			session = getSession(); 
			tran = session.beginTransaction(); 
			session.save(user); 
			tran.commit(); 
		} catch (RuntimeException re) {
			if(tran != null) 
				tran.rollback();
			throw re; 
		} finally { 
			session.close(); 
		}

	}

	public void update(Users user) {
		try {
			getSession().update(user);
			getSession().flush();
		}catch(RuntimeException re) {
			throw re;
		}finally {
			getSession().close();
		}
	}
	
	//删除一条记录
	public void delete(Users user) {
		try {
			getSession().delete(user);
			getSession().flush();
		}catch(RuntimeException re) {
			throw re;
		}finally {
			getSession().close();
		}
	}

}

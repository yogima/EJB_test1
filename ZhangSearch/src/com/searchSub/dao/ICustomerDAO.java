package com.searchSub.dao;

import java.util.List;

import org.hibernate.Session;

import com.searchSub.po.Customer;

public interface ICustomerDAO {
	public void save(Customer transientInstance);
	public void delete(Customer transientInstance);
	public void update(Customer transientInstance);
	public List findByHQL(String hql);
	public Session getSession();
}

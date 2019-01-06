package com.searchSub.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.searchSub.dao.ICustomerDAO;
import com.searchSub.po.Customer;

public class UserService implements IUserService {
	private ICustomerDAO userDao = null;

	public void setUserDao(ICustomerDAO userDao) {
		this.userDao = userDao;
	}

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean reg(Customer user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		return true;
	}

	@Override
	public boolean login(Customer user) {
		// TODO Auto-generated method stub
		String account = user.getAccount();
		String passwd = user.getPassword();
		String hql = "from Customer as cus where cus.account='" + account + "' and cus.password='" + passwd + "'";
		
		List u = userDao.findByHQL(hql);
		if(u != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Customer user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
		return true;
	}

	@Override
	public boolean collect(Customer user, String quesId) {
		// TODO Auto-generated method stub
		String userhql = "From Customer where account='"+user.getAccount()+"'";
		
		Transaction tran = null; 
		try {
			ArrayList u = (ArrayList) userDao.findByHQL(userhql);
			user = (Customer) u.get(0);
			user.getWrongQues().add(quesId);
			tran = userDao.getSession().beginTransaction();
			userDao.update(user);
			tran.commit();
			return true;
		}catch (Exception e) { 
			e.printStackTrace();
			if(tran != null) 
				tran.rollback();
			return false; 
		} finally { 
			userDao.getSession().close();
		}

	}

	@Override
	public boolean cancelCollect(Customer user, String quesId) {
		// TODO Auto-generated method stub
		String userhql = "From Customer as cus.customerId='"+user.getCustomerId()+"'";
		user = (Customer) userDao.findByHQL(userhql);
		user.getWrongQues().remove(quesId);
		userDao.update(user);
		return true;
	}
	
}

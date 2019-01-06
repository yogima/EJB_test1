package com.searchSub.service;

import com.searchSub.po.Customer;

public interface IUserService {
	public boolean reg(Customer user);
	public boolean login(Customer user);
	public boolean delete(Customer user);
	public boolean collect(Customer user,String quesId);
	public boolean cancelCollect(Customer user,String quesId);
}

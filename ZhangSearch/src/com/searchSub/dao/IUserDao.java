package com.searchSub.dao;

import java.util.List;

import com.searchSub.po.Users;

public interface IUserDao {
	public List findByHql(String hql);
	public void save(Users user);
	public void update(Users user);
	public void delete(Users user);
}

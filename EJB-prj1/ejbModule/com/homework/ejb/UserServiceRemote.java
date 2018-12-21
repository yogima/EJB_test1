package com.homework.ejb;

import javax.ejb.Remote;

@Remote
public interface UserServiceRemote {
	public boolean login(String username, String password);
}

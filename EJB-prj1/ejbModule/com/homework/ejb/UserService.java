package com.homework.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserServiceRemote {

    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }

    public boolean login(String username, String password){ 
    	if(username.equals(password)){ 
    		return true;
    	}else 
    		return false; 
    	}
}

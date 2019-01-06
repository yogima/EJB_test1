package com.searchSub.po;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private int customerId;
	private String account;
	private String password;
	private String tel;
	private String email;
	private Set wrongQues = new HashSet(0);
	
	public Set getWrongQues() {
		return wrongQues;
	}
	public void setWrongQues(Set wrongQues) {
		this.wrongQues = wrongQues;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

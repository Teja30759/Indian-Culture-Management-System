package com.klef.ep.services;

import javax.ejb.Remote;

import com.klef.ep.models.User;

@Remote
public interface UserService {
	//signup
	public int adduser(User user);
	
	//login
	public User checkuserlogin(String email, String password);
	
	public void changepass(String email, String password);

}

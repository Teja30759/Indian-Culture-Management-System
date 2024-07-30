package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;

import com.klef.ep.models.User;

@Remote
public interface AdminService {
	
	public Admin checkadminlogin(String username, String password);
    public List<User> viewallusers();
    
    public void changepass(String username, String password);
    
   
    
    
    
  
}

package com.klef.ep.beans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.protobuf.Service;
import com.klef.ep.models.Admin;
import com.klef.ep.models.Places;
import com.klef.ep.services.AdminService;
import com.klef.ep.services.PlacesService;

@ManagedBean(name = "adminbean", eager = true)
public class AdminBean {
	
	@EJB(lookup = "java:global/IndianCulture/AdminServiceIMPL!com.klef.ep.services.AdminService")
	AdminService adminService;
	
	private String username;
	private String password;
	
	
	 FacesContext facesContext = FacesContext.getCurrentInstance();
     ExternalContext externalContext = facesContext.getExternalContext();
  
     HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
   HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void cheakadminlogin() throws IOException
	  {
	  
	  
	   Admin admin = adminService.checkadminlogin(username, password);
	  
	   
	   if(admin!=null)
	   {
	     HttpSession session = request.getSession();
	     session.setAttribute("admin", admin);
	     
	    
	     response.sendRedirect("logginedadminhome.jsp");
	   }
	   else
	   {
	    response.sendRedirect("adminloginfail.indianculture");
	   }
	  }
	
	  
	public void changepassword() throws IOException
	{
		adminService.changepass(username, password);
		
		response.sendRedirect("adminlogin.indianculture");
	}

	 
	  
		

}

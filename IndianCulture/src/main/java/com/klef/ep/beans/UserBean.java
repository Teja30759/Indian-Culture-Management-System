package com.klef.ep.beans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.User;
import com.klef.ep.services.UserService;

@ManagedBean(name = "userbean", eager = true)
public class UserBean {
	
	@EJB(lookup = "java:global/IndianCulture/UserServiceIMPl!com.klef.ep.services.UserService")
	UserService serive;
	FacesContext facesContext = FacesContext.getCurrentInstance();
	ExternalContext externalContext = facesContext.getExternalContext();
	HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	
	private String email;
	private String name;
	private String number;
	private String gender;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void add() throws IOException
	{
		
		
		User u = new User();
		u.setEmail(email);
		u.setName(name);
		u.setNumber(number);
		u.setPassword(password);
		u.setGender(gender);
		
		int adduser = serive.adduser(u);
		if(adduser == 1) {
		
			HttpSession session = request.getSession();
			
			session.setAttribute("us", u); //emp is a session variable of type User u
			response.sendRedirect("registereduserhome.jsp");
		}else
		{
			response.sendRedirect("userreg.jsf");
		}
		
		
		
		
	}
	
	public void validateuser() throws IOException
	{
		User u = serive.checkuserlogin(email, password);
		if(u != null) {
            HttpSession session = request.getSession();
			
			session.setAttribute("us", u);
			response.sendRedirect("registereduserhome.jsp");
		}
		else
		{
			response.sendRedirect("loginfailed.indianculture");
		}
	}
	
	public void changepassword() throws IOException
	{
		serive.changepass(email, password);
		
		response.sendRedirect("userlogin.indianculture");
	}

}

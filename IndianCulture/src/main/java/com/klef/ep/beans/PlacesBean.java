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

import com.klef.ep.models.Places;
import com.klef.ep.services.PlacesService;
import com.mysql.cj.Session;

@ManagedBean(name = "plcBean",eager = true)
public class PlacesBean {
	
	@EJB(lookup = "java:global/IndianCulture/PlacesServiceIMPL!com.klef.ep.services.PlacesService")
	
	PlacesService service;
	FacesContext facesContext = FacesContext.getCurrentInstance();
	ExternalContext externalContext = facesContext.getExternalContext();
	HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	
	private String name;
	private String state;
	
	private String des;
	private String historicalsig;
	private String besttimetovisit;
	
	private List<Places> placeslist;
	
	
	public List<Places> getPlaceslist() {
		return service.viewallplaces();
	}
	public void setPlaceslist(List<Places> placeslist) {
		this.placeslist = placeslist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getHistoricalsig() {
		return historicalsig;
	}
	public void setHistoricalsig(String historicalsig) {
		this.historicalsig = historicalsig;
	}
	public String getBesttimetovisit() {
		return besttimetovisit;
	}
	public void setBesttimetovisit(String besttimetovisit) {
		this.besttimetovisit = besttimetovisit;
	}
	public void addplace() throws IOException {
		
		Places p = new Places();
		
		p.setName(name);
		p.setState(state);
		p.setDes(des);
		p.setHistoricalsig(historicalsig);
		p.setBesttimetovisit(besttimetovisit);
		
		int added = service.addplace(p);
		
		if(added  == 1)
		{
			response.sendRedirect("logginedadminhome.jsp");

		}else
		{
			response.sendRedirect("placesaddingfailed.jsp");
		}
	}
	
	public String delete(String pname)
	{
		service.deleteplace(pname);
		
		return "ViewAllPlaces.indianculture";
	}
	
	public String update() {
		Places p = service.viewplacebyname(name);

		if(p!=null)
		{
		    //System.out.println("ID Found");
		    Places emp = new  Places();
		    
		    emp.setName(name);
		    emp.setState(state);
		    emp.setDes(des);
		    emp.setHistoricalsig(historicalsig);
		    emp.setBesttimetovisit(besttimetovisit);
		    
		    System.out.println(emp.toString());
		    
		    service.updateplace(emp);
		    
		    return "updatesuccessfull.indianculture";
		    
	}else {
		return "updatefailed.indianculture";
	}
	
	
	

	}}

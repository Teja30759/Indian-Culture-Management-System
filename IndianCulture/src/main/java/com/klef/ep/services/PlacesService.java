package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Places;

@Remote
public interface PlacesService {
	
	public int addplace(Places place);
	
	public List<Places> viewallplaces();
	
	public String deleteplace(String pname);
	
	public Places viewplacebyname(String pname);
	
	public String updateplace(Places place);
	

}

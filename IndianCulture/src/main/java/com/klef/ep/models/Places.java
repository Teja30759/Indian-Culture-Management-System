package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places_table")
public class Places implements Serializable{
	
	@Id
	@Column(name = "pname", length = 69)
	private String name;
	@Column(name = "pstate", nullable = false, length = 69)
	private String state;
	@Column(name = "pdes", nullable = false, length = 100)
	private String des;
	@Column(name = "phistoricalsig", nullable = false, length = 200)
	private String historicalsig;
	@Column(name = "pbstime", nullable = false, length = 50)
	private String besttimetovisit;
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

}

package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User implements Serializable {
	
	@Id
	@Column(name = "user_eamil", length = 50 , unique = true)
	private String email;
	@Column(name = "user_name", nullable = false, length = 50)
	private String name;
	@Column(name = "user_number", nullable = false, length = 15)
	private String number;
	@Column(name = "user_password", nullable = false, length = 20)
	private String password;
	@Column(name = "user_gender", nullable = false, length = 20)
    private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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

}

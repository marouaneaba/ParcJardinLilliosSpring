package com.lille1.ParcsJardinsLillios.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String Name;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String Tel;
	@Column
	private String role = "ROLE_ADMIN";
	
	
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password, String email, String tel) {
		super();
		Name = name;
		this.password = password;
		this.email = email;
		Tel = tel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

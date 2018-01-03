package com.lille1.ParcsJardinsLillios.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Admin implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String Name;
	@Column
	private String password;
	@Column
	private String Email;
	@Column
	private String Tel;
	
	
	
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String name, String password, String email, String tel) {
		super();
		Name = name;
		this.password = password;
		Email = email;
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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	
	
	
}

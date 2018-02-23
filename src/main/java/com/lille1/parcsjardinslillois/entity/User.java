package com.lille1.parcsjardinslillois.entity;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String tel;
	@Column
	private String role = "ROLE_ADMIN";

	public User() {
		//constructeur sans parametres

	}

	public User(String name, String password, String email, String tel) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", tel=" + tel
				+ ", role=" + role + "]";
	}

	
}

package com.logos.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Person.FIND_BY_EMAIL, query = "SELECT p FROM Person p WHERE p.email = :email") })
public class Person {

	public static final String FIND_BY_EMAIL = "Person.findByEmail";

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) 
	@JoinTable(name = "person_role", joinColumns = { 
	@JoinColumn(name = "PERSON_ID", nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", 
	nullable = false, updatable = false) })
	private List<Role> roles = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void addAllRoles(List<Role> list)
	{
		roles.addAll(list);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

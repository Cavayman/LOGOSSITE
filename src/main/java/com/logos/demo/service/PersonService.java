package com.logos.demo.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.logos.demo.model.Person;
import com.logos.demo.model.Role;

public interface PersonService {
	@Secured(value="ROLE_ADMIN")
	List<Person> getAll();
	
	void save(Person person);
	
	Person getById (long id);
	
	void save(Person person,String[] role);

}

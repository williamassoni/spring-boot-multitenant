package com.example.multitenant.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String findPerson() {
		Person person = personRepository.findOne(1L);
		return String.format("[person: id: %s name: %s]",person.getId(),person.getName());
	}
}
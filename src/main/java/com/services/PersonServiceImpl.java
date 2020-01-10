package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entities.Person;
import com.repository.GenericRepository;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	@Qualifier("com.repository.GenericRepository")
	private GenericRepository<Person> repository;

	@Override
	public void create(Person person) {
		this.repository.save(person);
	}

	@Override
	public List<Person> readAll() {
		return (List<Person>) this.repository.findAll();
	}

	@Override
	public void update(Person person) {
		this.repository.save(person);
	}

	@Override
	public void delete(Person person) {
		this.repository.delete(person);
	}

}

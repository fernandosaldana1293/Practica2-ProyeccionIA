package edu.usmp.ProyeccionIA.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import edu.usmp.ProyeccionIA.model.Person;

public interface PersonRepository extends Repository<Person,Integer> {
	
	void save(Person person);
	
	List<Person> findAll();
	
	Person findById(Integer id);
	
}

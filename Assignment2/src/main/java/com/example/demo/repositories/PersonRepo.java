package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entities.Person;

public interface PersonRepo extends MongoRepository<Person, Integer> {
	
}

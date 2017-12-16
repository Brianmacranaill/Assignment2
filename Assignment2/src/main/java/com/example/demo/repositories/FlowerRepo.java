package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entities.Flower;

public interface FlowerRepo extends MongoRepository<Flower, Integer>{
	Flower findByName(String string);
}

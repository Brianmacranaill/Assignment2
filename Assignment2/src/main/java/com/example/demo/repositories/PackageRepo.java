package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Package;

public interface PackageRepo extends MongoRepository<Package, Integer>{
	
}

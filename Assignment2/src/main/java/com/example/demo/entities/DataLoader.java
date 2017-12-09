package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repositories.PersonRepo;
import com.example.demo.repositories.FlowerRepo;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		personRepo.save(new Person(1, "Admin", 65, "Admin@example.ie"));
		personRepo.save(new Person(2, "Brian", 50, "Brian@example.ie"));
		personRepo.save(new Person(3, "Test", 56, "Test@example.ie"));
		
		flowerRepo.save(new Flower(1, "Rose", "Red", 10));
		flowerRepo.save(new Flower(2, "Tulip", "Blue", 5));
	}
}

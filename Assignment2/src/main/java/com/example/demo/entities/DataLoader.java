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
		personRepo.save(new Person(1, "Minnie Mouse", 65, "Minnie@cit.ie"));
		personRepo.save(new Person(2, "Daisy Duck", 50, "Daisy@cit.ie"));
		personRepo.save(new Person(3, "Gru", 56, "Gru@cit.ie"));
		
		flowerRepo.save(new Flower(1, "Flower One", "Red", 10));
		flowerRepo.save(new Flower(2, "Flower Two", "Blue", 5));
	}
}

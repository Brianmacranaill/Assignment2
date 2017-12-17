package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repositories.PersonRepo;
import com.example.demo.repositories.FlowerRepo;
import com.example.demo.repositories.PackageRepo;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	@Autowired
	PackageRepo packageRepo;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		personRepo.save(new Person(1, "Admin", 65, "Admin@example.ie"));
		personRepo.save(new Person(2, "Brian", 50, "Brian@example.ie"));
		personRepo.save(new Person(3, "Test", 56, "Test@example.ie"));
		
		flowerRepo.save(new Flower(1, "Rose", "Red", 10, 5));
		flowerRepo.save(new Flower(2, "Tulip", "Blue", 5, 3));
		
		packageRepo.save(new Package(1, "Valentine's Day Package 1", 100));
		packageRepo.save(new Package(5, "Birthday Package 1", 150));
		packageRepo.save(new Package(10, "Marriage Anniversaries Package 1", 75));
		packageRepo.save(new Package(15, "Other Special Occasions Package 1", 200));
		packageRepo.save(new Package(20, "Chocolates", 10));
		packageRepo.save(new Package(21, "Teddy Bear", 15));
		packageRepo.save(new Package(22, "Addon Item 3", 12));
	}
}

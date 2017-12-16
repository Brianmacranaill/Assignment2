package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.entities.Flower;
import com.example.demo.repositories.FlowerRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	FlowerRepo flowerRepo;
	List<Flower> defaultContent;
	public static int tests = 1;
	
	@Before//Happens before each test
	public void before(){
		System.out.println("JUnit Test " + tests + " Started");
		defaultContent = flowerRepo.findAll();
		flowerRepo.deleteAll();
	}
	
	
	@After//Happens after each test
	public void after(){
		System.out.println("JUnit Test " + tests + " Finished");
		flowerRepo.deleteAll();
		flowerRepo.insert(defaultContent);
		tests++;
	}
	
	@Test//Runs on it's own between before and after
	public void findOneFlower() {
		Flower test = new Flower(1, "TestFlower", "TestColour", 100, 5);
		flowerRepo.insert(test);
		Flower answer = flowerRepo.findOne(1);
		assertTrue(test.getId() == answer.getId());
		assertTrue(test.getName() == answer.getName());
		assertTrue(test.getColour() == answer.getColour());
		assertTrue(test.getQuantity() == answer.getQuantity());
		assertTrue(test.getCost() == answer.getCost());
	}
	
	@Test//Runs on it's own between before and after
	public void findFlowerByName() {
		Flower test = new Flower(1, "TestFlower", "TestColour", 50, 5);
		flowerRepo.insert(test);
		Flower answer = flowerRepo.findByName("TestFlower");
		assertTrue(test.getId() == answer.getId());
		assertTrue(test.getName() == answer.getName());
		assertTrue(test.getColour() == answer.getColour());
		assertTrue(test.getQuantity() == answer.getQuantity());
		assertTrue(test.getCost() == answer.getCost());
	}

}

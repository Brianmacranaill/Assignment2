package com.example.demo;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void get() {
		Flower f = flowerRepo.findOne(1);
		assertEquals("Rose", f.getName());
	}

}

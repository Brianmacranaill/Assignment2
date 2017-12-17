package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepo;
import com.example.demo.entities.Flower;
import com.example.demo.repositories.FlowerRepo;

@Controller
public class Controllers {
	
	@Autowired
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	/**
	 * Calls index.html
	 */
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Model model)
//	{
//		return "index";
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login()
//	{
//		return "login";
//	}
	
	@GetMapping("/")
    public String home1() {
        return "/fragments/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/fragments/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/adminPage";
    }

    @GetMapping("/user")
    public String user() {
        //return "/fragments/user";
    	return "/index";
    }

    @GetMapping("/about")
    public String about() {
        return "/fragments/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/fragments/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/fragments/403";
    }
	
	@GetMapping("/valentinesDay")
	public String valentinesDay(Model model)
	{
		return "valentinesDay";
	}
	
	@GetMapping("/birthday")
	public String birthday(Model model)
	{
		return "birthday";
	}
	
	@GetMapping("/anniversaries")
	public String anniversaries(Model model)
	{
		return "anniversaries";
	}
	
	@GetMapping("/otherOccasions")
	public String otherOccasions(Model model)
	{
		return "otherOccasions";
	}
	
	@GetMapping("/addonItems")
	public String addonItems(Model model)
	{
		return "addonItems";
	}
	
	/*
	 * An example of using a path variable
	 * localhost:8080/usingParameter?name=Cliona will add Cliona to the welcome
	 * localhost:8080/usingParameter will add the default value of To You!
	 */
	
	@GetMapping("/usingParameter")
	public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To You!")String name, Model model)
	{
		String sentence = "Welcome " + name;
		model.addAttribute("message", sentence);
		return "parameter";
	}
	
	/*
	 * This repository uses the in-built findAll() method of MongoRepository
	 * This returns a list of People
	 * This list is added to the model
	 * The model is sent to the displayALl.html template.
	 */
	
	@GetMapping("/displayAll")
	public String displayAll(Model model)
	{
		List<Person> p = personRepo.findAll();
		model.addAttribute("people", p);
		List<Flower> f = flowerRepo.findAll();
		model.addAttribute("flower", f);
		return "displayAll";
	}
	
	/*
	 * This uses a PathVariable to specify the id being searched for.
	 * findOne() is the default method to search for one record using MongoRepository.
	 * It returns one record.
	 * This record is added to the model.
	 * The model is sent to displayOne.html resolver
	 */
	
	@GetMapping("/displayOne/{id}")
	public String showMyDetails(@PathVariable int id, Model model)
	{
		Person p = (Person) personRepo.findOne((int) id);
		model.addAttribute("person", p);
		return "displayOne";
	}
}

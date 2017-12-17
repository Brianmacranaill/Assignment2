package utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Flower;
import com.example.demo.entities.Package;
import com.example.demo.repositories.PackageRepo;

@Service
public class Worker {
	@Autowired
	PackageRepo packageRepo;
	@Autowired
	Cart cart;
	
	RestTemplate restTemplate;
	String backendURL;
	
	public Worker(){
		this.restTemplate = new RestTemplate();
		this.backendURL = "http://localhost:8080";
	}
	
	public Cart getCart(){
		return cart;
	}
	
	public List<Package> packages(){
		return packageRepo.findAll();
	}
	
	public Flower[] getFlowers(){
		Flower[] f = restTemplate.getForObject(backendURL+"/allFlowers", Flower[].class);
		return f;
	}
	
	public void addToCart(Package packageToAdd){
		cart.addPackage(packageToAdd);
	}
}

package com.forge.PortfolioReviewService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.User;
import com.forge.PortfolioReviewService.repository.PortfolioRepo;
import com.forge.PortfolioReviewService.repository.UserRepo;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private PortfolioRepo portfolioRepo;
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/getAllPortfolios")
	public List<Portfolio> getPortfolios(){
		List<Portfolio> myList = portfolioRepo.findAll();
		return myList;
	}
	
	@GetMapping("/getPortfolio")
	public List<Portfolio> getPortfolio(@RequestParam int id) {
		return portfolioRepo.findByMyUser(getUser(id));
	}
	
	@GetMapping("/getPortfoliosByStatus")
	public List<Portfolio> getPortfoliosByStatus(@RequestParam String status){
		List<Portfolio> myList = portfolioRepo.findByStatus(status);
		return myList;
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam int id) {
		return userRepo.findByUserId(id);
	}
	
	@GetMapping("/getPortfolioByID/{id}")
//	@RequestMapping(value = "/getPortfolioByID/{id}", method = RequestMethod.GET)
	public @ResponseBody Portfolio getPortfolioByID(@PathVariable("id") String id) {
		int i = Integer.parseInt(id);
		Portfolio p = portfolioRepo.findById(i);
		return p;
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public @ResponseBody User getUserByEmail(@PathVariable("email") String email) {
		User u = userRepo.findByEmail(email);
		return u;
	}
	
	@PutMapping("/updatePortfolio")
	public void updatePortfolio(@RequestBody Portfolio portfolio) {
		System.out.println("Received portfolio " + portfolio);
		portfolioRepo.save(portfolio);
	}
}

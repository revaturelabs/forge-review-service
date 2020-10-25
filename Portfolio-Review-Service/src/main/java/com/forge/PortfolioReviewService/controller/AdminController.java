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

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private PortfolioRepo portfolioRepo;
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/getAllPortfolios")
//	@ApiOperation(value="Getting all portofios",
//	  			  notes = "Retrieving all the portfolios to view them")
	public List<Portfolio> getPortfolios(){
		List<Portfolio> myList = portfolioRepo.findAll();
		return myList;
	}
	
	@GetMapping("/getPortfolio")
//	@ApiOperation(value="Getting a specific portfolio",
//	  			  notes = "Retrieving a specific portfolio from a user to review")
	public List<Portfolio> getPortfolio(@RequestParam int id) {
		return portfolioRepo.findByMyUser(getUser(id));
	}
	
	@GetMapping("/getPortfoliosByStatus")
//	@ApiOperation(value="Getting portfolio status",
//	  			  notes = "Retrieving portfolio status to filter accordingly")
	public List<Portfolio> getPortfoliosByStatus(@RequestParam String status){
		List<Portfolio> myList = portfolioRepo.findByStatus(status);
		return myList;
	}
	
	@GetMapping("/getAllUsers")
//	@ApiOperation(value="Getting the users",
//				  notes = "Retrieving the users that correspond with the portfolios")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getUser")
//	@ApiOperation(value="Getting a user for verification",
//	  			  notes = "Retrieving a specific user so they can login in accordingly")
	public User getUser(@RequestParam int id) {
		return userRepo.findByUserId(id);
	}
	
	@GetMapping("/getPortfolioByID/{id}")
//	@ApiOperation(value="Getting a portfolio by Id",
//	  			  notes = "Retrieving a specific portfolio from a user")
	public @ResponseBody Portfolio getPortfolioByID(@PathVariable("id") String id) {
		int i = Integer.parseInt(id);
		Portfolio p = portfolioRepo.findById(i);
		return p;
	}
	
	@GetMapping("/getUserByEmail/{email}")
//	@ApiOperation(value="Getting a user by their email",
//	  			  notes ="Retrieving a users with that specific portfolios")
	public @ResponseBody User getUserByEmail(@PathVariable("email") String email) {
		User u = userRepo.findByEmail(email);
		return u;
	}
	
	@PutMapping("/updatePortfolio")
//	@ApiOperation(value="Updating Portfolios",
//	  			  notes ="Updating a portfolio from a specific user")
	public void updatePortfolio(@RequestBody Portfolio portfolio) {
		System.out.println("Received portfolio " + portfolio);
		portfolioRepo.save(portfolio);
	}
}

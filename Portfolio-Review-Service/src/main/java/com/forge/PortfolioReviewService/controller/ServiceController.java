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

import com.forge.PortfolioReviewService.models.AboutMe;
import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.User;
import com.forge.PortfolioReviewService.repository.PortfolioRepo;
import com.forge.PortfolioReviewService.repository.UserRepo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class ServiceController {
	
	@Autowired
	private PortfolioRepo portfolioRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	/*
 	Gets all portfolios from the database.
	Returns a lists of all portfolios.
	 */
	@GetMapping("/getAllPortfolios")
	@ApiOperation(value="Getting all portofios",
	  			  notes = "Retrieving all the portfolios to view them")
	public List<Portfolio> getPortfolios(){
		List<Portfolio> myList = portfolioRepo.findAll();
		return myList;
	}
	
	/*
 	Gets all portfolios by their status from the database.
 	Input is status. 
	Returns a lists of portfolios by status.
	 */
	@GetMapping("/getPortfoliosByStatus")
	@ApiOperation(value="Getting portfolio status",
	  			  notes = "Retrieving portfolio status to filter accordingly")
	public List<Portfolio> getPortfoliosByStatus(@RequestParam String status){
		List<Portfolio> myList = portfolioRepo.findByStatus(status);
		return myList;
	}
	
	/*
 	Gets all users from the database.
	Returns a lists of all users.
	 */
	@GetMapping("/getAllUsers")
	@ApiOperation(value="Getting the users",
				  notes = "Retrieving the users that correspond with the portfolios")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	/*
 	Gets user by id from the database.
 	Input is user id.
	Returns one user.
	 */
	@GetMapping("/getUser")
	@ApiOperation(value="Getting a user for verification",
	  			  notes = "Retrieving a specific user so they can login in accordingly")
	public User getUser(@RequestParam int id) {
		return userRepo.findByUserId(id);
	}
	
	/*
 	Sending user info to database.
 	Input is user object.
 	No output, but user info is saved into database.
	 */
  @PostMapping("/createUser")
  @ApiOperation(value = "Creating a new user",
		  		notes = "Sending user information to the database")
	public void saveUser(@RequestBody User u) {
		System.out.println(u);
		userRepo.save(u);
		
	}
  /*
	Gets user by email from the database.
	Input is user email.
	Returns one user.
	 */
	@GetMapping("/getUserByEmail/{email}")
	@ApiOperation(value="Getting a user by their email",
	  			  notes ="Retrieving a users with that specific portfolios")
	public @ResponseBody User getUserByEmail(@PathVariable("email") String email) {
		User u = userRepo.findByEmail(email);
		return u;
	}
	/*
	 ~~~~REFACTOR~~~~
	 SHOULD update portfolio in database.
	 Input portfolio object.
	 No output, but it updates portfolio.
	 Special Notes/Suggestions: Should update by id not a object, by first getting the portfolio and then
	 		updating info within the portfolio because portfolio exists in database prior to this.
	 */
	@PutMapping("/updatePortfolio")
	@ApiOperation(value="Updating Portfolios",
	  			  notes ="Updating a portfolio from a specific user")
	public void updatePortfolio(@RequestBody Portfolio portfolio) {
		System.out.println("Received portfolio " + portfolio);
		portfolioRepo.save(portfolio);
	}
	/*
	 Gets portfolio by id.
	 Input is portfolio id.
	 Returns portfolio.
	 */
	@GetMapping("/getPortfolioByID/{id}")
	@ApiOperation(value="Getting a portfolio by Id",
	  			  notes = "Retrieving a specific portfolio from a user")
	public @ResponseBody Portfolio getPortfolioByID(@PathVariable("id") String id) {
		int i = Integer.parseInt(id);
		Portfolio p = portfolioRepo.findById(i);
		return p;
	}
	
	/*
	 Creates a portfolio.
	 Input is portfolio object.
	 No output, because portfolio is saved in database.
	 */
	@PostMapping("/createPortfolio")
	@ApiOperation(value="Adding a Portfolios",
	  			 notes ="Adding a portfolio to a specific user")
    public void createPortfolio(@RequestBody Portfolio portfolio) {
        portfolioRepo.save(portfolio);
    }
	
	/*
	 ~~~~REFACTOR~~~~
	 Should get portfolios by user id.
	 Input user id.
	 Returns a list of portfolios?
	 */
	@GetMapping("/getPortfolio")
	@ApiOperation(value="Getting a specific portfolio",
	  			  notes = "Retrieving a specific portfolio from a user to review")
	public List<Portfolio> getPortfolio(@RequestParam int id) {
		return portfolioRepo.findAllByMyUser(getUser(id));
	}	
	
	/*
	 ~~~~ REFACTOR ~~~~
	 Get a new portfolio.
	 Input user id.
	 Should return a created portfolio.
	 Where is the portfolio info coming from?
	 This will not work.
	 */
	@GetMapping("/createPortfolio")
	@ApiOperation(value = "Creating a new portfolio",
		notes = "Sending portfolio information to the database")
    public Portfolio createPortfolio(@RequestParam int userId) {
        System.out.println(userId);
        User u = userRepo.findByUserId(userId);
        Portfolio p = new Portfolio();
        p.setBelongsTo(u.getEmail());
        p.setStatus("Pending");
        p.setMyUser(u);

        AboutMe about = new AboutMe();
        about.setDescription("Add about me");

        System.out.println(p);
        portfolioRepo.save(p);

        //Get portfolio 
        int createdPortfolio = portfolioRepo.createdPorfolio();
        System.out.println(createdPortfolio);

        Portfolio port = portfolioRepo.findById(createdPortfolio);

        System.out.println(port);
        return port;
    }
}

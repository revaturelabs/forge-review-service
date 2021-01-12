package com.forge.PortfolioReviewService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PortfolioReviewService.models.AboutMe;
import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.PortfolioItems;
import com.forge.PortfolioReviewService.repository.PortfolioItemsRepo;
import com.forge.PortfolioReviewService.repository.PortfolioRepo;
import com.forge.PortfolioReviewService.repository.UserRepo;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/update")
@CrossOrigin
public class PortfolioUpdateController {
	
	@Autowired
	private PortfolioRepo portfolioRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PortfolioItemsRepo portfolioItemsRepo; //potfolio4lyfe
	
	
	
	//utility method for testing persistence
	@GetMapping("/getAllPortfolioItems")
	@ApiOperation(value="Getting a specific portfolio",
	  			  notes = "Retrieving a specific portfolio from a user to review")
	public List<PortfolioItems> getAllPortfolioItems() {

		return portfolioItemsRepo.findAll();

	}
	
	//needs testing to determine whether portfolio info is necessary
	//uniform method for updating any
	//must pass in portfolio Id
	@PutMapping("/updatePortfolioItems/{pid}")
	@ApiOperation(value="Updating the Project Technology Section",
	  			  notes = "Updating the project technology section")
	public String updatePortfolioItems(@PathVariable(value = "pid")int id, @RequestBody PortfolioItems portfolioItems) {
		portfolioItems.setPortfolio(portfolioRepo.findById(id));
		portfolioItemsRepo.save(portfolioItems);
		System.out.println(portfolioItems);
		return "Success!";
	}
	@GetMapping(value="/getaboutMe/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Getting the About Me",
	  			  notes = "Retrieving the about me section")
	public AboutMe getUpdateAboutMe(@PathVariable(value="id") int id) {
		
		return portfolioItemsRepo.findByItemId(id);
		
	}
	@PutMapping(value="/updateAboutMe/{pid}", consumes= MediaType.APPLICATION_JSON_VALUE)
	public void updateAboutMe(@PathVariable(value="pid") int id,@RequestBody AboutMe aboutMe) {
		aboutMe.setPortfolio(portfolioRepo.findById(id));
		portfolioItemsRepo.save(aboutMe);
	}
	

	@PostMapping("/createPortfolioItems/{id}")
//	@ApiOperation(value="Adds new Portfolio Items",
//	  			 notes ="Adds a new portfolioItem to a specific portfolio")
    public PortfolioItems createPortfolioItems(@PathVariable(value="id") int id ,@RequestBody PortfolioItems portfolioItem) {
		 portfolioItem.setPortfolio(portfolioRepo.findById(id));
		
		return portfolioItemsRepo.save(portfolioItem);

    }


	
	@DeleteMapping("/deletePortfolioItem/{id}")
	public String deleteIndustryEquivalency(@PathVariable(value="id") int id, @RequestBody PortfolioItems portfolioItem) {
		portfolioItemsRepo.delete(portfolioItem);
		return "Success!";
	}
}

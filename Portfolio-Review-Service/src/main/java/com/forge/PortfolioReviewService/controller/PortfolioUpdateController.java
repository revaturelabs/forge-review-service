package com.forge.PortfolioReviewService.controller;

import java.util.List;
import java.util.Optional;

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
import com.forge.PortfolioReviewService.models.Education;
import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.PortfolioItems;
import com.forge.PortfolioReviewService.models.Project;
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
	
	
	//GETS
	
	//utility method for testing persistence
		@GetMapping("/getAllPortfolioItems")
		@ApiOperation(value="Getting a specific portfolio",
		  			  notes = "Retrieving a specific portfolio from a user to review")
		public List<PortfolioItems> getAllPortfolioItems() {

			return portfolioItemsRepo.findAll();

		}
		
		@GetMapping("/getPortfolioItemsByPortfolioId/{pid}")
		@ApiOperation(value="Getting a specific portfolio",
		  			  notes = "Retrieving a specific portfolio from a user to review")
		public AboutMe getAllPortfolioItemsByPortfolio(@PathVariable(value = "pid")int id) {
			
			System.out.println(portfolioItemsRepo.findByItemId(id));
					
			return portfolioItemsRepo.findById(id);
		}
		
		@GetMapping(value="/getaboutMe/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Getting the About Me",
		  			  notes = "Retrieving the about me section")
		public AboutMe getUpdateAboutMe(@PathVariable(value="id") int id) {
			
			return portfolioItemsRepo.findByItemId(id);
			
		}
		
		@GetMapping(value="/getProject/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value="Getting the About Me",
		  			  notes = "Retrieving the about me section")
		public Project getUpdateProject(@PathVariable(value="id") int id) {
			
			
			return portfolioItemsRepo.findProjectByItemId(id);
			
		}
	
	//POSTS
	
		@PostMapping("/createEducationItem/{id}")
//		@ApiOperation(value="Adds new Portfolio Items",
//		  			 notes ="Adds a new portfolioItem to a specific portfolio")
	    public PortfolioItems createEducationItem(@PathVariable(value="id") int id, @RequestBody Education education) {
			education.setItemType("Education");
			education.setPortfolio(portfolioRepo.findById(id));
			PortfolioItems portItem = education;
		
			return portfolioItemsRepo.save(portItem);

	    }
		
		@PostMapping("/createPortfolioItems/{id}")
//		@ApiOperation(value="Adds new Portfolio Items",
//		  			 notes ="Adds a new portfolioItem to a specific portfolio")
	    public PortfolioItems createPortfolioItems(@PathVariable(value="id") int id ,@RequestBody PortfolioItems portfolioItem) {
			portfolioItem.setPortfolio(portfolioRepo.findById(id));
			System.out.println(portfolioItem);
			//return portfolioItem;
			

			return portfolioItemsRepo.save(portfolioItem);

	    }

	
	//PUTS
	
		@PutMapping("/updatePortfolioItems/{pid}")
		@ApiOperation(value="Updating the Project Technology Section",
		  			  notes = "Updating the project technology section")
		public String updatePortfolioItems(@PathVariable(value = "pid")int id, @RequestBody PortfolioItems portfolioItems) {
			portfolioItems.setPortfolio(portfolioRepo.findById(id));
			portfolioItemsRepo.save(portfolioItems);
			System.out.println(portfolioItems);
			return "Success!";
		}
		
		@PutMapping(value="/updateAboutMe/{pid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public void updateAboutMe(@PathVariable(value="pid") int id,@RequestBody AboutMe aboutMe) {
			aboutMe.setPortfolio(portfolioRepo.findById(id));
			portfolioItemsRepo.save(aboutMe);
		}
		
		@PutMapping(value="/updateProject/{pid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public void updateProject(@PathVariable(value="pid") int id,@RequestBody Project project) {
			project.setPortfolio(portfolioRepo.findById(id));
			portfolioItemsRepo.save(project);
		}
	
	//DELETE
	


	//untested
	@DeleteMapping("/deletePortfolioItem/{id}")
	public String deleteIndustryEquivalency(@PathVariable(value="id") int id, @RequestBody PortfolioItems portfolioItem) {
		portfolioItemsRepo.delete(portfolioItem);
		return "Success!";
	}
}

package com.forge.PortfolioReviewService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PortfolioReviewService.models.Education;
import com.forge.PortfolioReviewService.models.PortfolioItems;
import com.forge.PortfolioReviewService.models.SkillMatrix;
import com.forge.PortfolioReviewService.models.SkillMatrixItems;
import com.forge.PortfolioReviewService.repository.PortfolioItemsRepo;
import com.forge.PortfolioReviewService.repository.PortfolioRepo;
import com.forge.PortfolioReviewService.repository.SkillMatrixItemRepo;
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
	
	@Autowired
	private SkillMatrixItemRepo skillMatrixItemRepo;
	
	
	
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
	
	

	@PostMapping("/createPortfolioItems/{id}")
//	@ApiOperation(value="Adds new Portfolio Items",
//	  			 notes ="Adds a new portfolioItem to a specific portfolio")
    public PortfolioItems createPortfolioItems(@PathVariable(value="id") int id ,@RequestBody PortfolioItems portfolioItem) {
		 portfolioItem.setPortfolio(portfolioRepo.findById(id));
		
		return portfolioItemsRepo.save(portfolioItem);

    }


	@PostMapping("/createSkillCategory/{id}")
//  @ApiOperation(value="Adds new Portfolio Items",
//                 notes ="Adds a new portfolioItem to a specific portfolio")
	public PortfolioItems createSkillMatrixItem(@PathVariable(value = "id") int id, @RequestBody SkillMatrix skillMatrix) {
		System.out.println("Create Skill Matrix");
		System.out.println(skillMatrix);
		skillMatrix.setPortfolio(portfolioRepo.getOne(id));
		//skillMatrix.setSkillTitle(skillMatrix.getSkillTitle());
		PortfolioItems portItem = skillMatrix;
		PortfolioItems newPortItem = portfolioItemsRepo.save(portItem); //1 save
		int portItemid = newPortItem.getPortfolioItemId(); //get portitemid
		skillMatrix.setSkillMatrixId(portItemid);
		return portfolioItemsRepo.save(skillMatrix);
	}
	
	@PostMapping("/createSkill/{id}")
	public SkillMatrixItems createSkill(@PathVariable(value = "id") int id,@RequestBody SkillMatrixItems skillMatrixItem) {
		System.out.println("Create Skill");
		System.out.println(skillMatrixItem);
		skillMatrixItem.setPortfolioItems(portfolioItemsRepo.getOne(id));
		
		return skillMatrixItemRepo.save(skillMatrixItem);
		
	}
	
	@DeleteMapping("/deletePortfolioItem/{id}")
	public String deleteIndustryEquivalency(@PathVariable(value="id") int id, @RequestBody PortfolioItems portfolioItem) {
		portfolioItemsRepo.delete(portfolioItem);
		return "Success!";
	}
}

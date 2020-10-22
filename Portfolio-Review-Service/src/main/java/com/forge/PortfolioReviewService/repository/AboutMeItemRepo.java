package com.forge.PortfolioReviewService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioReviewService.models.AboutMeItem;

@Repository
public interface AboutMeItemRepo extends CrudRepository<AboutMeItem, Integer>{

	public AboutMeItem save(AboutMeItem aboutMeItem);
	
	public List<AboutMeItem> findAll();
	
	public AboutMeItem findById(int id);

}

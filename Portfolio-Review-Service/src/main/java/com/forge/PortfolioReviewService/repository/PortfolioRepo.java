package com.forge.PortfolioReviewService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioReviewService.models.Portfolio;

@Repository
public interface PortfolioRepo extends CrudRepository<Portfolio, Integer>{

	public Portfolio save(Portfolio portfolio);

	public List<Portfolio> findAll();
	
	public Portfolio findById(int id);
	
	public List<Portfolio> findByStatus(String status);

}

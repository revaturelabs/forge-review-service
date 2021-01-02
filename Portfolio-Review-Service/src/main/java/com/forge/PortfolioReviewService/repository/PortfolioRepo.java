package com.forge.PortfolioReviewService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.User;

@Repository
public interface PortfolioRepo extends CrudRepository<Portfolio, Integer>{

	public Portfolio save(Portfolio portfolio);

	public List<Portfolio> findAll();
	
	public Portfolio findById(int id);
	
	public List<Portfolio> findByMyUser(Optional<User> user);
	
	public List<Portfolio> findByStatus(String status);

	@Query("SELECT MAX(id) from Portfolio Portfolio")
    public int createdPorfolio();
}

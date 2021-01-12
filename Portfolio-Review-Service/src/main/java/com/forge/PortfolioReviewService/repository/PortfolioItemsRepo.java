package com.forge.PortfolioReviewService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.forge.PortfolioReviewService.models.AboutMe;
import com.forge.PortfolioReviewService.models.IndustryEquivalency;
import com.forge.PortfolioReviewService.models.PortfolioItems;

//@NoRepositoryBean
public interface PortfolioItemsRepo extends JpaRepository<PortfolioItems, Integer> {

	public AboutMe findById(int id);
	
	@Query(value="SELECT * FROM portfolio_items JOIN about_me ON portfolio_items.portfolio_items_id = about_me.portfolio_items_id WHERE portfolio_items.item_type='about_me' AND portfolio_id=:portfolioId", nativeQuery=true)
	public AboutMe findByItemId(@Param("portfolioId") int portfolioId);
	
	@Query(value="SELECT * FROM portfolio_items JOIN industry_equivalency ON portfolio_items.portfolio_items_id = industry_equivalency.portfolio_items_id WHERE portfolio_items.item_type='industry_equivalency' AND portfolio_id=:portfolioId", nativeQuery=true)
	public IndustryEquivalency[] findByIndustryItemId(@Param("portfolioId") int portfolioId);
	
	
}

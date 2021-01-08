package com.forge.PortfolioReviewService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioReviewService.models.AboutMe;

@Repository
public interface AboutMeRepo extends JpaRepository<AboutMe, Integer>{
	
	public List<AboutMe> findAll();
	
	public AboutMe findById(int id);
	
	@Query(value="SELECT * FROM about_me_table WHERE portfolio_items_id=:portfolioItemsId", nativeQuery=true)
	public AboutMe findByItemId(@Param("portfolioItemsId") int portfolioItemId);

}

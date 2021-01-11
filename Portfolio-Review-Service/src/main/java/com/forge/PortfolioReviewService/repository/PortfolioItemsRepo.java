package com.forge.PortfolioReviewService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.forge.PortfolioReviewService.models.PortfolioItems;

//@NoRepositoryBean
public interface PortfolioItemsRepo extends JpaRepository<PortfolioItems, Integer> {
//	PortfolioItems savePortfolioItems(int i, PortfolioItems portfolioItem);
}

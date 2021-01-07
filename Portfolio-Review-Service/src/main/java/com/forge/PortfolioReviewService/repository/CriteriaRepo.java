package com.forge.PortfolioReviewService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.forge.PortfolioReviewService.models.Criteria;


@Repository
public interface CriteriaRepo extends JpaRepository<Criteria, Integer>{
	
	public List<Criteria> findAll();
	public Criteria save(Criteria criteria);
	public Criteria findById( int id);

}

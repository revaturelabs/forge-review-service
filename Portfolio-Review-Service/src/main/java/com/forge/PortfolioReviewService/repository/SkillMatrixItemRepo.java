package com.forge.PortfolioReviewService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioReviewService.models.SkillMatrixItem;

@Repository
public interface SkillMatrixItemRepo extends CrudRepository<SkillMatrixItem, Integer>{

	public SkillMatrixItem save(SkillMatrixItem skillMatrixItem);
	
	public List<SkillMatrixItem> findAll();
	
	public SkillMatrixItem findById(int id);
	
}

package com.forge.PortfolioReviewService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioReviewService.models.ProjectTechnologies;

@Repository
public interface ProjectTechnologiesRepo extends CrudRepository<ProjectTechnologies, Integer>{

	public ProjectTechnologies save(ProjectTechnologies projectTechnologies);
	
	public List<ProjectTechnologies> findAll();
	
	public ProjectTechnologies findById(int id);

}

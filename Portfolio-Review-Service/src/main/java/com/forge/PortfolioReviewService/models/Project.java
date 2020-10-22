package com.forge.PortfolioReviewService.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="portfolio_id", nullable=false)
	@JsonBackReference
	private Portfolio portfolio;
	
	@OneToMany(mappedBy = "project")
	private Set<ProjectResponsibilities> projectResponsibilities;
	
	@OneToMany(mappedBy = "project")
	private Set<ProjectTechnologies> projectTechnologies;
}

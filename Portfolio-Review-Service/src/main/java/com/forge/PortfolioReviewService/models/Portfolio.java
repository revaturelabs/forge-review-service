package com.forge.PortfolioReviewService.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolio")
public class Portfolio {
 
	@Id
	@Column(name = "portfolio_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "belongs_to", nullable = false)
	private String belongsTo;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@OneToOne(mappedBy = "portfolio")
    private AboutMe aboutMe;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	@JsonBackReference
	private User myUser;

	@OneToMany(mappedBy = "portfolio")
	@JsonBackReference
	private List<Project> projects;
	
	@OneToMany(mappedBy = "portfolio")
	@JsonBackReference
	private List<Education> education;
	
	@OneToMany(mappedBy = "portfolio")
	@JsonBackReference
	private List<SkillMatrix> skillMatrix;
	
	@OneToMany(mappedBy = "portfolio")
	@JsonBackReference
	private List<IndustryEquivalency> industryEquivalency;

}

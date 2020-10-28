package com.forge.PortfolioReviewService.models;

import java.util.Set;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolio")
@EqualsAndHashCode(exclude = {"projects", "education", "skillMatrix", "industryEquivalency"})
@Generated()
public class Portfolio {
 
	@Id
	@Column(name = "portfolio_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "belongs_to", nullable = false)
	private String belongsTo;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@OneToOne(mappedBy = "portfolio", cascade = CascadeType.ALL)
	@JsonManagedReference(value="portfolio")
    private AboutMe aboutMe;

//	@OneToMany(mappedBy = "portfolio")
//	@JsonManagedReference(value="aboutMePortfolio")
//	private Set<AboutMe> aboutMe;
	
	@JsonBackReference(value="myUser")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private User myUser;

	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
	@JsonManagedReference(value="projectPortfolio")
	private Set<Project> projects;
	
	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
	@JsonManagedReference(value="educationPortfolio")
	private Set<Education> education;
	
	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
	@JsonManagedReference(value="matrixPortfolio")
	private Set<SkillMatrix> skillMatrix;
	
	@OneToMany(mappedBy = "portfolio",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="industryPortfolio")
	private Set<IndustryEquivalency> industryEquivalency;

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", belongs_to=" + belongsTo + ", status=" + status + "]";
	}
}

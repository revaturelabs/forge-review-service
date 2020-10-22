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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skill_matrix")
public class SkillMatrix {

	@Id
	@Column(name = "skill_matrix_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="portfolio_id", nullable=false)
	private Portfolio portfolio;
	
	@OneToMany(mappedBy = "skillMatrix")
	private Set<SkillMatrixItem> skillMatrixItem;
}

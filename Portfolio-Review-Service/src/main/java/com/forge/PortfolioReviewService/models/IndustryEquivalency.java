package com.forge.PortfolioReviewService.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "industry_equivalency")
public class IndustryEquivalency {

	@Id
	@Column(name = "industry_equivalency_id")
	private int id;
	
	@Column(name = "months", nullable = false)
	private int months;
	
	@Column(name = "technology", nullable = false)
	private String technology;
	
	@ManyToOne
	@JoinColumn(name="portfolio_id", nullable=false)
	@JsonBackReference
	private Portfolio portfolio;
	
	
}

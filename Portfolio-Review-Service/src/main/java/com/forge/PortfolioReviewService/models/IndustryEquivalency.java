package com.forge.PortfolioReviewService.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "industry_equivalency")
@Generated()
public class IndustryEquivalency extends PortfolioItems{

	@ManyToOne(targetEntity = PortfolioItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name="portfolio_items_id", nullable=false)
	private int portfolioItemsId;

	@Column(name = "priority", columnDefinition = "int DEFAULT 3")
	private int priority;
	
	@Column(name = "months", nullable = false)
	private int months;
	
	@Column(name = "technology", nullable = false)
	private String technology;
	

	@Override
	public String toString() {
		return "IndustryEquivalency [id=" + portfolioItemsId + ", months=" + months + ", technology=" + technology
				+ ", portfolioItemsId=" + portfolioItemsId + "]";
	}
	
	
	
}

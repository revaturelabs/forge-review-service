package com.forge.PortfolioReviewService.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "About_Me_Table")
@Generated()
public class AboutMe extends PortfolioItems {

	@ManyToOne(targetEntity = PortfolioItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "portfolio_items_id")
	private int portfolioItemsId;
	
	@Column(name = "priority", columnDefinition = "int DEFAULT 1")
	private int priority;

	@Column(name = "description")
	private String description;

	@Override
	public String toString() {
		return "AboutMe [id=" + portfolioItemsId + ", description=" + description + ", portfolio_iems_id=" + portfolioItemsId + "]";
	}
}

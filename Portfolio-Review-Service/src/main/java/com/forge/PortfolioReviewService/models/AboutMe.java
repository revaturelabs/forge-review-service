package com.forge.PortfolioReviewService.models;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ABOUT_ME")
@AttributeOverride(name = "priority", column=@Column(columnDefinition="integer default 1"))
@Table(name = "ABOUT_ME")
@DiscriminatorValue(value="ABOUT_ME")
public class AboutMe extends PortfolioItems{

	@ManyToOne(targetEntity = PortfolioItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "portfolio_items_id", insertable=false, updatable=false)
	private int portfolioItemsId;
	
	@Column(name = "priority")
	private int priority;

	@Column(name = "description")
	private String description;

	@Override
	public String toString() {
		return "AboutMe [id=" + portfolioItemsId + ", description=" + description + ", portfolio_iems_id=" + portfolioItemsId + "]";
	}
}

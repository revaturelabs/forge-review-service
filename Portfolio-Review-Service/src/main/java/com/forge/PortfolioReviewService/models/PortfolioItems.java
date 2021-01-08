package com.forge.PortfolioReviewService.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;
import javax.persistence.InheritanceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "portfolio_items")
@EqualsAndHashCode()
@Generated()

/* Wrapper class for potfolio section bean that includes some extra metadata 
 * such as the title of the section, it's priority in the portfolio
 *  and loosely coupling the individuals beans from the portfolio instance
 * */

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PortfolioItems{
	
	@JsonIgnore
	@Transient 
	private static final String SIMPLE_NAME = PortfolioItems.class.getSimpleName();
	
	@Id
	@Column(name = "portfolio_items_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioItemId;
	
	@JsonBackReference
	@ManyToOne(targetEntity = Portfolio.class, cascade = CascadeType.ALL)
	@JoinColumn(name="portfolio_id", nullable = false,  referencedColumnName = "portfolio_id")
	private Portfolio portfolio;
	
	
	




	@Override
	public String toString() {
		return "PortfolioItems [portfolioItemId=" + portfolioItemId + ", portfolio=" + portfolio + ", priority=" + "]";
	}


	
	
}

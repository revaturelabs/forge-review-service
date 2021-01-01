package com.forge.PortfolioReviewService.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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


	@JsonBackReference(value="myUser")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private User myUser;
	

	private List<ArrayList<PortfolioSection>> portfolioSection;
	
	
	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", belongs_to=" + belongsTo + ", status=" + status + "]";
	}
}

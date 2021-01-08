package com.forge.PortfolioReviewService.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "skill_matrix")
@EqualsAndHashCode(exclude = "skillMatrixItem")
@Generated()

public class SkillMatrix extends PortfolioItems {

	@ManyToOne(targetEntity = PortfolioItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "portfolio_items_id", nullable = false)
	private int portfolioItemsId;
	
	@Column(name = "priority", columnDefinition = "int DEFAULT 4")
	private int priority;

	@Id
	@Column(name = "skill_matrix_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title")
	private String title;

	// may be the root cause of the delete by order issue
	@OneToMany(mappedBy = "skillMatrix", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "skillMatrix")
	
	@ElementCollection
	@CollectionTable(name="skill_matrix_items",  joinColumns=@JoinColumn(name="skill_matrix_id"))
	private Set<SkillMatrixItem> skillMatrixItem;

	@Override
	public String toString() {
		return "SkillMatrix [id=" + portfolioItemsId + ", title=" + title + ", portfolioItemsId=" + portfolioItemsId
				+ ", skillMatrixItem=" + skillMatrixItem + "]";
	}
}

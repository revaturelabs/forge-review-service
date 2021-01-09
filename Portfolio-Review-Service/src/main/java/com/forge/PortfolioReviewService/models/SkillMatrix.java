package com.forge.PortfolioReviewService.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="SM")
@Table(name = "skill_matrix")
@EqualsAndHashCode(exclude = "skillMatrixItem")
@DiscriminatorValue(value="SM")

public class SkillMatrix extends PortfolioItems {

	@ManyToOne(targetEntity = PortfolioItems.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "portfolio_items_id", insertable=false, updatable=false)
	private int portfolioItemsId;
	
	@Column(name = "priority")
	@ColumnDefault(value="4")
	private int priority;

	
	@Column(name = "skill_matrix_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "skill_title")
	private String skillTitle;

	// may be the root cause of the delete by order issue
//	@OneToMany(mappedBy = "skillMatrix", cascade = CascadeType.ALL)
//	@JsonManagedReference(value = "skillMatrix")
	
//	@ElementCollection
//	@CollectionTable(name="skill_matrix_items",  joinColumns=@JoinColumn(name="skill_matrix_id"))
//	private Set<SkillMatrixItems> skillMatrixItem;

//	@Override
//	public String toString() {
//		return "SkillMatrix [id=" + portfolioItemsId + ", title=" + skillTitle + ", portfolioItemsId=" + portfolioItemsId
//				+ ", skillMatrixItem=" + skillMatrixItem + "]";
//	}
}

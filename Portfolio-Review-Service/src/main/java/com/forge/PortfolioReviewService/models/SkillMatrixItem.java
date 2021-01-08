package com.forge.PortfolioReviewService.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "skill_matrix_item")
//@EqualsAndHashCode(exclude = {"skillMatrixItems"})
@Generated()
@Embeddable
public class SkillMatrixItem {

	
	@Column(name = "name")
	private String name;
	
	@Column(name = "experience")
	private String experience;


	
	@Override
	public String toString() {
		return "SkillMatrixItem [" + "name=" + name + ", experience=" + experience + "]";
	}
}

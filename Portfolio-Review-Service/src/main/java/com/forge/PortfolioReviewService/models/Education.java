package com.forge.PortfolioReviewService.models;

import java.util.Date;

import javax.persistence.Column;
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
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education")
@EqualsAndHashCode(exclude = {"portfolio"})
@Generated()
public class Education {

	@Id
	@Column(name = "education_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "graduation")
	private Date graduation;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "minor")
	private String minor;
	
	@Column(name = "degree")
	private String degree;
	
	@ManyToOne
	@JoinColumn(name="portfolio_id", nullable=false)
	@JsonBackReference(value="educationPortfolio")
	private Portfolio portfolio;
	
	@Override
	public String toString() {
		return "Education [id=" + id + ", university=" + university + ", graduation=" + graduation + ", major=" + major
				+ ", minor=" + minor + "]";
	}
}

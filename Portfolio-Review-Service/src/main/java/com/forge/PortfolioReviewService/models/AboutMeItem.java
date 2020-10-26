package com.forge.PortfolioReviewService.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "about_me_item")
@EqualsAndHashCode(exclude = {"aboutMeItems"})
@Generated()
public class AboutMeItem {

	@Id
	@Column(name = "about_me_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="about_me_id", nullable=false)
	@JsonManagedReference(value="aboutMe")
	private AboutMe aboutMe;
	
	@Override
	public String toString() {
		return "AboutMeItem [id=" + id + ", content=" + content + "]";
	}
}

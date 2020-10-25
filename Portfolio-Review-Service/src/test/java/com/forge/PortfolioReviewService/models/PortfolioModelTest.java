package com.forge.PortfolioReviewService.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PortfolioModelTest {

	private Portfolio buildPortfolio() {
		Portfolio p = new Portfolio();
		p.setId(1);
		p.setBelongsTo("Annie");
		p.setStatus("Pending");
		p.setAboutMe(null);
		p.setEducation(null);
		p.setIndustryEquivalency(null);
		p.setMyUser(null);
		p.setProjects(null);
		p.setSkillMatrix(null);
		
		return p;
	}
	
	@Test
	public void testProperties() {
		Portfolio p = buildPortfolio();
		
		Assertions.assertEquals(1,p.getId());
		Assertions.assertEquals("Annie",p.getBelongsTo());
		Assertions.assertEquals("Pending",p.getStatus());
		Assertions.assertEquals(null,p.getAboutMe());
		Assertions.assertEquals(null,p.getEducation());
		Assertions.assertEquals(null,p.getIndustryEquivalency());
		Assertions.assertEquals(null,p.getMyUser());
		Assertions.assertEquals(null,p.getProjects());
		Assertions.assertEquals(null,p.getSkillMatrix());
		
	}
	
	@Test
	public void hasCodeTest() {
		Portfolio p = buildPortfolio();
		int result = p.hashCode();

		Assertions.assertEquals(-2035465018,result);

	}
	

}

package PortfolioReviewService.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.forge.PortfolioReviewService.models.AboutMe;
import com.forge.PortfolioReviewService.models.Education;
import com.forge.PortfolioReviewService.models.IndustryEquivalency;
import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.PortfolioSection;
import com.forge.PortfolioReviewService.models.Project;
import com.forge.PortfolioReviewService.models.SkillMatrix;

class PortfolioModelTest {
	
	//Review
	@Test
	public void portfolioSectionTest() {
		List<ArrayList<PortfolioSection>> ps = new ArrayList<ArrayList<PortfolioSection>>();
		AboutMe am = new AboutMe();
		ArrayList<PortfolioSection> amList = new ArrayList<>();
		amList.add(am);//AboutMe will implement PortfolioSection
		ps.add(amList);
		Education e1 = new Education();
		Education e2 = new Education();
		ArrayList<PortfolioSection> edList = new ArrayList<>();
		edList.add(e1); //Education will implement PortfolioSection
		edList.add(e2);
		ps.add(edList);
		IndustryEquivalency ie = new IndustryEquivalency();
		ArrayList<PortfolioSection> ieList = new ArrayList<>();
		ieList.add(ie);//IndustryEquivalency will implement PortfolioSection
		ps.add(ieList);
		Project pr = new Project();
		ArrayList<PortfolioSection> prList = new ArrayList<>();
		prList.add(pr);//Project will implement PortfolioSection
		ps.add(prList);
		SkillMatrix sm = new SkillMatrix();
		ArrayList<PortfolioSection> smList = new ArrayList<>();
		smList.add(sm);//SkillMatrix will implement PortfolioSection
		ps.add(smList);
		assertNotNull(ps);
		assertEquals(5, ps.size());
		assertEquals(1, amList.size());
		assertEquals(2, edList.size());
		assertEquals(1, ieList.size());
		assertEquals(1, prList.size());
		assertEquals(1, smList.size());
	}
	
	//Review
	@Test
	public void buildLooselyCoupledPortfolio() {
		Portfolio p = new Portfolio();
		p.setId(1);
		p.setBelongsTo("Isa");
		p.setStatus("Pending");
		p.setPortfolioSection(null);
		Assertions.assertEquals(1, p.getId());
		Assertions.assertEquals("Isa", p.getBelongsTo());
		Assertions.assertEquals("Pending", p.getStatus());
		Assertions.assertEquals(null, p.getPortfolioSection());
	}

}

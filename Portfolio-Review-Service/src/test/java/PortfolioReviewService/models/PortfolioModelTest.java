package PortfolioReviewService.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.syntax.Reduction;
import org.junit.jupiter.api.Test;

import com.forge.PortfolioReviewService.models.AboutMe;
import com.forge.PortfolioReviewService.models.Education;
import com.forge.PortfolioReviewService.models.IndustryEquivalency;
import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.PortfolioItems;
import com.forge.PortfolioReviewService.models.Project;
import com.forge.PortfolioReviewService.models.SkillMatrix;

class PortfolioModelTest {
	
	 // test build PortfolioItems list of different PI.
   @Test
   void portfolioItemTest() {

       AboutMe am = new AboutMe();

       Education e1 = new Education();
       Education e2 = new Education();
       List<PortfolioItems> pIList = new ArrayList<PortfolioItems>();
       pIList.add(e1);
       pIList.add(e2);
       pIList.add(am);

       assertEquals(3, pIList.size());
   }

   //Review
   @Test
  void buildLooselyCoupledPortfolioTest() { 
       Portfolio p = new Portfolio();
       p.setId(1);
       p.setStatus("Pending");
       Education ed1 = new Education();
       ed1.setPortfolioItemId(1);
       ed1.setPriority(1);
       ed1.setItemType("Education");

       Education ed2 = new Education();
       ed2.setPortfolioItemId(1);
       ed2.setPriority(1);
       ed2.setItemType("Education");
       List<PortfolioItems> edList = new ArrayList<PortfolioItems>();
       edList.add(ed1);
       edList.add(ed2);
              // PortfolioItems educationItems = new PortfolioItems(1, 1, 1, "Education", edList);
       p.setPortfolioSections(edList);
              assertEquals(2,p.getPortfolioSections().size());
       assertEquals(p.getPortfolioSections().get(0), ed1);
   }

}
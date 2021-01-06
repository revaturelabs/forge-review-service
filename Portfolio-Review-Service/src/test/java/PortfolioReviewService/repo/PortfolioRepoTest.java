package PortfolioReviewService.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.models.PortfolioItems;
import com.forge.PortfolioReviewService.models.Project;
import com.forge.PortfolioReviewService.repository.PortfolioRepo;

//@SpringBootTest
//@DataJpaTest
//@RunWith(SpringRunner.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
class PortfolioRepoTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	//@MockBean
	private PortfolioRepo portfolioRepo;
	
	
	@Test
    public void testSaveNewPotfolio() {
		
		//PortfolioRepo portfolioRepoFromContext = context.getBean(Portfolio.class);
		
		Project p1 = new Project();
		Project p2 = new Project();
		List<Project> projList = new ArrayList<Project>();
		projList.add(p1);
		projList.add(p2);
        PortfolioItems pI = new PortfolioItems(); 
        pI.setItems(projList);
        List<PortfolioItems> potList = new ArrayList<PortfolioItems>();
        potList.add(pI);
        Portfolio port1 = new Portfolio(2, "pending", 1, potList);
        System.out.println(port1);
        
        portfolioRepo.saveAndFlush(port1);
        //entityManager.flush();
        
        Portfolio port = portfolioRepo.findById(2);
      
        //Portfolio result = portfolioRepo.findById(1);
        //portfolioRepo.save(new Portfolio(2, "pending", 1, potList));
        
        //when(portfolioRepo.findById(2)).thenReturn(port1);

       assertEquals(port1, port);
    }

}

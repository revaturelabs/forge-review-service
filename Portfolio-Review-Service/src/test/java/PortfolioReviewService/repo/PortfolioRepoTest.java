package PortfolioReviewService.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.forge.PortfolioReviewService.models.Portfolio;
import com.forge.PortfolioReviewService.repository.PortfolioRepo;

@DataJpaTest
class PortfolioRepoTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private PortfolioRepo portfolioRepo;
	
	
	@Test
    public void testSaveNewProduct() {
        entityManager.persist(new Portfolio(0, "Name1", "Pending", null, null, null, null, null, null));
                 
        Portfolio result = portfolioRepo.findById(1);
         
        Assertions.assertEquals("Name1", result.getBelongsTo());
    }

}

package PortfolioReviewService.repo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.forge.PortfolioReviewService.models.Criteria;
import com.forge.PortfolioReviewService.repository.CriteriaRepo;

@SpringBootTest(classes=Criteria.class)
public class CriteriaRepoTest {
	
	@MockBean
	private CriteriaRepo cRepo;
	
	@Test
	public void findAllTest() {
		when(cRepo.findAll()).thenReturn(Stream.of(new Criteria(1, "about_me","200"),
				new Criteria(2, "education","2"),new Criteria(3, "project","3")).collect(Collectors.toList()));
		assertEquals(3, cRepo.findAll().size());
	}
	
	@Test
	public void saveTest() {
		Criteria criteria= new Criteria(1, "about_me","200");
		when(cRepo.save(criteria)).thenReturn(new Criteria(1, "about_me","200"));		
		assertEquals(criteria, cRepo.save(criteria));	
	}
	
	@Test
	public void findByIdTest() {
		int id=1;
		Criteria criteria= new Criteria(1, "about_me","200");
		when(cRepo.findById(id)).thenReturn(criteria);		
		assertEquals(criteria, cRepo.findById(id));
	}
	
	
	
	

}

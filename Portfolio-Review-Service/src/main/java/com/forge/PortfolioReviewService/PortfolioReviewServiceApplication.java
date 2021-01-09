package com.forge.PortfolioReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.forge.PortfolioReviewService.models.AboutMe;
import com.forge.PortfolioReviewService.models.PortfolioItems;
import com.forge.PortfolioReviewService.repository.AboutMeRepo;
import com.forge.PortfolioReviewService.repository.PortfolioItemsRepo;

@EnableEurekaClient
@SpringBootApplication
public class PortfolioReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioReviewServiceApplication.class, args);
	}

}

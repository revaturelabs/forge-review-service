package com.forge.PortfolioReviewService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
	
	private String userFirstName;
	
	private String userEmail;
	
	private String portfolioStatus;
	
	private String feedBack;
	
	private int portfolioId;
	
	private String adminUserName;
}

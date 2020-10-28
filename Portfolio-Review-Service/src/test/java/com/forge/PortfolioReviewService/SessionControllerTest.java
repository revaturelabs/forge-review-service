package com.forge.PortfolioReviewService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.forge.PortfolioReviewService.controller.SessionController;
import com.forge.PortfolioReviewService.models.Message;
import com.forge.PortfolioReviewService.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class SessionControllerTest {

	@Autowired
	SessionController sessionController;

	@Test
	public void loginTest() {
		User u = new User();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		
		User result = sessionController.login(request, u);
		
		Assertions.assertEquals(result, u);
		verify(request, times(1)).getSession();
		verify(session, times(1)).setAttribute("loggedInUser", u);
	}
	
	@Test
	public void logoutTest() {
		
		HttpSession session = mock(HttpSession.class);
		
		Message result = sessionController.logout(session);
		
		Assertions.assertEquals(result.getMessage(), "You've successfully logged out");
		verify(session, times(1)).invalidate();
	}
	
	@Test
	public void getCurUserTest() {
		HttpSession session = mock(HttpSession.class);
		User u = new User();
		
		when(session.getAttribute("loggedInUser")).thenReturn(u);
		User result = sessionController.getCurUser(session);
		
		Assertions.assertEquals(result, u);
	}
	
}

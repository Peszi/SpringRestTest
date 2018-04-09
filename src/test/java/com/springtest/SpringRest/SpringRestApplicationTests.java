package com.springtest.SpringRest;

import com.springtest.SpringRest.model.Credentials;
import com.springtest.SpringRest.service.UserAuthorizationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRestApplication.class)
public class SpringRestApplicationTests {

	private final Credentials userCredentials = new Credentials("John", "1234");
	private final Credentials userCredentials2 = new Credentials("Bob", "1234");

	@Autowired
	private UserAuthorizationService userAuthorizationService;

	@Test
	public void registerUser() {
		assertTrue(this.userAuthorizationService.registerUser(userCredentials));
	}

	@Test
	public void registerUserAgainFail() {
		assertFalse(this.userAuthorizationService.registerUser(userCredentials));
	}

	@Test
	public void registerAnotherUser() {
		assertTrue(this.userAuthorizationService.registerUser(userCredentials2));
	}

	@Test
	public void checkUserAuth() {
		assertTrue(userAuthorizationService.authorizeUser(userCredentials).isPresent());
	}

}

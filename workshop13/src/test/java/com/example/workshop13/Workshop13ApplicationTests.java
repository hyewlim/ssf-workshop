package com.example.workshop13;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.workshop13.controller.AddressBookController;
import com.example.workshop13.model.Contact;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class Workshop13ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private AddressBookController addressbkController;

	@Autowired
	

	@Test
	public void testContact() throws Exception {
		Contact c = new Contact();
		c.setEmail("erwin@gmail.com");
		c.setName("Erwin");
		c.setPhoneNumber(334343434);
		
	}

}

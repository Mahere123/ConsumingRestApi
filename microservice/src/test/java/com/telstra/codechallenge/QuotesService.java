package com.telstra.codechallenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.telstra.codechallenge.model.Quote;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuotesService {
	
	@LocalServerPort
	private int port;
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getQuotes() {
		assertThat(this.restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/app", Quote[].class));
	}
	
	@Test
	public void getRandomQuote() {
		assertThat(this.restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/app/random", Quote.class));
	}

}

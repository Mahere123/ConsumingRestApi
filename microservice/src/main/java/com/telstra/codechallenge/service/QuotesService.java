package com.telstra.codechallenge.service;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.telstra.codechallenge.model.Quote;

@Service
public class QuotesService {
	
	  @Value("${quotes.base.url}")
	  private String quotesBaseUrl;
      
	  @Autowired
	  private RestTemplate restTemplate;
	  
	  /**
	   * Returns an array of spring boot String. Taken from https://spring.io/guides/gs/consuming-rest/.
	   *
	   * @return - Quote array
	   */
	  public List<Quote> getQuotes() {
		  Quote[] quote= restTemplate.getForObject(quotesBaseUrl+"/api", Quote[].class); 
		  return Arrays.asList(quote);
	  }
	 

	  /**
	   * Returns a random spring boot quote. Taken from https://spring.io/guides/gs/consuming-rest/.
	   *
	   * @return - a quote array
	   */
	  public Quote getRandomQuote() {
	   return restTemplate.getForObject(quotesBaseUrl+"/api/random", Quote.class);
		
	  }
	  
	  /**
	   * when you are calling a get	Quotes it takes more time to spend response.
	   * 
	   * @return the custom response to your application.
	   */
	  
	  @HystrixCommand(fallbackMethod = "fallback_getQuotes")
	  public String getHysrix() {
		
		return restTemplate.getForObject("http://localhost:8082/hystrix", String.class);
	  }
	  /**
	   *  the control goes to the fallback method.
	   */
	@SuppressWarnings("unused")
	private String fallback_getQuotes() {
		   return "Request fails. It takes long time to response";
	  }


	

}

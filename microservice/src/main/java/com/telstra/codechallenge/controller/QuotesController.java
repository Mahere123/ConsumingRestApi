package com.telstra.codechallenge.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.model.Quote;
import com.telstra.codechallenge.service.QuotesService;

@RestController
public class QuotesController {
	
	private final Logger log=LoggerFactory.getLogger( QuotesController.class);
	
	 @Autowired
	 private QuotesService quotesService;
	 
	 @RequestMapping(path = "/quotes", method = RequestMethod.GET)
	  public List<Quote> quotes() {
		 log.info(quotesService.getQuotes().toString());
	    return quotesService.getQuotes();
	  }

	  @RequestMapping(path = "/quotes/random", method = RequestMethod.GET)
	  public Quote quote() {
		  log.info(quotesService.getRandomQuote().toString());
	    return quotesService.getRandomQuote();
	  }
	  
	  @RequestMapping(path = "/quotes/random/app", method = RequestMethod.GET)
	  public String getHystrix() {
		  return quotesService.getHysrix();
	  }
}

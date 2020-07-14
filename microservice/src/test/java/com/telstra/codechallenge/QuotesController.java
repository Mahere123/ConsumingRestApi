/**
 * 
 */
package com.telstra.codechallenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mahendra
 *
 */
@SpringBootTest
public class QuotesController {
	
	@Autowired
	private QuotesController quotesController;
	
	@Test
	public void contextLoad() {
		assertThat(quotesController).isNull();
	}
}

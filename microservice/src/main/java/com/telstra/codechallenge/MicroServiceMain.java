package com.telstra.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableCircuitBreaker
@SpringBootApplication
public class MicroServiceMain{
	
   @Bean
   public RestTemplate restTemplate() {
	    return new RestTemplate();
  }
  public static void main(String[] args) {
    SpringApplication.run(MicroServiceMain.class, args);
  }
}

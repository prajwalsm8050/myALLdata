package com.example.demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@PropertySource("classpath:application.yml")
@RestController
@EnableHystrix
@RequestMapping
public class DemoServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate template;

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoServiceApplication.class, args);
	}
	
	
	@GetMapping("/bookNow")
	@HystrixCommand(fallbackMethod = "BookShowFallBack")
	public String bookShow()
	{
		String email_URL = "http://localhost:8989/emailService/send";
		String payment_URL = "http://localhost:8787/paytmService/payout";
		String emailServiceResponse = template.getForObject(email_URL, String.class);
		String paymentServiceResponse = template.getForObject(payment_URL, String.class);
		return emailServiceResponse + " : : " + paymentServiceResponse;
	}
	
	@GetMapping("/bookNowWithoutHystrix")
	public String bookShowWithoutHystrix() {
		String email_URL = "http://localhost:8989/emailService/send";
		String payment_URL = "http://localhost:8787/paytmService/payout";
		String emailServiceResponse = template.getForObject(email_URL, String.class);
		String paymentServiceResponse = template.getForObject(payment_URL, String.class);
		return emailServiceResponse + " : : " + paymentServiceResponse;
	}
	
	public String BookMyShowFallBack() {
		return "Something went wrong we are unable to process the request";
	}
	
}

package com.customer.demo;

import com.customer.demo.customerRepo.UserRepo;
import com.customer.demo.model.User;
import com.customer.demo.model.UserBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication  {
//implements CommandLineRunner
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	UserRepo userRepo;


//	@Override
//	public void run(String... args) throws Exception {
//		User user = new User();
//
//		user.setFirstname("Prajwal");
//		user.setLastname("shivapurmath");
//		user.setAdhar(123456789122L);
//		user.setEmail("prajwalsm0@gmail.com");
//		user.setDob(LocalDate.of(1999, 06, 11));
//
//		UserBank userbank = new UserBank();
//
//		userbank.setAccountnumber(123456985612L);
//		userbank.setAccounttype("Savings");
//		userbank.setBankbranch("Bangalore");
//		userbank.setUser(user);
//
//		user.setUserBank(userbank);
//
//		userRepo.save(user);
//
//	}
}

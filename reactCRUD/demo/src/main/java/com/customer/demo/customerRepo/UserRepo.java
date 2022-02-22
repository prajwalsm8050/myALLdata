package com.customer.demo.customerRepo;

import com.customer.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {

}

package com.customer.demo.customerRepo;

import com.customer.demo.model.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserbankRepo extends JpaRepository<UserBank , Long> {

}

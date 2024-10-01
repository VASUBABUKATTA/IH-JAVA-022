package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.CustomerSignupDetails;

@Repository
public interface CustomerSignupDetailsRepository extends JpaRepository<CustomerSignupDetails, Long> {

	List<CustomerSignupDetails> findByCustomerId(String customerId);

	List<CustomerSignupDetails> findByMobileno(String mobileno);

	List<CustomerSignupDetails> findByEmail(String email);

	Optional<CustomerSignupDetails> findByMobilenoOrEmail(String mobileNo, String email);

}

package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.CustomerPaymentDetails;

@Repository
public interface CustomerPaymentDetailsRepository extends JpaRepository<CustomerPaymentDetails, Long> {

	List<CustomerPaymentDetails> findByCustomerId(String customerId);

	Optional<CustomerPaymentDetails> findByCustomerIdAndPaymentId(String id, String id1);

}

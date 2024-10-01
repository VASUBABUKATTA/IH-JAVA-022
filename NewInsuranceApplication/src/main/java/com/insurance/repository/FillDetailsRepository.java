package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.FillDetailsPage;

@Repository
public interface FillDetailsRepository  extends JpaRepository<FillDetailsPage, Long>{

	List<FillDetailsPage> findByCustomerId(String customerId);

	Optional<FillDetailsPage> findByCustomerIdAndPaymentId(String id, String id1);

	Optional<FillDetailsPage> findByPancard(String panCard);

}

package com.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.StructureAndDetails;

@Repository
public interface StructureDetailsRepository extends JpaRepository<StructureAndDetails, Long>
{

	List<StructureAndDetails> findByCustomerId(String customerId);

	Optional<StructureAndDetails> findByCustomerIdAndPaymentId(String id1, String id);

}

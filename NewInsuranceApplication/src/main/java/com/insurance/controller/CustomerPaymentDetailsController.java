package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.CustomerPaymentDetails;
import com.insurance.service.CustomerPaymentDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@Tag(
		name="CRUD REST APIs for CustomerPaymentDetails",
		description = " CRUD rest api in CustomerPaymentDetails to CREATE, UPDATE, FETCH AND DELETE insurance details"
	)
public class CustomerPaymentDetailsController 
{
	@Autowired
	CustomerPaymentDetailsService propertyInsuranceService;
	
	@Operation(
			summary = " Getting All Payment details that are made ",
			description = " REST api to fetch all the payment Details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	@GetMapping("/getPaymentData")
	public ResponseEntity<List<CustomerPaymentDetails>> getPaymentData()
	{
		return propertyInsuranceService.getPaymentData();
	}
	@Operation(
			summary = " Getting All Payment details that are made by a customer by a customerId ",
			description = " REST api to fetch all the payment Details "
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	@GetMapping("/getPaymentDetailsByCustomerId/{customerId}")
	public ResponseEntity<List<CustomerPaymentDetails>> getPaymentDetailsByCustomerId(@PathVariable String customerId)
	{
		return propertyInsuranceService.getPaymentDetailsByCustomerId(customerId);
	}
	@Operation(
		summary = " Creating  A Payment details related to a payment ",
		description = " REST api to Create a payment"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = " Http status Created"
		)
	})  
	@PostMapping("/putPaymentData")
	public ResponseEntity<String> createPaymentData(@Valid @RequestBody CustomerPaymentDetails data )
	{
		return propertyInsuranceService.createPaymentData(data);
	}
	
	@Operation(
			summary = " Deleting a paaymentdetails by Id ",
			description = " REST api to delete a payment details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
		@DeleteMapping("/deletePaymentDetails/{id}")
		public ResponseEntity<String> deletePaymentDetailsById(@PathVariable long id) {
		    return propertyInsuranceService.deletePaymentDetailsById(id);
		}
	
	@Operation(
			summary = " updating a payment details by Id ",
			description = " REST api to Update a payment details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
		@PutMapping("/updatePaymentDetails/{id}")
		public ResponseEntity<String> updatePaymentDetailsById(@PathVariable long id,@Valid @RequestBody CustomerPaymentDetails paymentDetails) {
		    return propertyInsuranceService.updatePaymentDetailsById(id, paymentDetails);
		    
		}

}

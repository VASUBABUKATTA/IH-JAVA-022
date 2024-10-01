package com.insurance.controller;

import java.lang.module.ResolutionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.insurance.model.CustomerSignupDetails;
import com.insurance.service.CustomerSignupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@Tag(
		name="CRUD REST APIs for CustomerSignupDetails",
		description = " CRUD rest api in CustomerSignupDetails to CREATE, UPDATE, FETCH AND DELETE insurance details"
	)
public class CustomerSignupDetailsController 
{
	
	@Autowired
	private CustomerSignupService propertyInsuranceService;
	
	@Operation(
			summary = " Getting All customers ",
			description = " REST api to fetch all the customers that are signed up"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	
	@GetMapping("/getCustomer")
	public ResponseEntity<List<CustomerSignupDetails>> getAllCustomers()
	{
		return propertyInsuranceService.getAllCustomers();
	}
	@Operation(
			summary = " Getting a customers based on customerId ",
			description = " REST api to fetch a customers"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	 @GetMapping("/getCustomerById/{customerId}")
	  public ResponseEntity<List<CustomerSignupDetails>> getCustomerById(@PathVariable String customerId)
	 {
	        return propertyInsuranceService.getCustomerById(customerId);
	 }
	 @Operation(
			summary = " Getting A customer based on mobileNumber ",
			description = " REST api to fetch a customer"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
		// List<CustomerSignup> 
	 @GetMapping("/getCustomerByMobileNumber/{mobileno}")
	  public ResponseEntity<List<CustomerSignupDetails>> getCustomerIdByMobileNo( @Pattern(regexp = "(^[6-9][0-9]{9}$)", message = "mobileNumber must be start with 6 to 9 and have 10 digits")@PathVariable String mobileno) 
	 {
	    
			return propertyInsuranceService.getCustomerIdByMobileNo(mobileno);
	  }
	  @Operation(
		summary = " Creating  A customer ",
		description = " REST api to Create a customer"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = " Http status Created"
		)
	})  
	@PostMapping("/putCustomer")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerSignupDetails customer)
	{
		return propertyInsuranceService.createCustomer(customer);
	}
	  
	  @Operation(
				summary = " checking a mobileNumber if it exists in the dtabase or not",
				description = " REST api to check a mobileNumber"
			)
			@ApiResponses({
				@ApiResponse(
					responseCode = "200",
					description = " Http status ok"
				)
			})
			@GetMapping("/checkMobileNumber/{mobileNumber}")
			public ResponseEntity<String> checkMobileNumber(@Pattern(regexp = "(^[6-9][0-9]{9}$)", message = "mobileNumber must be start with 6 to 9 and have 10 digits")@PathVariable String mobileNumber) {
				return propertyInsuranceService.checkMobileNumber(mobileNumber);
			}
			@Operation(
				summary = " checking a Email if it exists in the dtabase or not",
				description = " REST api to check a Email"
			)
			@ApiResponses({
				@ApiResponse(
					responseCode = "200",
					description = " Http status ok"
				)
			})
			@GetMapping("/checkEmail/{email}")
			public ResponseEntity<String> checkEmail(@PathVariable String email) {
				return propertyInsuranceService.checkEmail(email);
			}
			@Operation(
					summary = " Deleting a customer by Id ",
					description = " REST api to delete a customer"
				)
				@ApiResponses({
					@ApiResponse(
						responseCode = "200",
						description = " Http status ok"
					)
				})
			@DeleteMapping("/deleteCustomer/{id}")
				public ResponseEntity<String> deleteById(@PathVariable long id) {
				    String result = propertyInsuranceService.deleteById(id);
				    if (result.equals("Deleted")) {
				        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer deleted successfully");
				    } else {
				        throw new ResolutionException("Id was not exist");
				    }
				}
			
			@Operation(
					summary = " updating a customer details by Id ",
					description = " REST api to Update a customer details"
				)
				@ApiResponses({
					@ApiResponse(
						responseCode = "200",
						description = " Http status ok"
					)
				})
				@PutMapping("/updateCustomer/{id}")
				public ResponseEntity<String> updateCustomerById(@PathVariable long id,@Valid @RequestBody CustomerSignupDetails customer) {
				    return propertyInsuranceService.updateCustomerById(id, customer);
				   
				}
			
//			@Operation(
//					summary = " updating a customer details by mobileNumber ",
//					description = " REST api to Update a customer details"
//				)
//				@ApiResponses({
//					@ApiResponse(
//						responseCode = "200",
//						description = " Http status ok"
//					)
//				})
//				@PutMapping("/updateCustomerByMobileNo/{id}/{mobileno}")
//				public ResponseEntity<String> updateCustomerByMobileNo(@Valid @PathVariable Long id, @PathVariable String mobileno) {
//				    return propertyInsuranceService. updateCustomerByMobileNo(id, mobileno);
//				   
//				}
//				@Operation(
//					summary = " updating a customer details by email ",
//					description = " REST api to Update a customer details"
//				)
//				@ApiResponses({
//					@ApiResponse(
//						responseCode = "200",
//						description = " Http status ok"
//					)
//				})
//				@PutMapping("/updateCustomerByEmailId/{id}/{emailId}")
//				public ResponseEntity<String> updateCustomerByEmailId(@Valid @PathVariable long id, @PathVariable String emailId ) {
//				    return propertyInsuranceService.updateCustomerByEmailId(id, emailId);
//				   
//				}

}

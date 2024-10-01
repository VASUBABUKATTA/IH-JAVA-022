package com.insurance.controller;

import java.util.List;
import java.util.Optional;

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

import com.insurance.model.FillDetailsPage;
import com.insurance.service.FillDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@Tag(
		name="CRUD REST APIs for PersonalDetails",
		description = " CRUD rest api in PersonalDetails to CREATE, UPDATE, FETCH AND DELETE insurance details"
	)
public class FillDetailsController 
{
	
	@Autowired
	private FillDetailsService propertyInsuranceService;
	
	@Operation(
			summary = " Getting All user details related to property ",
			description = " REST api to fetch all the fill Details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	@GetMapping("/getData")
	public ResponseEntity<List<FillDetailsPage>> getAllData()
	{
		return propertyInsuranceService.getAllData();
	}
	@Operation(
			summary = " Getting A single user details related to property by Id ",
			description = " REST api to fetch a fill Details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	@GetMapping("/getFillDetailsDataById/{id}")
	public ResponseEntity<Optional<FillDetailsPage>> getFillDetailsById(@PathVariable long id)
	{
		return propertyInsuranceService.getFillDetailsById(id);
	}
	@Operation(
		summary = " Getting A single user details related to property by CustomerId ",
		description = " REST api to fetch a fill Details"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = " Http status ok"
		)
	})
	@GetMapping("/getfillDetailsByCustomerId/{customerId}")
	public ResponseEntity<List<FillDetailsPage>> getFillDetailsByCustomerId(@PathVariable String customerId)
	{
		return propertyInsuranceService.getFillDetailsByCustomerId(customerId);
	}
	@Operation(
		summary = " Creating  A user details related to property ",
		description = " REST api to Create a fill details"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = " Http status Created"
		)
	})  
	@PostMapping("/putData")
	public ResponseEntity<String> createData(@Valid @RequestBody FillDetailsPage data )
	{
		return propertyInsuranceService.createData(data);
	}
	
	@Operation(
			summary = " Deleting a fill Details related to property by Id ",
			description = " REST api to delete a fill details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
	@DeleteMapping("/deleteFillDetails/{id}")
		public ResponseEntity<String> deleteFillDetailsById(@PathVariable long id) {
		    String result = propertyInsuranceService.deleteFillDetailsById(id);
		    if (result.equals("Deleted")) {
		        return ResponseEntity.noContent().build();
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id was not existed");
		    }
		}
	
	@Operation(
			summary = " updating a fil details related to property by Id ",
			description = " REST api to Update a  structure details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
		@PutMapping("/updateFillDetails/{id}")
		public ResponseEntity<String> updateFillDetailsById(@PathVariable long id, @Valid @RequestBody FillDetailsPage fillDetails) {

			return propertyInsuranceService.updateFillDetailsById(id, fillDetails);
			
		}

}

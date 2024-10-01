package com.insurance.controller;

import java.util.List;
import java.util.Optional;

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

import com.insurance.model.StructureAndDetails;
import com.insurance.service.StructureAndDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@Tag(
		name="CRUD REST APIs for StructureAndDetails",
		description = " CRUD rest api in propertyinsurance to CREATE, UPDATE, FETCH AND DELETE insurance details"
	)
public class StructureAndDetailsController {

	@Autowired
	StructureAndDetailsService propertyInsuranceService;
	
	@Operation(
		summary = " Getting All structure details",
		description = " get api to fetch all the insurances that sold"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = " http status ok"
		)
	})
	@GetMapping("/getStructure")
	public ResponseEntity<List<StructureAndDetails>> getAllDetails()
	{
		return propertyInsuranceService.getAllDetails();
	}

	@Operation(
		summary = " Getting a single Customer All structure details based on customerId ",
		description = " get api to fetch all the insurances that sold to a customer"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = "http status ok"
		)
	})
	@GetMapping("/getStructureByCustomerId/{customerId}")
    public ResponseEntity<List<StructureAndDetails>> getStructureDetailsByCustomerId(@PathVariable String customerId) {
        return propertyInsuranceService.getStructureDetailsByCustomerId(customerId);
    }
	@Operation(
		summary = " Getting a single structure details based on Id",
		description = " get api to fetch a single insurances that sold"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "200",
			description = " http status ok"
		)
	})
	@GetMapping("/getStructureDetailsById/{id}")
    public ResponseEntity<Optional<StructureAndDetails>> getStructureDetailsById(@PathVariable long id) {
        return propertyInsuranceService.getStructureDetailsById(id);
    }
	@Operation(
		summary = " putting a single structure details",
		description = " REST api to CREATE a single insurances that sold"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = " Http status Created"
		)
	})
	@PostMapping("/putStructure")
	public ResponseEntity<String> createDetails(@Valid @RequestBody StructureAndDetails details )
	{
		return propertyInsuranceService.createDetails(details);
	}
	
	
	@Operation(
		summary = " Deleting a single structure details based on Id",
		description = " REST api to delete a single insurances that sold"
	)
	@ApiResponses({
		@ApiResponse(
			responseCode = "201",
			description = " Http status Created"
		)
	})
	// delete the details of the structure details :
	 @DeleteMapping("/deleteStructureDetails/{id}")
	    public ResponseEntity<String> deleteStructureDetailsById(@PathVariable long id) {
	        return propertyInsuranceService.deleteStructureDetailsById(id);
	        // if (result.equals("Deleted")) {
	        //     return ResponseEntity.ok().body("Structure details deleted successfully");
	        // } else {
	        //     return ResponseEntity.notFound().build();
	        // }
	    }
	
	
	@Operation(
			summary = " updating a structure details by Id ",
			description = " REST api to Update a  structure details"
		)
		@ApiResponses({
			@ApiResponse(
				responseCode = "200",
				description = " Http status ok"
			)
		})
		@PutMapping("/updateStructureDetails/{id}")
		public ResponseEntity<String> updateStructureDetailsById(@PathVariable long id, @Valid @RequestBody StructureAndDetails details) {
		    return propertyInsuranceService.updateStructureDetailsById(id, details);
		   
		}
	
}

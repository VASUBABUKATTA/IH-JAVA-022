package com.insurance.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.insurance.Exception.DuplicateEntryException;
import com.insurance.Exception.ResourceNotFoundException;
import com.insurance.model.CustomerPaymentDetails;
import com.insurance.repository.CustomerPaymentDetailsRepository;

@Service
public class CustomerPaymentDetailsService 
{
	
	@Autowired
	CustomerPaymentDetailsRepository customerPaymentDetailsRepository;
	
	public ResponseEntity<List<CustomerPaymentDetails>> getPaymentData()
	{
		List<CustomerPaymentDetails> data = customerPaymentDetailsRepository.findAll();
		
		if(data.isEmpty())
		{
			throw new ResourceNotFoundException("Data was Not found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(data);
		 
	}
	

	
	public ResponseEntity<List<CustomerPaymentDetails>> getPaymentDetailsByCustomerId(@PathVariable String customerId)
	{
		List<CustomerPaymentDetails> data = customerPaymentDetailsRepository.findByCustomerId(customerId);
		
		if(data.isEmpty())
		{
			throw new ResourceNotFoundException("Data was Not found with the provided customerId :"+customerId);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	public ResponseEntity<String> createPaymentData(CustomerPaymentDetails data )
	{
        data.setStartingDate(LocalDate.now());
        data.setExpiryDate(data.getStartingDate().minusDays((1)).plusYears(data.getYear()));
        
       String id = data.getCustomerId();
       String id1= data.getPaymentId();
       
       Optional<CustomerPaymentDetails> details = customerPaymentDetailsRepository.findByCustomerIdAndPaymentId(id,id1);
       
       if(details.isEmpty())
       {
        
		 customerPaymentDetailsRepository.save(data);
		 
		 return ResponseEntity.status(HttpStatus.CREATED).body("Data was successfully inserted");
       }
       else
       {
    	   throw new DuplicateEntryException("Provided Details are already existed");
       }
    }
	
	public ResponseEntity<String> deletePaymentDetailsById(long id) {
        if (customerPaymentDetailsRepository.existsById(id)) {
            customerPaymentDetailsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Data was deleted Successfully");
        } else {
        	throw new ResourceNotFoundException("Provided id with the Data was not found : "+ id);
        }
    }
	
	public ResponseEntity<String> updatePaymentDetailsById(long id, CustomerPaymentDetails paymentDetails) {
        Optional<CustomerPaymentDetails> existingPaymentDetailsOptional = customerPaymentDetailsRepository.findById(id);
        if (existingPaymentDetailsOptional.isPresent()) {
            CustomerPaymentDetails existingPaymentDetails = existingPaymentDetailsOptional.get();
           
            existingPaymentDetails.setYear(paymentDetails.getYear());
            existingPaymentDetails.setPremium(paymentDetails.getPremium());
            
             customerPaymentDetailsRepository.save(existingPaymentDetails);
             return ResponseEntity.status(HttpStatus.OK).body("Data was Updated Successfully");
        } else {
        	throw new ResourceNotFoundException("Provided id with the Data was not found : "+ id);
        }
    }
}

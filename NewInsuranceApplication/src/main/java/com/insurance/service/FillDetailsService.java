package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insurance.Exception.DuplicateEntryException;
import com.insurance.Exception.ResourceNotFoundException;
import com.insurance.model.FillDetailsPage;
import com.insurance.repository.FillDetailsRepository;

@Service
public class FillDetailsService 
{
	
	@Autowired
	FillDetailsRepository fillDetailsRepository;
	
	public ResponseEntity<List<FillDetailsPage>> getAllData()
	{
		List<FillDetailsPage> data = fillDetailsRepository.findAll();
		
		if(data.isEmpty())
		{
			throw new ResourceNotFoundException("Data was empty");
		}
		else {
			 return ResponseEntity.status(HttpStatus.OK).body(data);
		}
	}
	
	public ResponseEntity<Optional<FillDetailsPage>> getFillDetailsById(long id)
	{
		Optional<FillDetailsPage> data = fillDetailsRepository.findById(id);
		
		if(data.isEmpty())
		{
			throw new ResourceNotFoundException("Data was empty");
		}
		else {
			 return ResponseEntity.status(HttpStatus.OK).body(data);
		}
	}
	
	public ResponseEntity<List<FillDetailsPage>> getFillDetailsByCustomerId(String customerId)
	{
		
		
		List<FillDetailsPage> data = fillDetailsRepository.findByCustomerId(customerId);
		
		if(data.isEmpty())
		{
			throw new ResourceNotFoundException("Data was empty");
		}
		else {
			 return ResponseEntity.status(HttpStatus.OK).body(data);
		}
		
	}
	public ResponseEntity<String> createData(FillDetailsPage data )
	{
		String  id = data.getCustomerId();
		String id1 = data.getPaymentId();
		String panCard = data.getPancard();
		Optional<FillDetailsPage> data2 = fillDetailsRepository.findByCustomerIdAndPaymentId(id,id1);
		Optional<FillDetailsPage> data1 = fillDetailsRepository.findByPancard(panCard);
		
		if(data2.isEmpty()&& data1.isEmpty())
		{
			fillDetailsRepository.save(data);
		return	ResponseEntity.status(HttpStatus.CREATED).body("FillDetails Successfully created");
		}
		else
		{
			throw new DuplicateEntryException("Data was already Existed ");
		}
		
	}
	
	
	public String deleteFillDetailsById(long id) {
        if (fillDetailsRepository.existsById(id)) {
            fillDetailsRepository.deleteById(id);
            return "Deleted";
        } else {
            return "Not Found";
        }
    }
	
//	public String updateFillDetailsById(long id, FillDetailsPage fillDetails) {
//        Optional<FillDetailsPage> existingFillDetailsOptional = fillDetailsRepository.findById(id);
//        
//        if (existingFillDetailsOptional.isPresent()) {
//        	FillDetailsPage existingFillDetails = existingFillDetailsOptional.get();
//        	
//        	String newpanCard = fillDetails.getPancard();
//        	Optional<FillDetailsPage> data1 = fillDetailsRepository.findByPancard(newpanCard);
//        	
//        	
//        	
//        	if()
//        	
//             existingFillDetails.setCurrentaddress(fillDetails.getCurrentaddress());
//             existingFillDetails.setDob(fillDetails.getDob());
//             existingFillDetails.setFullname(fillDetails.getFullname());
//             existingFillDetails.setPancard(fillDetails.getPancard());
//             existingFillDetails.setGender(fillDetails.getGender());
//             existingFillDetails.setPincode(fillDetails.getPincode());
//             existingFillDetails.setHouseno(fillDetails.getHouseno());
//             existingFillDetails.setStreetno(fillDetails.getStreetno());
//             existingFillDetails.setPropertypincode(fillDetails.getPropertypincode());
//             existingFillDetails.setPropertyhouseNo(fillDetails.getPropertyhouseNo());
//             existingFillDetails.setPropertystreetNo(fillDetails.getPropertystreetNo());
//             
//             fillDetailsRepository.save(existingFillDetails);
//            return "updated successfully";
//        } else {
//            return "records not updated";
//        }
//    }
	
	public ResponseEntity<String> updateFillDetailsById(long id, FillDetailsPage fillDetails) {
	    Optional<FillDetailsPage> existingFillDetailsOptional = fillDetailsRepository.findById(id);
	    
	    if (existingFillDetailsOptional.isPresent()) {
	        FillDetailsPage existingFillDetails = existingFillDetailsOptional.get();
	        
	        String newPanCard = fillDetails.getPancard();
	        
	        // Check if the PAN card is changed
	        if (!newPanCard.equals(existingFillDetails.getPancard())) {
	            // Verify if the new PAN card is already in use
	            Optional<FillDetailsPage> data1 = fillDetailsRepository.findByPancard(newPanCard);
	            
	            if (data1.isPresent()) {
	                throw new DuplicateEntryException("The PAN card already exists. Update failed.");
	            }
	        }
	        
	        // Update the details
	        existingFillDetails.setCurrentaddress(fillDetails.getCurrentaddress());
	        existingFillDetails.setDob(fillDetails.getDob());
	        existingFillDetails.setFullname(fillDetails.getFullname());
	        existingFillDetails.setPancard(newPanCard);
	        existingFillDetails.setGender(fillDetails.getGender());
	        existingFillDetails.setPincode(fillDetails.getPincode());
	        existingFillDetails.setHouseno(fillDetails.getHouseno());
	        existingFillDetails.setStreetno(fillDetails.getStreetno());
	        existingFillDetails.setPropertypincode(fillDetails.getPropertypincode());
	        existingFillDetails.setPropertyhouseNo(fillDetails.getPropertyhouseNo());
	        existingFillDetails.setPropertystreetNo(fillDetails.getPropertystreetNo());
	        
	        fillDetailsRepository.save(existingFillDetails);
	        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
	    } else {
	    	 throw new ResourceNotFoundException("Record not found with the provided id");
	    }
	}


}

package com.insurance.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
@Schema(
	name=" customer Payment ",
	description = " Schema to hold customer Payment Information"
)
public class CustomerPaymentDetails 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
    @Column
    @NotNull( message = "premium can not be null or empty")
    @Schema(
    		description = "premium amount based on the Year", example = "60"
    	)
    @Min(value = 50, message = "minimum must be 50")
    @Max(value = 100000000, message = "maximum must be 100000000")
	private long premium;
    @Column
    @NotNull( message = "Year can not be null or empty")
    @Schema(
    		description = "select Year to caliculate the premium", example = "1"
    	)
	private long year;
    @Column
    @NotBlank( message = "customerId can not be null or empty")
	@Schema(
		description = "customerId of the customer", example = "9271a6df-3a2c"
	)
	private String customerId;
    @Column
    @NotBlank( message = "paymentId can not be null or empty")
	@Schema(
		description = "paymentId of the customer", example = "pay_NwodIhujTHQwyG"
	)
    private String paymentId;

	private LocalDate startingDate;

	private LocalDate expiryDate;
    
	
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPremium() {
		return premium;
	}
	public void setPremium(long premium) {
		this.premium = premium;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public CustomerPaymentDetails(long id, long premium, long year, String customerId, String paymentId) {
		super();
		this.id = id;
		this.premium = premium;
		this.year = year;
		this.customerId = customerId;
		this.paymentId = paymentId;
	}
	public CustomerPaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	
}

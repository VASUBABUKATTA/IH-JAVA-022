package com.insurance.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
@Schema(
	name="StructureAndDetails",
	description = " Schema to hold Structure Details Information"
)
public class StructureAndDetails 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotEmpty( message = "MarketValue can not be a null or empty")
	@Pattern(regexp = "^[1-9][0-9]{6,}" ,message = " The market value should be between 1 lakh and 100 crores.  ")
	@Schema(
		description = "Market Value of the property", example = "1000000"
	)
	private String marketValue;
	@Column
@NotEmpty(message = "SquareFeet can not be null or empty")
@Pattern(regexp = "^[1-9][0-9]{2,}$", message = "The square feet value should be 100 to 1 lakh")
@Schema(
    description = "Square Feet Value of the property", example = "1000"
)
private String squareFeet;

	@Column
	@NotEmpty( message = "Pincode can not be a null or empty")
	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$" ,message = "Please provide a valid 6-digit PIN code.")
	@Schema(
		description = "PinCode Value of the property", example = "123456"
	)
	private String pincode;
	@Column
	@NotEmpty( message = "Pincode can not be a null or empty")
	// @Pattern(regexp = "^[1-9]{1}[0-9]{5}$" ,message = "Please provide a valid 6-digit PIN code.")
	@Schema(
		description = "buildingAge of the property", example = "0 to 5 Years"
	)
	@Pattern(regexp="^(?i)(0 to 5 Years|5 to 10 Years|10 to 15 Years|15 to 20 Years|20 to 25 Years)$", message="Building age must be one of the following ranges: 0 to 5 Years, 5 to 10 Years, 10 to 15 Years, 15 to 20 Years, or 20 to 25 Years (case insensitive)")

	private String buildingAge;
	@Column
	@NotEmpty( message = "Effeted can not be a null or empty")
	@Schema(
		description = "Effected of the property", example = "No"
	)
	@Pattern(regexp="^(?i)NO$",message="Effected can accept Only (Case Ignore) : No")
	private String effected;
	@Column
	@NotEmpty( message = "Security can not be a null or empty")
	@Schema(
		description = "security of the property", example = "yes"
	)
	@Pattern(regexp="^(?i)(YES|NO)$", message="security Person can accept only (case insensitive): Yes or No")
	private String security;
	@Column
	@NotEmpty( message = "Security can not be a null or empty")
	@Schema(
		description = "Person of the property", example = "yes"
	)
	@Pattern(regexp="^(?i)YES$",message="Salaried Person can accept Only (Case Ignore) : Yes")
	private String person;
	
	@Column
	// @NotEmpty( message = " can not be a null or empty")
	@Schema(
		description = "customer of the property", example = "No"
	)
	private String customerId;
    @Column
	// @NotEmpty( message = "Effeted can not be a null or empty")
	@Schema(
		description = "PaymentId of the property", example = "AlphaNumeric"
	)
    private String paymentId;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getBuildingAge() {
		return buildingAge;
	}
	public void setBuildingAge(String buildingAge) {
		this.buildingAge = buildingAge;
	}
	public String getEffected() {
		return effected;
	}
	public void setEffected(String effected) {
		this.effected = effected;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
	public StructureAndDetails(long id, String marketValue, String squareFeet, String pincode, String buildingAge,
			String effected, String security, String person, String customerId, String paymentId) {
		super();
		this.id = id;
		this.marketValue = marketValue;
		this.squareFeet = squareFeet;
		this.pincode = pincode;
		this.buildingAge = buildingAge;
		this.effected = effected;
		this.security = security;
		this.person = person;
		this.customerId = customerId;
		this.paymentId = paymentId;
	}
	public StructureAndDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}

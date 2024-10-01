package com.insurance.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
@Schema(
	name=" FillDetailsPage",
	description = " Schema to hold  Fill Details page Information"
)
public class FillDetailsPage 
{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty( message = "gender cannot be a null or empty")
	// @Pattern(regexp = "^[1-9][0-9]{5,}" ,message = " The market value should be between 1 lakh and 100 crores.  ")
	@Schema(
		description = "Gender of the user", example = "Mr/Mrs"
	)
	@Column
	private String gender;
	@Column
	@NotEmpty( message = "fullName can not be null or empty")
	@Pattern(regexp = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$" ,message = " Name must be 3 or more Charecters ")
	@Schema(
		description = "Name of the customer", example = "VasuBabu"
	)
	private String fullname;
	@Column
	@NotEmpty( message = "DOB can not be null or empty")
	// @Pattern(regexp = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$" ,message = " Name must be 3 or more Charecters ")
	@Schema(
		description = "Name of the customer", example = "2004-02-21"
	)
	 @ValidDate
	private String dob;
	@Column
	@NotEmpty( message = "PanCard can not be null or empty")
	@Pattern(regexp = "^[a-zA-Z]{5}\\d{4}[a-zA-Z]$" ,message = " Please enter 6 digits of pin ")
	@Schema(
		description = "PanCard of the customer", example = "AAAAA1111A"
	)
	private String pancard;
	
	@Column
	@NotEmpty( message = "Pincode can not be null or empty")
	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$" ,message = " Please enter 6 digits of pin ")
	@Schema(
		description = "Pincode of the customer", example = "123456"
	)
	private String  propertypincode;
	@Column
	@NotEmpty( message = "propertyhouseNo can not be null or empty")
	@Pattern(regexp = "^[A-Za-z\\d_-][A-Za-z0-9\\d_-]*([/-]?[A-Za-z0-9]([/-]?[\\da-zA-Z]+)?)?$" ,message = " Please enter valid flat No ")
	@Schema(
		description = "propertyhouseNo of the customer", example = "HouseNo"
	)
	private String  propertyhouseNo;
	@Column
	@NotEmpty( message = "propertystreetNo can not be null or empty")
	@Pattern(regexp = "^[A-Za-z0-9,-][A-Za-z0-9\\s,-.]*$" ,message = "Please enter valid street no")
	@Schema(
		description = "propertyhouseNo of the customer", example = "HouseNo"
	)
	private String propertystreetNo;
	@Column
	@NotEmpty( message = "currentaddress can not be null or empty")
	// @Pattern(regexp = "^[1-9]{1}[0-9]{5}$" ,message = " Please enter 6 digits of pin ")
	@Schema(
		description = "currentaddress of the customer", example = "yes"
	)
	private String currentaddress;
	
	@Column
	@NotEmpty( message = "Pincode can not be null or empty")
	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$" ,message = " Please enter 6 digits of pin ")
	@Schema(
		description = "Pincode of the customer", example = "123456"
	)
	private String  pincode;
	@Column
	@NotEmpty( message = "propertyhouseNo can not be null or empty")
	@Pattern(regexp = "^[A-Za-z\\d_-][A-Za-z0-9\\d_-]*([/-]?[A-Za-z0-9]([/-]?[\\da-zA-Z]+)?)?$" ,message = " Please enter valid flat No ")
	@Schema(
		description = "propertyhouseNo of the customer", example = "HouseNo"
	)
	private String houseno;
	@Column
	@NotEmpty( message = "propertystreetNo can not be null or empty")
	@Pattern(regexp = "^[A-Za-z0-9,-][A-Za-z0-9\\s,-.]*$" ,message = "Please enter valid street no")
	@Schema(
		description = "propertyhouseNo of the customer", example = "HouseNo"
	)
	private String streetno;
	
	@Column
	@NotBlank( message = "customerId can not be null or empty")
	@Schema(
		description = "customerId of the customer", example = "9271a6df-3a2c"
	)
	private String customerId;
    @Column
    @NotBlank( message = "PaymentId can not be null or empty")
	@Schema(
		description = "paymentId of the customer", example = "pay_NwodIhujTHQwyG"
	)
    private String paymentId;
    @Column
    @NotBlank( message = "city can not be null or empty")
	@Schema(
		description = "city of the customer", example = "Prathipadu"
	)
	private String city;
    @Column
    @NotBlank( message = "state can not be null or empty")
	@Schema(
		description = "state of the customer", example = "AP"
	)
	private String state;
    @Column
    @NotBlank( message = "propertycity can not be null or empty")
	@Schema(
		description = "propertycity of the customer", example = "Rachapalle"
	)
	private String propertycity;
    
    @Column
    @NotBlank( message = "propertystate can not be null or empty")
	@Schema(
		description = "propertystate of the customer", example = "TS"
	)
	private String propertystate;
    
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPropertycity() {
		return propertycity;
	}
	public void setPropertycity(String propertycity) {
		this.propertycity = propertycity;
	}
	public String getPropertystate() {
		return propertystate;
	}
	public void setPropertystate(String propertystate) {
		this.propertystate = propertystate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getPropertypincode() {
		return propertypincode;
	}
	public void setPropertypincode(String propertypincode) {
		this.propertypincode = propertypincode;
	}
	public String getPropertyhouseNo() {
		return propertyhouseNo;
	}
	public void setPropertyhouseNo(String propertyhouseNo) {
		this.propertyhouseNo = propertyhouseNo;
	}
	public String getPropertystreetNo() {
		return propertystreetNo;
	}
	public void setPropertystreetNo(String propertystreetNo) {
		this.propertystreetNo = propertystreetNo;
	}
	public String getCurrentaddress() {
		return currentaddress;
	}
	public void setCurrentaddress(String currentaddress) {
		this.currentaddress = currentaddress;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getStreetno() {
		return streetno;
	}
	public void setStreetno(String streetno) {
		this.streetno = streetno;
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
	public FillDetailsPage (long id, String gender, String fullname, String dob, String pancard, String propertypincode,
			String propertyhouseNo, String propertystreetNo, String currentaddress, String pincode, String houseno,
			String streetno, String customerId, String paymentId) {
		super();
		this.id = id;
		this.gender = gender;
		this.fullname = fullname;
		this.dob = dob;
		this.pancard = pancard;
		this.propertypincode = propertypincode;
		this.propertyhouseNo = propertyhouseNo;
		this.propertystreetNo = propertystreetNo;
		this.currentaddress = currentaddress;
		this.pincode = pincode;
		this.houseno = houseno;
		this.streetno = streetno;
		this.customerId = customerId;
		this.paymentId = paymentId;
	}
	public FillDetailsPage() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	

}

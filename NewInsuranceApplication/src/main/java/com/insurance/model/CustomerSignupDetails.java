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
	name=" customer signUp",
	description = " Schema to hold customer Information"
)
public class CustomerSignupDetails 
{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@NotEmpty( message = "mobile Number can not be a null or empty")
	@Pattern(regexp = "^[6-9][0-9]{9}$" ,message = " mobileNumber must start with 6-9 and have 10 digits  ")
	@Schema(
		description = "mobileNumber  of the customer ", example = "9876543210"
	)

	private String mobileno;
	@Column
	@Pattern(regexp = "^[A-Za-z][A-Za-z. ]{1,18}[A-Za-z. ]$", message = "UserName must be 3 or more charecters ex: abc")
	@NotEmpty( message = "Name can not be a null or empty")
	@Schema(
		description = "Name of the customer in the signUp ", example = "VasuBabu"
	)
	private String name;
	@Column
	@NotEmpty( message = "Email can not be a null or empty")
	@Pattern(regexp = "^(?!.*?\\.\\.)(?!.*?\\.(_|_\\.|\\._))([a-zA-Z0-9]+[a-zA-Z]*)(?:[._][a-zA-Z0-9]+)?(?:[._]?[a-zA-Z0-9]+)?@[a-zA-Z.]+(?:_[a-zA-Z0-9]+)?\\.[a-zA-Z]{2,3}$" ,message = " please provide valid email ")
	@Schema(
		description = "Email of the customer ", example = "sixAlphabets@gmail.com"
	)
	private String email;
	// @Column
	// @NotEmpty( message = "password can not be a null or empty")
	// @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$" ,message = " password  1 uppercase letter, 1 special symbol and 1 digit minlength 8  ")
	// @Schema(
	// 	description = "password of the customer ", example = "Vasu@babu"
	// )
	// private String password;
	@Column
	@NotEmpty( message = "customerId can not be null or empty")
	@Schema(
		description = "customerId of the customer", example = "9271a6df-3a2c"
	)
	private String customerId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// public String getPassword() {
	// 	return password;
	// }
	// public void setPassword(String password) {
	// 	this.password = password;
	// }
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public CustomerSignupDetails(long id,
			@NotEmpty(message = "mobile Number can not be a null or empty") @Pattern(regexp = "^[6-9][0-9]{9}$", message = " mobileNumber must start with 6-9 and have 10 digits  ") String mobileno,
			@Pattern(regexp = "^[A-Za-z][A-Za-z. ]{1,18}[A-Za-z. ]$", message = "UserName must be 3 or more charecters ex: abc") @NotEmpty(message = "Name can not be a null or empty") String name,
			@NotEmpty(message = "Email can not be a null or empty") @Pattern(regexp = "^(?!.*?\\.\\.)(?!.*?\\.(_|_\\.|\\._))([a-zA-Z0-9]+[a-zA-Z]*)(?:[._][a-zA-Z0-9]+)?(?:[._]?[a-zA-Z0-9]+)?@[a-zA-Z.]+(?:_[a-zA-Z0-9]+)?\\.[a-zA-Z]{2,3}$", message = " please provide valid email ") String email,
			String customerId) {
		super();
		this.id = id;
		this.mobileno = mobileno;
		this.name = name;
		this.email = email;
		this.customerId = customerId;
	}
	public CustomerSignupDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

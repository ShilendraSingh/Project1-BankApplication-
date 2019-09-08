package com.bank.app.dto;

public class RegistrationRequestDto {
	

	private String firstName;
	private String lastName;
	private Long mobileNo;
	private String email;
	private Long age;

	
	private String password;
	
	public RegistrationRequestDto() {
		super();
	}
	

	public Long getAge() {
		return age;
	}


	public void setAge(Long age) {
		this.age = age;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

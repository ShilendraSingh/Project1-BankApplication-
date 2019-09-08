package com.bank.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.dto.LoginDto;
import com.bank.app.dto.LoginResponseDto;
import com.bank.app.dto.RegistrationRequestDto;
import com.bank.app.dto.RegistrationResponseDto;
import com.bank.app.entity.Customer;
import com.bank.app.exeception.InvalidCredentialsException;
import com.bank.app.exeception.UserAlreadyAvailable;
import com.bank.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public LoginResponseDto customerLogin(LoginDto loginDto) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();

		/* get user object based on specific user */
		Customer customer = customerRepository.findByEmail(loginDto.getEmail());
		if (customer != null) {
			if (loginDto.getPassword().equalsIgnoreCase(customer.getPassword())) {

				loginResponseDto.setCustomerId(customer.getCustomerId());
				loginResponseDto.setFirstName(customer.getFirstName());
				loginResponseDto.setLastName(customer.getLastName());
				loginResponseDto.setMessage("User has  been logged in successfully");
				loginResponseDto.setStatusCode(201);
			} else {
				throw new InvalidCredentialsException("User/Password is wrong !!!");
			}
		} else {
			throw new InvalidCredentialsException("Invalid User");
		}
	

		return loginResponseDto;
	}


	@Override
	public RegistrationResponseDto registration(RegistrationRequestDto registrationRequestDto) {
		Customer customer = new Customer();
		
		RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
		
		Customer customer1 = customerRepository.findByEmail(registrationRequestDto.getEmail());
		if (customer1 == null) {

			customer.setEmail(registrationRequestDto.getEmail());
			
			customer.setFirstName(registrationRequestDto.getFirstName());
			customer.setLastName(registrationRequestDto.getLastName());
			customer.setMobileNo(registrationRequestDto.getMobileNo());
			customer.setPassword(registrationRequestDto.getPassword());
			customer.setAge(registrationRequestDto.getAge());
			
			
			
			Customer saveRegister = customerRepository.save(customer);
			registrationResponseDto.setStatusCode(201);
			registrationResponseDto.setStatus("Success");
			registrationResponseDto.setMessage("Registration Done");

			
		} else {
			throw new UserAlreadyAvailable("User Already exist");
		}
	
		return registrationResponseDto;
		


	}
}

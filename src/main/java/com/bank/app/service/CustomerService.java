package com.bank.app.service;

import org.springframework.stereotype.Service;

import com.bank.app.dto.LoginDto;
import com.bank.app.dto.LoginResponseDto;
import com.bank.app.dto.RegistrationRequestDto;
import com.bank.app.dto.RegistrationResponseDto;

@Service
public interface CustomerService {
	
	public LoginResponseDto customerLogin(LoginDto loginDto);

	public RegistrationResponseDto registration(RegistrationRequestDto registrationRequestDto);



}

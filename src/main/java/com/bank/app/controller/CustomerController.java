package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.dto.LoginDto;
import com.bank.app.dto.LoginResponseDto;
import com.bank.app.dto.RegistrationRequestDto;
import com.bank.app.dto.RegistrationResponseDto;
import com.bank.app.service.CustomerService;


	@RestController
	@RequestMapping("/api")
	@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
	
	public class CustomerController {
		
		@Autowired
		private CustomerService customerService;
		
		@PostMapping("/login")
		public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginDto loginDto) {

			
			return new ResponseEntity<>(customerService.customerLogin(loginDto), HttpStatus.CREATED);
		}

		
		@PostMapping("/register")
		public ResponseEntity<RegistrationResponseDto> register(
				@RequestBody RegistrationRequestDto registrationRequestDto) {
			
			return new ResponseEntity<>(customerService.registration(registrationRequestDto),
					HttpStatus.CREATED);
		}
}

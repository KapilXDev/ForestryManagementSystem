package com.cg.fms.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dao.UserDao;
import com.cg.fms.dao.AdminDao;
import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dao.RoleDao;
import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.ERole;
import com.cg.fms.dto.Role;
import com.cg.fms.dto.User;
import com.cg.fms.payload.request.LoginRequest;
import com.cg.fms.payload.request.SignupRequest;
import com.cg.fms.payload.response.JwtResponse;
import com.cg.fms.payload.response.MessageResponse;
import com.cg.fms.security.jwt.JwtUtils;
import com.cg.fms.security.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDao userRepository;

	@Autowired
	AdminDao adminRepository;

	@Autowired
	CustomerDao customerRepository;

	@Autowired
	RoleDao roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		//System.out.println(encoder.encode(loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		/*if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}*/

		// Create new user's account
		

		System.out.println(signUpRequest.getRole());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					Admin auser = new Admin(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()));
					auser.setRoles(roles);
					adminRepository.save(auser);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					User user = new User(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()));
					user.setRoles(roles);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
					Customer cuser = new Customer(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()));
					cuser.setRoles(roles);
					customerRepository.save(cuser);
				}
			});
		}

		
		//user.setAdminid(123); user.setAdminName("newName"); user.setAdminPassword("newPassword"); 
		//userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	@PostMapping("/firstsignup")
	public ResponseEntity<?> registerFirstUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		/*if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}*/

		// Create new user's account
		

		System.out.println(signUpRequest.getRole());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					Admin auser = new Admin(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()));
					auser.setRoles(roles);
					adminRepository.save(auser);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					User user = new User(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()));
					user.setRoles(roles);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
					Customer cuser = new Customer(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()));
					cuser.setRoles(roles);
					customerRepository.save(cuser);
				}
			});
		}

		
		//user.setAdminid(123); user.setAdminName("newName"); user.setAdminPassword("newPassword"); 
		//userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
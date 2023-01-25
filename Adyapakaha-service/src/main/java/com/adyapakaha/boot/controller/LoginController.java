package com.adyapakaha.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.adyapakaha.boot.model.JwtRequest;
import com.adyapakaha.boot.model.JwtResponse;
import com.adyapakaha.boot.service.LoginService;
import com.adyapakaha.boot.utility.JwtUtility;


@RestController
//@CrossOrigin(origins="http://localhost:8100")
public class LoginController {
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired JwtUtility jwtUtility;
	
	 @PostMapping("/authenticate")
	    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
	    	JwtResponse jwtResp = new JwtResponse();
	    	System.out.println("jwt-----"+ jwtRequest.getUsername()+ "  pwd="+ jwtRequest.getPassword());
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getUsername(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = loginService.loadUserByUsername(jwtRequest.getUsername());

	        final String token =
	                jwtUtility.generateToken(userDetails);
	        jwtResp.setJwtToken(token);
	        return  jwtResp;
	    }
}

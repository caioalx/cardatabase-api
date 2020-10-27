package com.packt.cardatabase.infra.security.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 8864_000_00; //1 1 day in milliseconds
	static final String SIGNINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";
	
	public static void addToken(HttpServletResponse res, String username) {
		String JwtToken = Jwts.builder().
				setSubject(username).
				setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)).
				signWith(SignatureAlgorithm.HS512, SIGNINGKEY).
				compact();
		
		res.addHeader("Authorization", PREFIX + " " + JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token != null) {
			String user = Jwts.parser().
					setSigningKey(SIGNINGKEY).
					parseClaimsJws(token.replace(PREFIX, "")).
					getBody().
					getSubject();
			
			if(user != null)
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
		}
		
		return null;
	}
}

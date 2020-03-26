package com.github.nossomercadolivre.security;

import com.github.nossomercadolivre.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Component
public class TokenManager {

	@Value("${jwt.secret:DefaultValueHereToSafeNullPointerException}")
	private String secret;
	
	@Value("${jwt.expiration:604800000}")
	private long expirationInMillis;

	public String generateToken(Authentication authentication) {
		
		User user = (User) authentication.getPrincipal();
		
		final Date now = new Date();
		final Date expiration = new Date(now.getTime() + this.expirationInMillis);
		
		return Jwts.builder()
			.setIssuer("Nosso Mercado Livre API")
			.setSubject(Long.toString(user.getId()))
			.setIssuedAt(now)
			.setExpiration(expiration)
			.signWith(HS256, this.secret)
			.compact();
	}

	public boolean isValid(String jwt) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt);
			return true;

		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	public Long getUserIdFromToken(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(this.secret)
				.parseClaimsJws(jwt).getBody();

		return Long.parseLong(claims.getSubject());
	}

}

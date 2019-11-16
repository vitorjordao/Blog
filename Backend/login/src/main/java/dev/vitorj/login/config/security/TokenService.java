package dev.vitorj.login.config.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import dev.vitorj.login.modelo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	
	@Value("${jwt.expiration}")
	private String expiration;

	private Key secret = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	public String generateToken(Authentication authentication) {
		User login = (User) authentication.getPrincipal();
		Date today = new Date();
		Date expirationDate = 
			new Date(today.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API")
				.setSubject(login.getId().toString())
				.setIssuedAt(today)
				.setExpiration(expirationDate)
				.signWith(this.secret, SignatureAlgorithm.PS512)
				.compact();
	}
	
	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUser(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret)
			.parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}

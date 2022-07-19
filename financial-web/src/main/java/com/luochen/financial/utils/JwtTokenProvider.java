package com.luochen.financial.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author luochenfx
 */
public class JwtTokenProvider {

	static final String SECRET_KEY = Constant.SECRET_KEY;

	public static SecretKey getSecretKey(){
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}

	public static String createToken(long expire, Claims claims){
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder jwtBuilder = Jwts.builder().setClaims(claims).setIssuedAt(now);
		jwtBuilder.signWith(getSecretKey(), signatureAlgorithm);
		if (expire > 0){
			Date expireTime = new Date(nowMillis + expire);
			jwtBuilder.setExpiration(expireTime);
		}
		return jwtBuilder.compact();
	}

	public static Claims getClaims(String token){
		if (!StringUtils.hasText(token)){
			return null;
		}
		JwtParser parser = Jwts.parserBuilder().setSigningKey(getSecretKey()).build();
		return parser.parseClaimsJws(token).getBody();
	}

}

package io.showtime.jwt;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public final class JwtUtils
{
	private static final Logger LOG = Logger.getLogger(JwtUtils.class.getName());

	private static final Key DEFAULT_KEY = MacProvider.generateKey();

	public static String createJWT(JwtClaimsComposer composer, long expireTime)
	{
		Claims claims = composer.getClaims();

		claims.setIssuedAt(new Date());
		claims.setExpiration(new Date(System.currentTimeMillis() + expireTime));

		final String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, DEFAULT_KEY).compact();

		return token;
	}

	public static String createJWT(JwtClaimsComposer composer, String key)
	{
		Claims claims = composer.getClaims();

		claims.setIssuedAt(new Date());

		final String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, key).compact();

		return token;
	}

	public static String createJWT(Map<String, Object> map)
	{
		Claims claims = Jwts.claims();
		claims.putAll(map);
		claims.setIssuedAt(new Date());

		final String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, DEFAULT_KEY).compact();

		return token;
	}

	public static Claims parseJWT(String token, String key)
	{
		Claims claims = null;

		try
		{
			claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		} catch (JwtException ex)
		{
			LOG.severe(ex.getMessage());
		}

		return claims;
	}

	public static Claims parseJWT(String token)
	{
		Claims claims = null;

		try
		{
			claims = Jwts.parser().setSigningKey(DEFAULT_KEY).parseClaimsJws(token).getBody();
		} catch (JwtException ex)
		{
			LOG.severe(ex.getMessage());
		}

		return claims;
	}
}

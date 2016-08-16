package io.showtime.jwt;

import java.util.Objects;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtClaimsComposer
{
	private final Claims claims = Jwts.claims();

	public String getUsername()
	{
		return (String) claims.get(JwtClaimsOption.USERNAME.name());
	}

	public void setUsername(String username)
	{
		if (Objects.nonNull(username))
		{
			claims.put(JwtClaimsOption.USERNAME.name(), username);
		}

	}

	public String getPassword()
	{

		return (String) claims.get(JwtClaimsOption.PASSWORD.name());
	}

	public void setPassword(String password)
	{
		claims.put(JwtClaimsOption.PASSWORD.name(), password);
	}

	public String getClientId()
	{
		return (String) claims.get(JwtClaimsOption.CLIETN_ID.name());
	}

	public void setClientId(String clientId)
	{
		if (Objects.nonNull(clientId))
		{
			claims.put(JwtClaimsOption.CLIETN_ID.name(), clientId);
		}

	}

	public String getDeviceId()
	{
		return (String) claims.get(JwtClaimsOption.DEVICE_ID.name());
	}

	public void setDeviceId(String deviceId)
	{
		if (Objects.nonNull(deviceId))
		{
			claims.put(JwtClaimsOption.DEVICE_ID.name(), deviceId);
		}

	}

	public Long getUserId()
	{
		return (Long) claims.get(JwtClaimsOption.USER_ID.name());
	}

	public void setUserId(Long userId)
	{
		if (Objects.nonNull(userId))
		{
			claims.put(JwtClaimsOption.USER_ID.name(), userId);
		}

	}

	public Claims getClaims()
	{
		return claims;
	}
}

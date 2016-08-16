package io.showtime.jwt;

import java.util.Objects;

import io.jsonwebtoken.Claims;

public class Token
{
	public Long userId = null;

	public String username = null;

	public String password = null;

	public String deviceId = null;

	public String clientId = null;

	public Claims claims = null;

	private Token()
	{

	}

	public static Token createFrom(Claims claims)
	{
		if (Objects.isNull(claims))
		{
			return null;
		}

		Token token = new Token();

		token.claims = claims;

		token.setUserId(Long.valueOf(String.valueOf(claims.get(JwtClaimsOption.USER_ID.name()))));
		token.setUsername(String.valueOf(claims.get(JwtClaimsOption.USERNAME.name())));
		token.setPassword(String.valueOf(claims.get(JwtClaimsOption.PASSWORD.name())));
		token.setClientId(String.valueOf(claims.get(JwtClaimsOption.CLIETN_ID.name())));
		token.setDeviceId(String.valueOf(claims.get(JwtClaimsOption.DEVICE_ID.name())));

		return token;

	}

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDeviceId()
	{
		return deviceId;
	}

	public void setDeviceId(String deviceId)
	{
		this.deviceId = deviceId;
	}

	public String getClientId()
	{
		return clientId;
	}

	public void setClientId(String clientId)
	{
		this.clientId = clientId;
	}
}

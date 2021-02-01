package com.conduit.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User{

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("image")
	private Object image;

	@JsonProperty("bio")
	private Object bio;

	@JsonProperty("id")
	private int id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("updatedAt")
	private String updatedAt;

	@JsonProperty("username")
	private String username;

	@JsonProperty("token")
	private String token;
}
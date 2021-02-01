package com.conduit.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author{

	@JsonProperty("image")
	private String image;

	@JsonProperty("following")
	private boolean following;

	@JsonProperty("bio")
	private Object bio;

	@JsonProperty("username")
	private String username;
}
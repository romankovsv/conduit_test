package com.conduit.api.response.articles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
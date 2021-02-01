package com.conduit.api.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User{

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;
}
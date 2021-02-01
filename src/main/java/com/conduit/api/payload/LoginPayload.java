package com.conduit.api.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginPayload {

	@JsonProperty("user")
	private User user;
}
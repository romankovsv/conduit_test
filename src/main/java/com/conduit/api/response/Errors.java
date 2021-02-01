package com.conduit.api.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Errors{

	@JsonProperty("email or password")
	private List<String> emailOrPassword;
}
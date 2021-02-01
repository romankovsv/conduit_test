package com.conduit.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddArticleResponse {

	@JsonProperty("article")
	private Article article;
}
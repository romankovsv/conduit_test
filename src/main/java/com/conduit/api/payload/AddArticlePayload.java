package com.conduit.api.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddArticlePayload{

	@JsonProperty("article")
	private Article article;
}
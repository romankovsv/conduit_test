package com.conduit.api.response.articles;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetArticlesResponse{

	@JsonProperty("articlesCount")
	private int articlesCount;

	@JsonProperty("articles")
	private List<ArticlesItem> articles;
}
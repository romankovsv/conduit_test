package com.conduit.api.response.articles;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ArticlesItem{

	@JsonProperty("tagList")
	private List<String> tagList;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("author")
	private Author author;

	@JsonProperty("description")
	private String description;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("favoritesCount")
	private int favoritesCount;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("updatedAt")
	private String updatedAt;

	@JsonProperty("favorited")
	private boolean favorited;
}
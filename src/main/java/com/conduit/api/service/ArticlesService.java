package com.conduit.api.service;

import com.conduit.api.payload.AddArticlePayload;
import com.conduit.api.payload.Article;
import com.conduit.api.response.AddArticleResponse;
import com.conduit.api.response.CredentialsInvalidResponse;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import static com.conduit.config.Configuration.expectsCode;
import static com.conduit.config.Configuration.getRequestSpec;
import static io.restassured.RestAssured.given;
import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;

public class ArticlesService {

    public void addRandomArticle(){

        Article article = Article.builder()
                .body(randomAlphabetic(10))
                .description(randomAlphabetic(10))
                .title(randomAlphabetic(10))
                .build();


        AddArticlePayload articlePayload = AddArticlePayload.builder()
                .article(article)
                .build();

        AddArticleResponse articleResponse = given(getRequestSpec())
                .body(articlePayload)
                .post("/api/articles")
                .then()
                .spec(expectsCode(200))
                .extract()
                .as(AddArticleResponse.class);

    }


    public void addRandomArticles(int numberOfArticlesToAdd){
        for (int i = 1; i <=numberOfArticlesToAdd ; i++) {
            addRandomArticle();
        }
    }

}

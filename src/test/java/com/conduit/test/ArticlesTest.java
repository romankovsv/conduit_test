package com.conduit.test;

import com.conduit.api.response.articles.GetArticlesResponse;
import com.conduit.config.MockTest;
import org.junit.jupiter.api.*;

import static com.conduit.config.Configuration.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class ArticlesTest extends MockTest {


    @Tag("tag")
    @DisplayName("Verify that number of articles is 10 and number of pages is 50")
    @Test
    public void verifyNumberOfArticlesAndPages() {

    atConduitHomePage()
                .verifyThatNumberOfArticlesOnPageIs(10)
                .verifyThatNumberOfPagesIs(50);

    }

    @Tag("tag")
    @DisplayName("Verify that number of articles is 12")
    @Test
    public void verifyThatNumberOfArticlesIs12() {

        GetArticlesResponse articlesResponse = given(getRequestMockSpec())
                .get("/api/articles")
                .then()
                .spec(expectsCode(200))
                .extract()
                .as(GetArticlesResponse.class);

        assertThat(articlesResponse.getArticles()
                .stream()
                .count()).isEqualTo(12);

        assertThat(articlesResponse.getArticlesCount()).isEqualTo(12);

    }




}

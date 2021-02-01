package com.conduit.config;

import com.conduit.config.BaseTest;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;

public class MockTest extends BaseTest {

    static WireMockServer server = new WireMockServer(4200);

    @BeforeAll
    public static void testSetup(){


        server.start();
        WireMock.configureFor("localhost", server.port());

        stubFor(get(urlEqualTo("/api/articles"))
                .willReturn(okJson("{\n" +
                        "  \"articles\": [\n" +
                        "    {\n" +
                        "      \"title\": \"blah\",\n" +
                        "      \"slug\": \"blah-sqqtox\",\n" +
                        "      \"body\": \"blah\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:12:51.834Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:12:51.834Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"blah\"\n" +
                        "      ],\n" +
                        "      \"description\": \"blah\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"nameless\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"blah2\",\n" +
                        "      \"slug\": \"blah-sqqtox2\",\n" +
                        "      \"body\": \"blah\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:12:51.834Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:12:51.834Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"blah\"\n" +
                        "      ],\n" +
                        "      \"description\": \"blah2\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"nameless2\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"blah1\",\n" +
                        "      \"slug\": \"blah-sqqtox1\",\n" +
                        "      \"body\": \"blah\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:12:51.834Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:12:51.834Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"blah\"\n" +
                        "      ],\n" +
                        "      \"description\": \"blah1\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"nameless1\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"blah blah\",\n" +
                        "      \"slug\": \"blah-blah-pdspqy\",\n" +
                        "      \"body\": \"albh\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:10:00.495Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:10:00.495Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"blah\"\n" +
                        "      ],\n" +
                        "      \"description\": \"blah\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"nameless\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"programming\",\n" +
                        "      \"slug\": \"programming-i7iunq\",\n" +
                        "      \"body\": \"sadgagasdf\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:08:28.795Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:08:28.795Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"java\"\n" +
                        "      ],\n" +
                        "      \"description\": \"sdgsdfs\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"nameless\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"etst\",\n" +
                        "      \"slug\": \"etst-wqylq5\",\n" +
                        "      \"body\": \"asdfasdf\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:05:42.058Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:05:42.058Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"dragons\"\n" +
                        "      ],\n" +
                        "      \"description\": \"setaet\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"ditest\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"this is a title\",\n" +
                        "      \"slug\": \"this-is-a-title-llz1zj\",\n" +
                        "      \"body\": \"this is an article body\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:05:30.788Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:05:30.788Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \n" +
                        "      ],\n" +
                        "      \"description\": \"this is a description\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"Me45\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"this is a title\",\n" +
                        "      \"slug\": \"this-is-a-title-z9roh5\",\n" +
                        "      \"body\": \"this is an article body\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:05:27.480Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:05:27.480Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \n" +
                        "      ],\n" +
                        "      \"description\": \"this is a description\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"Me45\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"this is a title\",\n" +
                        "      \"slug\": \"this-is-a-title-maa3vi\",\n" +
                        "      \"body\": \"this is an article body\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:05:23.880Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:05:23.880Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \n" +
                        "      ],\n" +
                        "      \"description\": \"this is a description\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"Me45\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"this is a title\",\n" +
                        "      \"slug\": \"this-is-a-title-fjuoul\",\n" +
                        "      \"body\": \"this is an article body\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:05:19.986Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:05:19.986Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \n" +
                        "      ],\n" +
                        "      \"description\": \"this is a description\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"Me45\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"Mollitia placeat ex\",\n" +
                        "      \"slug\": \"mollitia-placeat-ex-cfx14h\",\n" +
                        "      \"body\": \"Enim quasi sequi fac\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:04:37.769Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:04:37.769Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \"Est possimus eum d\"\n" +
                        "      ],\n" +
                        "      \"description\": \"Deleniti quasi possi\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"Tester228\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"title\": \"this is a title\",\n" +
                        "      \"slug\": \"this-is-a-title-trq7lt\",\n" +
                        "      \"body\": \"this is an article body\",\n" +
                        "      \"createdAt\": \"2021-02-01T13:03:53.708Z\",\n" +
                        "      \"updatedAt\": \"2021-02-01T13:03:53.708Z\",\n" +
                        "      \"tagList\": [\n" +
                        "        \n" +
                        "      ],\n" +
                        "      \"description\": \"this is a description\",\n" +
                        "      \"author\": {\n" +
                        "        \"username\": \"Me45\",\n" +
                        "        \"bio\": null,\n" +
                        "        \"image\": \"https://static.productionready.io/images/smiley-cyrus.jpg\",\n" +
                        "        \"following\": false\n" +
                        "      },\n" +
                        "      \"favorited\": false,\n" +
                        "      \"favoritesCount\": 0\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"articlesCount\": 12\n" +
                        "}")));


    }

    @AfterAll
    public static void tearDown(){
        server.stop();
    }
}

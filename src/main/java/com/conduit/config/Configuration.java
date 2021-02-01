package com.conduit.config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ResourceBundle;

import static io.restassured.http.ContentType.JSON;
import static java.util.Arrays.asList;

public class Configuration {

    private static ResourceBundle rb;
    private static final String uri;
    private static final String mock_uri;



    private static final String url;
    private static final RequestLoggingFilter requestLoggingFilter;
    private static final ResponseLoggingFilter responseLoggingFilter;

    static {
        rb = ResourceBundle.getBundle("config");
        uri = rb.getString("uri");
        url = rb.getString("url");
        mock_uri = rb.getString("mock.uri");
        requestLoggingFilter = new RequestLoggingFilter();
        responseLoggingFilter = new ResponseLoggingFilter();
    }

    public static String getUri() {
        return uri;
    }

    public synchronized ResourceBundle getRb() {
        return rb;
    }



    public synchronized static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .addFilters(asList(requestLoggingFilter, responseLoggingFilter, new AllureRestAssured()))
                .setBaseUri(uri)
                .addHeader("Content-Type", "application/json")
                .setAccept(JSON)
                .build();
    }

    public synchronized static RequestSpecification getRequestMockSpec() {
        return new RequestSpecBuilder()
                .addFilters(asList(requestLoggingFilter, responseLoggingFilter, new AllureRestAssured()))
                .setBaseUri(mock_uri)
                .addHeader("Content-Type", "application/json")
                .setAccept(JSON)
                .build();
    }

    public synchronized static ResponseSpecification expectsCode(int expectedCode) {
        switch (expectedCode) {
            case 200:
                return new ResponseSpecBuilder()
                        .expectStatusCode(200)
                        .build();
            case 201:
                return new ResponseSpecBuilder()
                        .expectStatusCode(201)
                        .build();
            case 400:
                return new ResponseSpecBuilder()
                        .expectStatusCode(400)
                        .build();
            case 403:
                return new ResponseSpecBuilder()
                        .expectStatusCode(403)
                        .build();
            case 404:
                return new ResponseSpecBuilder()
                        .expectStatusCode(404)
                        .build();
            case 422:
                return new ResponseSpecBuilder()
                        .expectStatusCode(422)
                        .build();
            case 500:
                return new ResponseSpecBuilder()
                        .expectStatusCode(500)
                        .build();
            default:
                throw new RuntimeException("Unexpected code: " + expectedCode);
        }
    }

    public static String getUrl() {
        return url;
    }
}

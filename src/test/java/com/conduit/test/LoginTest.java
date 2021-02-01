package com.conduit.test;

import com.conduit.api.payload.LoginPayload;
import com.conduit.api.payload.User;
import com.conduit.api.response.CredentialsInvalidResponse;
import com.conduit.api.response.LoginResponse;
import com.conduit.config.BaseTest;
import com.conduit.config.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.conduit.config.Configuration.expectsCode;
import static com.conduit.config.Configuration.getRequestSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {


    @Tag("login")
    @DisplayName("Login happy path verification")
    @Test
    public void loginWithValidCredentials() {

        Configuration configuration = new Configuration();

        User user = User.builder()
                .email(configuration.getRb().getString("user.email"))
                .password(configuration.getRb().getString("user.password"))
                .build();

        LoginPayload payload = LoginPayload.builder()
                .user(user)
                .build();

        LoginResponse loginResponse =  given(getRequestSpec())
                .body(payload)
                .post("/api/users/login")
                .then()
                .spec(expectsCode(200))
                .extract()
                .as(LoginResponse.class);

        assertThat(loginResponse.getUser().getEmail()).isEqualTo(payload.getUser().getEmail());
        assertThat(loginResponse.getUser().getId()).isNotNull();
        assertThat(loginResponse.getUser().getToken()).isNotBlank();
    }

    @Tag("login")
    @DisplayName("Login with invalid email verification")
    @Test
    public void loginWithInvalidEmail() {

        Configuration configuration = new Configuration();

        User user = User.builder()
                .email("invalid")
                .password(configuration.getRb().getString("user.password"))
                .build();

        LoginPayload payload = LoginPayload.builder()
                .user(user)
                .build();

        CredentialsInvalidResponse loginResponse =  given(getRequestSpec())
                .body(payload)
                .post("/api/users/login")
                .then()
                .spec(expectsCode(422))
                .extract()
                .as(CredentialsInvalidResponse.class);

        assertThat(loginResponse.getErrors().getEmailOrPassword().stream()
                .findFirst()
                .orElseThrow()).isEqualTo("is invalid");
    }

    @Tag("login")
    @DisplayName("Login with invalid password verification")
    @Test
    public void loginWithInvalidPassword() {

        Configuration configuration = new Configuration();

        User user = User.builder()
                .email(configuration.getRb().getString("user.email"))
                .password("invalid")
                .build();

        LoginPayload payload = LoginPayload.builder()
                .user(user)
                .build();

        CredentialsInvalidResponse loginResponse =  given(getRequestSpec())
                .body(payload)
                .post("/api/users/login")
                .then()
                .spec(expectsCode(422))
                .extract()
                .as(CredentialsInvalidResponse.class);

        assertThat(loginResponse.getErrors().getEmailOrPassword().stream()
                .findFirst()
                .orElseThrow()).isEqualTo("is invalid");
    }
}

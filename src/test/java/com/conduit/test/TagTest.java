package com.conduit.test;

import com.conduit.config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class TagTest extends BaseTest {

    @Tag("tag")
    @DisplayName("Verify that 'test' tag is present")
    @Test
    public void loginWithInvalidPassword() {

        List<String> allTags = atConduitHomePage()
                .getAllTags();

        assertThat(allTags.stream()
                .anyMatch(e -> e.equals("test"))).isTrue();

    }
}
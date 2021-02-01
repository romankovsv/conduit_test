package com.conduit.config;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.conduit.ui.page_objects.HomePage;
import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.codeborne.selenide.Selenide.page;


@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    protected Faker faker;

    public BaseTest() {
        faker = new Faker();
    }

    protected HomePage atConduitHomePage(){
        Selenide.open(com.conduit.config.Configuration.getUrl());
        return page(HomePage.class);
    }

    @BeforeAll
    public static void setUp(){

        Configuration.timeout = 20 * 1000;
        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled = true;
        Configuration.screenshots = false;
        Configuration.pageLoadStrategy  = "eager";
        Configuration.pageLoadTimeout = 15 * 1000;

        Configuration.browser = Browsers.CHROME;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--whitelisted-ips");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-extensions");
    }


}

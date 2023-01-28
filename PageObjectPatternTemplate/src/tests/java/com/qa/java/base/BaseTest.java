package com.qa.java.base;

import com.qa.java.factory.DriverFactory;
import com.qa.java.pages.*;
import org.testng.annotations.AfterTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


public class BaseTest {

        DriverFactory df;
        protected Properties prop;
        public WebDriver driver;

        protected LoginPage loginPage;
        protected AccountPage accPage;
        protected CommonsPage commPage;
        protected SearchResultsPage searchResultsPage;
        protected ProductInfoPage productInfoPage;
        protected RegisterPage regPage;


        protected SoftAssert softAssert;


        @BeforeTest
        public void setup() {

            df = new DriverFactory();
            prop = df.init_prop();
            driver = df.init_driver(prop);
            loginPage = new LoginPage(driver);
            softAssert = new SoftAssert();
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }



    }
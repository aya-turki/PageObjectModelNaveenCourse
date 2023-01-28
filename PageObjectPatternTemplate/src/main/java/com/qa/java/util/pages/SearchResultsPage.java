package com.qa.java.pages;


import com.qa.java.utility.Constants;
import com.qa.java.utility.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchResultsPage {

        private WebDriver driver;
        private ElementUtil eleUtil;

        private By resultsPageHeader = By.cssSelector("div#content h1");

        public SearchResultsPage(WebDriver driver) {
            this.driver = driver;
            eleUtil = new ElementUtil(this.driver);
        }

        public String getResultsPageHeader() {
            return eleUtil.doGetElementText(resultsPageHeader);
        }

        public ProductInfoPage selectProductName(String mainProductName) {
            WebElement mainProductEle =
                    eleUtil.waitForElementVisible(By.linkText(mainProductName), Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
            mainProductEle.click();
            return new ProductInfoPage(this.driver);
        }

    }

package com.qa.java.pages;

import com.qa.java.utility.Constants;
import com.qa.java.utility.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    // 1. private By locators: OR
    private By emailId = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");
    private By registerLink = By.linkText("Register");
    private By accLogoutMessage = By.cssSelector("div#content h1");


    // 2. public page class const...
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }

    // 3. public page actions/methods:
    public String getLoginPageTitle() {
        String title = eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
        System.out.println("login page title is: " + title);
        return title;
    }

    public String getLoginPageURL() {
        String url = eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
        System.out.println("login page url is: " + url);
        return url;
    }

    public boolean isForgotPwdLinkExist() {
        return eleUtil.waitForElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
    }

    public boolean isRegisterLinkExist() {
        return eleUtil.waitForElementVisible(registerLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
    }

    public AccountPage doLogin(String username, String pwd) {
        System.out.println(username + ":"+ pwd);
        eleUtil.waitForElementVisible(emailId, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).sendKeys(username);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(loginBtn);

        return new AccountPage(driver);
    }

    public String getLogoutMessage() {
        String logoutMesg = eleUtil.waitForElementVisible(accLogoutMessage, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT)
                .getText();
        System.out.println("Logout successful mesg === " + logoutMesg);
        return logoutMesg;
    }

    public RegisterPage navigateToRegisterPage() {
        eleUtil.doClick(registerLink);
        return new RegisterPage(driver);
    }

}

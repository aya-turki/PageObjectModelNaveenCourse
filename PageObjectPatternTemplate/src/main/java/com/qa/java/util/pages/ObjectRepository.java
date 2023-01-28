package com.qa.java.pages;

import org.openqa.selenium.By;

public class ObjectRepository {

    public By header = By.cssSelector("div#logo h1 a");
    public By accountSectionsHeader = By.cssSelector("div#content h2");
    public By logoutLink = By.linkText("Logout");
    public By search = By.name("search");

}

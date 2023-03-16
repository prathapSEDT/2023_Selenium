package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {
    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerLink;

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement login;

    @FindBy(css = "#small-searchterms")
    public WebElement searchBox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;
}

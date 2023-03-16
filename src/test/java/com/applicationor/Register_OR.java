package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_OR {
    @FindBy(css = "#gender-male")
    public WebElement genderMale;
    @FindBy(css = "#gender-female")
    public WebElement genderFeMale;
    @FindBy(css = "#FirstName")
    public WebElement firstName;
    @FindBy(css = "#LastName")
    public WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    public WebElement day;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement month;
    @FindBy(name = "DateOfBirthYear")
    public WebElement year;
    @FindBy(name = "Email")
    public WebElement email;
    @FindBy(css = "#Password")
    public WebElement password;
    @FindBy(css = "#ConfirmPassword")
    public WebElement ConfirmPassword;
    @FindBy(css="#register-button")
    public WebElement register;

    @FindBy(xpath = "//div[text()='Your registration completed']")
    public WebElement sucessMessage;
}

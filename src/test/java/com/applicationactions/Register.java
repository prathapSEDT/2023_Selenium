package com.applicationactions;

import com.applicationor.HomePage_OR;
import com.applicationor.Register_OR;
import com.genericmethods.WebUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Register extends WebUtils {
    Register_OR register_or= PageFactory.initElements(driver,Register_OR.class);

    public void registerUser(){
String gender=getData("InputData","Gender");
        String firstname=getData("InputData","First Name");
        String lastname=getData("InputData","Last Name");
        String day=getData("InputData","Day");
        String month=getData("InputData","Month");
        String year=getData("InputData","Year");
        String email=getData("InputData","Email");
        String companyName=getData("InputData","Company Name");
        String password=getData("InputData","Password");
        if(gender.toLowerCase().equals("male")){
            clickElement("Gender","Regsiter",register_or.genderMale);
        }else {
            clickElement("Gender","Regsiter",register_or.genderFeMale);
        }
        sendData("FirstName","Regsiter",register_or.firstName,firstname);
        sendData("Last Name","Regsiter",register_or.lastName,lastname);
selectDropDownByVisibleText("Day","Regsiter",register_or.day,day);
        selectDropDownByVisibleText("Month","Register",register_or.month,month);
        selectDropDownByVisibleText("Year","Register",register_or.year,year);
        sendData("Email","Register",register_or.email,email);
        sendData("Password","Register",register_or.password,password);
        sendData("Confirm Password","Register",register_or.ConfirmPassword,password);
        clickElement("Register","Register",register_or.register);
    }

    public void validateSucessMessage(){
        boolean status = checkElementIsExist("SucessMessage","Register",register_or.sucessMessage);
        Assert.assertEquals(true,status,"Unable to register user");
    }
}

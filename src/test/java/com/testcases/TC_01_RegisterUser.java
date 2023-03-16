package com.testcases;

import com.annotations.TestNgAnnotations;
import com.applicationactions.HomePage;
import com.applicationactions.Register;
import org.testng.annotations.Test;

public class TC_01_RegisterUser extends TestNgAnnotations {
    @Test
    public void RegisterUser(){
        HomePage homePage=new HomePage();
        homePage.navigateToRegisterPage();


        Register register=new Register();
        register.registerUser();
        register.validateSucessMessage();
    }
}

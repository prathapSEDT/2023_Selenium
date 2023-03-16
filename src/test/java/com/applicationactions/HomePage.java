package com.applicationactions;

import com.applicationor.HomePage_OR;
import com.genericmethods.WebUtils;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebUtils {
    HomePage_OR homePage_or= PageFactory.initElements(driver,HomePage_OR.class);

    //navigate to registration page

    public void navigateToRegisterPage(){
        clickElement("Register","Home",homePage_or.registerLink);
    }

}

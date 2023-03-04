package com.selenium_topics;

import com.excelreader.ExcelUtil;
import com.genericmethods.WebUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LaunchApp {
    public static void main(String[] args) throws IOException {
        ExcelUtil excelUtil=new ExcelUtil();
        excelUtil.loadExcelFile();

        WebUtils utils=new WebUtils();
        utils.loadPropertiesFile();
        WebDriver driver=utils.launchBrowser();
        driver.findElement(By.linkText("Register")).click();
        //identify register header on the web page
        String gender=excelUtil.getData("InputData","TC_01","Gender");
        //gender
        if(gender.equals("Male")){
driver.findElement(By.id("gender-male")).click();
        }else {
            driver.findElement(By.id("gender-female")).click();
        }
        String firstName=excelUtil.getData("InputData","TC_01","First Name");
        WebElement firstNameWeb=driver.findElement(By.id("FirstName"));
        utils.sendData("FirstName","Registration",firstNameWeb,firstName);


        //identify the dropdown
        WebElement day=driver.findElement(By.name("DateOfBirthDay"));
        Select select=new Select(day);
        List<WebElement> optionsList=select.getOptions();
        for(WebElement option:optionsList){
           String text=option.getText();
            select.selectByVisibleText(text);
        }

//        System.out.println(optionsList.size());
//        System.out.println(select.getFirstSelectedOption().getText());



    }
}

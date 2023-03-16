package com.genericmethods;

import com.excelreader.ExcelUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebUtils extends ExcelUtil {
    public static WebDriver driver;
    public static Properties properties;
    Logger logger=Logger.getLogger(this.getClass().getName());
    public  WebDriver launchBrowser(){
        String env=getProperty("ENV_EXECUTE");
        String url=getProperty(env+"_URL");
        String browser=getProperty("BROWSER");
        logger.log(Level.INFO,"Launching browser "+browser);
        switch (browser.toLowerCase().trim()){
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                // parent p = new child();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        logger.log(Level.INFO,"Browser launched successfully");
        return driver;
    }



    public void loadPropertiesFile(){
        logger.log(Level.INFO,"Loading properties files");
        try {
            File file=new File("src/test/resources/config/app-config.properties");
            FileInputStream fis=new FileInputStream(file);
            properties=new Properties();
            properties.load(fis);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public boolean checkElementIsExist(String webElementName, String pageName,WebElement element){
        boolean status = false;
        try{

            if(element.isDisplayed()){
                System.out.println(webElementName+" is displayed on the page "+pageName);
                status=true;
            }else {
                System.out.println(webElementName+" is not displayed on the page "+pageName);
            }
        }catch (Exception e){
            System.out.println(webElementName+" is not displayed on the page "+pageName);
        }
return status;
    }

    public boolean checkRadio_CheckBox_IsSelected(String webElementName, String pageName,WebElement element){
        boolean status = false;
        try{

            if(element.isSelected()){
                System.out.println(webElementName+" is  selected on the page "+pageName);
                status=true;
            }else {
                System.out.println(webElementName+"  is not selected on the page "+pageName);
            }
        }catch (Exception e){
            System.out.println(webElementName+"  is not identified on the page "+pageName);
        }
        return status;
    }


    public void sendData(String webElementName, String pageName,WebElement element, String data) {
    logger.log(Level.INFO,"Entering data into the element :"+webElementName+" on the page :"+pageName);
      element.click();
      element.clear();
      element.sendKeys(data);
      element.sendKeys(Keys.TAB);
    }

    public void clickElement(String webElementName, String pageName,WebElement element) {
        logger.log(Level.INFO,"Click the element :"+webElementName+" on the page :"+pageName);
        Actions actions=new Actions(driver);
        actions.moveToElement(element).click(element).build().perform();
    }

    public void selectDropDownByVisibleText(String webElementName, String pageName,WebElement element, String option){
        logger.log(Level.INFO,"Select the dropdown :"+webElementName+" on the page :"+pageName);
        Select select=new Select(element);
        select.selectByVisibleText(option);
    }

    public void selectDropDownByValue(String webElementName, String pageName,WebElement element, String option){
        logger.log(Level.INFO,"Select the dropdown :"+webElementName+" on the page :"+pageName);
        Select select=new Select(element);
        select.selectByValue(option);
    }

    public void selectDropDownByIndex(String webElementName, String pageName,WebElement element, int optionIndex){
        logger.log(Level.INFO,"Select the dropdown :"+webElementName+" on the page :"+pageName);
        Select select=new Select(element);
        select.selectByIndex(optionIndex);
    }

}

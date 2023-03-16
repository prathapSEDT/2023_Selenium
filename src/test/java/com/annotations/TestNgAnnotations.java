package com.annotations;

import com.excelreader.ExcelUtil;
import com.genericmethods.WebUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class TestNgAnnotations {
    public SoftAssert softAssert=new SoftAssert();
    @BeforeSuite
    public void beforeSuite(){
        WebUtils utils=new WebUtils();
        utils.loadPropertiesFile();
        utils.launchBrowser();

        ExcelUtil excelUtil=new ExcelUtil();
        excelUtil.loadExcelFile();
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
        softAssert.assertAll();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        ExcelUtil.testCaseName=method.getName();
    }

}
